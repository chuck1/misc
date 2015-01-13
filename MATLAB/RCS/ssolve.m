function [ f ] = ssolve( f,var )
%UNTITLED10 Summary of this function goes here
%   Detailed explanation goes here
syms temp
f=subs(solve(subs(f,var,temp),temp),temp,var);

end

