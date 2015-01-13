close all
clear all
clc


alpha = logspace(-3,3,100);

Nu = heat.convection.internal.laminar.rectangular.SL1978( 1 ./ alpha,'H1','Case 4' );

% Nu_a = Nu * 2 .* (alpha + 1);
Nu_a = Nu;

Nu = heat.convection.internal.laminar.rectangular.SL1978( alpha,'H1','Case 4' );

% Nu_b = Nu * 2 .* (1./alpha + 1);
Nu_b = Nu;

Nu = heat.convection.internal.laminar.rectangular.MH1955( min(alpha,1./alpha) );

Nu_ver = Nu_a ./ (1+alpha) + Nu_b ./ (1+1./alpha);

figure()
loglog(alpha,Nu_ver,alpha,Nu)