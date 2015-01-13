function [ mdot,dp,eta,Re,Nu,T,v_max,L,N_L,v,A_hs ] = unit_cell_design_func( D,P_T,f,N_L,alpha_H )
%UNTITLED2 Summary of this function goes here
%   Detailed explanation goes here
S_T = D * P_T;
S_L = sqrt(3)/2*S_T;
H = 2*alpha_H*(S_T-D);
A_min = (S_T-D)*H;
w = S_T;


alpha_L_in = 1;
alpha_L_out = 1;
L_in = alpha_L_in*H;
L_out = alpha_L_out*H;

%% constants


qpp = 1e6;
dh  = 184763.21225;

T_av = 848.15;

rho = CO2.density(T_av);
pr = CO2.prandtl(T_av);
mu = 36.7e-6;
k_f = CO2.conductivity(T_av);

T_av = 848.15;
sigma = 5.67e-8;
epsilon = 0.95;
h_nat = 15;
T_inf = 293.15;

%% velocity

A_hs = w*(N_L*S_L+L_in+L_out);

mdot = qpp*A_hs/dh;

v_max = mdot/rho/A_min;

%% duct pressure drop

dp = N_L*(rho*v_max^2/2)*f;

%% efficiency

Re = rho*D*v_max/mu;

% Incropera eq 7.64
C =...
    ((Re>1e3)&&(Re<=2e5)) * 0.35*(S_T/S_L)^(1/5) +...
    (Re>2e5) * 0.21;
m =...
    ((Re>1e3)&&(Re<=2e5)) * 0.6 +...
    (Re>2e5) * 0.84;

Nu = C*Re^m*pr^0.36*(pr/pr)^(0.25);

h = k_f*Nu/D;

dT1 = qpp/h;

dT2=0;
T = T_av + dT1 + dT2;

eta = qpp/(qpp + sigma*epsilon*(T^4-T_inf^4) + h_nat*(T-T_inf));

L = N_L*S_L;

A_cs = w*H;

v = mdot/rho/A_cs;

end

