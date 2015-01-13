close all
clear all
clc

L = 0.01;
P = 1e7;
h = 0.003:0.0001:0.01;


sigma = P*L^2./h.^2;

plot(h,sigma);hold on
plot([h(1) h(end)],[1 1]*38e6,'r')
xlabel('h (m)')
ylabel('\sigma (Pa)')

sigma = 38e6;
h = sqrt(P*L^2./sigma)