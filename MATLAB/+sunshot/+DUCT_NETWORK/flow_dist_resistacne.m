function [ C ] = flow_dist_resistacne( W,H,L,dp,rho,mu )
%UNTITLED Summary of this function goes here
%   Detailed explanation goes here


A = W*H;
P = 2*(W+H);
d = 4*A/P;
f = 0.5;

C = f*L/(2*d*rho*A^2);

mdot = sqrt(abs(dp)/C);
v = mdot/rho/A;
Re = rho*d*v/mu;
f = fRe(W/H)/Re;

C = f*L/(2*d*rho*A^2);

end

