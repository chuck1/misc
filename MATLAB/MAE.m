function [ E ] = MAE( f,x,y )
%UNTITLED4 Summary of this function goes here
%   Detailed explanation goes here
E = abs((f(x)-y)/y);
E = mean(E);

end