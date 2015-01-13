function [ f ] = sdiff( f,var )
%UNTITLED9 Summary of this function goes here
%   Detailed explanation goes here
syms temp
f=subs(diff(subs(f,var,temp),temp),temp,var);

end

