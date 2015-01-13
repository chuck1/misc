clear all
close all
clc

n = 100;

q = 100;

T_in = 500+273.15;
T_out = 650+273.15;
T_avg = (T_in+T_out)/2;

enthalpy_in = co2('h','T',T_in);
enthalpy_out = co2('h','T',T_out);

cp = co2('cp','T',T_avg);
rho = co2('rho','T',T_avg);
mu = co2('mu','T',T_avg);
k = co2('k','T',T_avg);

%% inputs
param = 0:0.001:100e-3;
paramstr = 'length [m]';

W = 200e-6*ones(1,length(param));
W_wall = 100e-6;

%% geometric

H = 1000e-6;
L = param;

A = W.*H;
P = 2*(W+H);
D = 4*A./P;

%% compute

Nu = 6;

h = Nu*k./D;

dt = (W+W_wall)*q./P./h;

m = q.*(W+W_wall).*L/(enthalpy_out-enthalpy_in);

V = m/rho./A;

Re = rho*D.*V/mu;
f = 64./Re;
h_f = f.*(L./D).*(rho*V.^2/2);

dp = h_f;

pow = m/rho.*dp;

%% plot

figure(1)
semilogy(param,dp,[param(1) param(end)],[35000 35000])
ylabel('pressure drop [Pa]')
xlabel(paramstr)
figure(2)
plot(param,dt)
ylabel('temperature different [K]')
xlabel(paramstr)
figure(3)
plot(param,pow)
ylabel('pumping power [K]')
xlabel(paramstr)