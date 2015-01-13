close all
clear all
clc

x1 = 1e-2;
y1 = 0.9e6;
y0 = 1.4e6;

x = linspace( -x1, x1, 101 );



a = -(y1 - y0)/x1^2;

y = -a*x.^2 + y0;

plot(x,y);

f = @(x) -1/3*a*x^3 + y0*x;

Y = ( f(x1)-f(-x1) )/( 2*x1 );

