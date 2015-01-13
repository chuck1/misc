function [ P ] = powerfit( x,y,x0,y0 )
%UNTITLED3 Summary of this function goes here
%   Detailed explanation goes here
X = log(x/x0);
Y = log(y/y0);
P = polyfit(X,Y,1);
P=[P(1) x0 y0];

end

