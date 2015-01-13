function tess()
close all
clc

v{1,1}=[1,0,0];
v{1,2}=[0,1,0];
v{1,3}=[0,0,1];

X=zeros(3,1);
Y=zeros(3,1);
Z=zeros(3,1);

[v] = subtri(v,1,4);

for k=1:size(v,1)
    for i=1:3
        X(i,k)=v{k,i}(1);
        Y(i,k)=v{k,i}(2);
        Z(i,k)=v{k,i}(3);
    end
end

C=[1,0.5,0];

fill3(X,Y,Z,C);

axis equal

end
function [vret] = subtri(v,k,depth)
depth=depth-1;

vnew=cell(3,1);

for m=1:3
    vnew{m}=zeros(1,3);
    for i=1:3
        if i~=m
            vnew{m}=vnew{m}+v{k,i};
        end
    end
    vnew{m}=vnew{m}/sqrt(dot(vnew{m},vnew{m}));
end

vret=v;

ind=[k,size(v,1)+1,size(v,1)+2,size(v,1)+3];

for m=1:3
    n=ind(m);
    for i=1:3
        if i~=m
            vret{n,i}=vnew{i};
        else
            vret{n,i}=v{k,i};
        end
    end
end

m=4;
n=ind(m);
for i=1:3
    vret{n,i}=vnew{i};
end

if depth>0
    for m=1:4
        [vret] = subtri(vret,ind(m),depth);
    end
end
end