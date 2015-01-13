%SUDOKU Solve Sudoku Puzzle
function [A] = sudoku

hfig = figure;
set(hfig,'Position',[300 300 30*9 30*10])
hedit{9,9} = {};
for a = 1:9
    for b = 1:9
        hedit{a,b} = uicontrol('Style','edit','String','','Position',[30*(b-1) 30*(10-a) 30 30]);
    end
end
uicontrol('Style','pushbutton','Position',[0 0 120 30],'Callback',@Callback_pushbutton);

uiwait
A = zeros(9);
for a = 1:9
    for b = 1:9
        if isempty(get(hedit{a,b},'String'))
            A(a,b) = 0;
        else
            A(a,b) = str2double(get(hedit{a,b},'String'));
        end
    end
end
close(hfig)

A=reshape(A',1,81);
P=ones(9,81);
R=zeros(9,81);
C=R; B=R;
for x=1:81
    R((x-mod(x-1,9)+8)/9,x)=1;
    C(mod(x-1,9)+1,x)=1;
    B((3*mod(x-1,9)-3*mod(x-1,3)+x+8-mod(x-1,27))/9,x)=1;
end
a=1;
[A, P]=dumb(A,P,R,C,B);
while sum(A)<405
    Elim=P;
    if a==82, return; end
    while A(a)>0
        a=a+1;
        if a==82, return; end
    end
    J=sort(P(:,a).*(1:9)','ascend');
    J=J(10-sum(P(:,a)):9);
    for b=1:sum(P(:,a))
        At=A;
        At(a)=J(b);
        [~, Pt]=dumb(At,P,R,C,B);
        Elim=(Elim==(P-Pt))&((P-Pt)>0);
    end
    P=P-Elim;
    [A, P]=dumb(A,P,R,C,B);
    a=a+1;
end
A=reshape(A,9,9)';

end

function [Ao, Po] = dumb(A,P,R,C,B)

f=@(x) 1+(x-1-mod(x-1,9))/9;
g=@(x) 1+mod(x-1,9);
h=@(x) 1+(x-1-mod(x-1,3))/3-3*(x-1-mod(x-1,9))/9+3*(x-1-mod(x-1,27))/27;
while 1==1
    P=(P-ones(9,1)*(A>0))>0;
    for a=1:81
        P=(P-double(A(a)*ones(9,1)==(1:9)')*double((R(f(a),:)+C(g(a),:)+B(h(a),:))>0))>0;
    end
    P=P+((ones(9,1)*A)==((1:9)'*ones(1,81)));
    Ao=(sum(P)==1).*((1:9)*P);
    for a=1:9
        M=(1:9)*(((ones(9,1)*R(a,:)).*P).*((sum((ones(9,1)*R(a,:)).*P,2)==1)*ones(1,81)));
        N=(1:9)*(((ones(9,1)*C(a,:)).*P).*((sum((ones(9,1)*C(a,:)).*P,2)==1)*ones(1,81)));
        O=(1:9)*(((ones(9,1)*B(a,:)).*P).*((sum((ones(9,1)*B(a,:)).*P,2)==1)*ones(1,81)));
        Ao=Ao+((M~=Ao)&(M>0)).*M;
        Ao=Ao+((N~=Ao)&(N>0)).*N;
        Ao=Ao+((O~=Ao)&(O>0)).*O;
    end
    Po=P;
    if sum(A)==sum(Ao), break, end
    A=Ao;
end

end

function Callback_pushbutton(hObject,Event)

uiresume

end