close all
clear all
clc

n = 1000;

x = linspace(-1,1,n);
y = x*1i;

[X,Y] = meshgrid(x,y);

m = zeros(size(X));



h = waitbar(0,'calc');
for a = 1:numel(X)
    waitbar(a/numel(X))
    m(a) = bounded(X(a) + Y(a));
end
close(h)

save('mand1','x','y','m')

contourf(m)