function [Z] = normal2(x0,y0,sigma,X,Y)
Z=1/sigma/(2*pi)^(1/2)*exp(-((X-x0).^2+(Y-y0).^2)/2/sigma^2);
