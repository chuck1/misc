function [h] = arrow(x,y,l,w0,w1,theta,originoption,varargin)
%UNTITLED4 Summary of this function goes here
%   Detailed explanation goes here
X0=[w0/2 w0/2   w1/2   0 -w1/2  -w0/2  -w0/2];
Y0=[0    l-w1/2 l-w1/2 l l-w1/2 l-w1/2 0];

if strcmp(originoption,'head')==1
    Y0=Y0-l;
end

X=X0*cos(theta)-Y0*sin(theta);
Y=X0*sin(theta)+Y0*cos(theta);
X=X+x;
Y=Y+y;

h=fill(X,Y,'w');
arg=varargin;
while length(arg)>=2
    set(h,arg{1},arg{2})
    arg(1:2)=[];
end