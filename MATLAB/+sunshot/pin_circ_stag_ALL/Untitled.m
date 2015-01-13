close all
clear all
clc

load('M')
Re=M(:,1);
f=M(:,2);
P_T=M(:,3);

plot(Re(P_T==1.5),f(P_T==1.5),'bo');hold on
plot(Re(P_T==1.4),f(P_T==1.4),'ro')
plot(Re(P_T==1.3),f(P_T==1.3),'go')
plot(Re(P_T==1.1),f(P_T==1.1),'mo')

xlabel('Re')
ylabel('f')

axis([0 2.5e4 0.2 0.8])
legend('1.5','1.4','1.3','1.1')