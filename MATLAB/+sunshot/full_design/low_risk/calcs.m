close all;clear all;clc

m = 0.0011;

w_h = 0.02;
l_h = 0.01;

D = 500e-6;

rho = 61.4;
mu = 37e-6;

N_tube = 19;

A_tube = pi*D^2/4;

v_tube = m/rho/(A_tube*N_tube);

Re = rho*D*v_tube/mu;