close all;clear all;clc

dt = 0.1;
tfinal = 20;

X0=[0;0;2;0;0];
Xp0=[1;0;0;0;1];
m1=10;
m2=10;
I1=1;
I2=1;

[ t,X ] = solv( X0,Xp0,dt,tfinal,m1,m2,I1,I2 );

%% plot
close all

plot(X(1,:),X(2,:));hold on

x2=@(x,D,L,p)x-L.*cos(p)-D.*sin(p);
y2=@(y,D,L,p)y-L.*sin(p)+D.*cos(p);

plot(x2(X(1,:),X(3,:),X(4,:),X(5,:)),y2(X(2,:),X(3,:),X(4,:),X(5,:)))

figure()
for n=1:length(t)
    hold off
    circle(X(1,n),X(2,n),0.25);hold on
    circle(x2(X(1,n),X(3,n),X(4,n),X(5,n)),y2(X(2,n),X(3,n),X(4,n),X(5,n)),0.25)
    axis equal
    pause(0.1)
end