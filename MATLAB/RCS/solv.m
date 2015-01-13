function [ t,X ] = solv( X0,Xp0,dt,tfinal,m1,m2,I1,I2 )
%UNTITLED6 Summary of this function goes here
%   Detailed explanation goes here
%% initialize
t=0:dt:tfinal;

load('func')

X=zeros(5,length(t));
Xp=zeros(5,length(t));
Xpp=zeros(5,length(t));

X(:,1)=X0;
Xp(:,1)=Xp0;

maxit=20;
%% solve
for n=2:length(t)
    Xp(:,n) = Xp(:,n-1);
    X(:,n) = X(:,n-1);
    
    for it=1:maxit
        for a=1:5
            Xpp(a,n) = func{a}(X(1,n),X(2,n),X(3,n),X(4,n),X(5,n),...
                Xp(1,n),Xp(2,n),Xp(3,n),Xp(4,n),Xp(5,n),...
                Xpp(1,n),Xpp(2,n),Xpp(3,n),Xpp(4,n),Xpp(5,n),...
                m1,m2,I1,I2); %#ok<USENS>
            Xp(a,n) = Xp(a,n-1) + Xpp(a,n)*dt;
            X(a,n) = X(a,n-1) + Xp(a,n)*dt;
        end
        
    end
    
end

end

