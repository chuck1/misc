function [ t,x ] = Untitled3( dt )
%UNTITLED3 Summary of this function goes here
%   Detailed explanation goes here
m1=10;
m2=5;
D=3;
L=0;
pp=1;

xpp=@(p)-m2/(m1+m2)*(L*cos(p)+D*sin(p))*pp^2;

%% initialize
t=0:dt:100;

xp=zeros(size(t));
x =zeros(size(t));
p =zeros(size(t));

p(1)=0;
x(1)=0;
xp(1)=1;

%% solve
for n=2:length(t)
    p(n) = p(n-1) + pp*dt;
    
    
    xp(n) = xp(n-1) + xpp(p(n))*dt;
    
    
    x(n)  = x(n-1)  + xp(n)*dt;
end

end

