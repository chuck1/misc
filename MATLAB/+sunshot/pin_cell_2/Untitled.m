qpp = 1e6;
dh  = 184763.21225;



D = 700e-6;
P_T = 1.5;
alpha_H = 1; % H/G
L = 1e-2;



S_T = D*P_T;
G = S_T-D;
H = alpha_H*G;



A_hs = S_T*L;

mdot = qpp*A_hs/dh;

fprintf('1 S_T by 1 H:     mdot: %e\n',mdot)
fprintf('1/2 S_T by 1/2 H: mdot: %e\n',mdot/4)

M = [D P_T mdot/4];
csvwrite('csv_param.csv',M);