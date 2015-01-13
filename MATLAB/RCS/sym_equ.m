close all;clear all;clc

syms x(t) y(t) D(t) L(t) p(t)
syms m1 m2 I1 I2 k
% syms xp(t) yp(t) Dp(t) Lp(t) pp(t)...
%     xpp(t) ypp(t) Dpp(t) Lpp(t) ppp(t) 

x1=x;
y1=y;

x2=x1-L*cos(p)-D*sin(p);
y2=y1-L*sin(p)+D*cos(p);

x1p=diff(x1,t);
y1p=diff(y1,t);

x2p=diff(x2,t);
y2p=diff(y2,t);

pp = diff(p,t);

T=1/2*m1*(x1p^2+y1p^2)+1/2*m2*(x2p^2+y2p^2)+1/2*I1*pp^2+1/2*I2*pp^2;
V=1/2*k*D^2;
Lag=T-V;
