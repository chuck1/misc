function [ v_t,v_n ] = vel_comp( X,x,v )
%UNTITLED2 Summary of this function goes here
%   Detailed explanation goes here
r = x - X;

rhat = r/mag(r);

v_n = rhat*dot(v,rhat);

v_t = v - v_n;

end

