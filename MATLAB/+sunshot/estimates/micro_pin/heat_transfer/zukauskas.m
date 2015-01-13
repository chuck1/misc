function [ T_s ] = zukauskas( Re,D )
%UNTITLED2 Summary of this function goes here
%   Detailed explanation goes here
T = 848.15;
T_s = T;

qpp =1e6;

C =...
    ((Re>1e3)&&(Re<2e5)) * 0.35*(sqrt(3)/2);
m =...
    ((Re>1e3)&&(Re<2e5)) * 0.6;

pr   = CO2.prandtl(T);
pr_s = CO2.prandtl(T_s);
k    = CO2.conductivity(T);

Nu = C*Re^m*pr*(pr/pr_s)^0.25;
h = Nu*k/D;

T_s = T + qpp/h;

end

