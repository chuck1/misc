function [  ] = circle( x0,y0,r )
%CIRCLE Draws a circle in the current axes.
%   circle(x,y,r) draws a circle a (x,y) of radius r in the current axes.

theta = linspace(0,2*pi,64);
x = x0+r*cos(theta);
y = y0+r*sin(theta);
plot(x,y);

end

