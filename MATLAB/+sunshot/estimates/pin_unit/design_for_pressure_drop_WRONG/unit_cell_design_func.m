function [ mdot,dp,eta,Re,Nu,T,v_max,L,N_L,v ] = unit_cell_design_func( D,P_T,f )
%UNTITLED2 Summary of this function goes here
%   Detailed explanation goes here
S_T = D * P_T;
S_L = sqrt(3)/2*S_T;
H = 4*(S_T-D);
A_min = (S_T-D)*H;
w = S_T;

%% constants
dp  = 28000;
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

C_1 = 2*dp*S_L / ( rho*f );

C_2 = ( rho*A_min*dh ) / ( w*qpp );

v_max = (C_1/C_2)^(1/3);

mdot = rho*A_min*v_max;

%% unit cell pressure drop

dp = 2*(rho*v_max^2/2)*f;

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

L = C_1/v_max^2;

N_L=L/S_L;

A_cs = w*H/2;

A_hs = w*(N_L*S_L);
mdot2 = qpp*A_hs/dh;

v = mdot/rho/A_cs;

end

