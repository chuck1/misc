function [ mdot ] = global_mdot( A )
%UNTITLED3 Summary of this function goes here
%   Detailed explanation goes here
qpp = 1e6;
dh  = 184763.21225;
mdot = A*qpp/dh;

end

