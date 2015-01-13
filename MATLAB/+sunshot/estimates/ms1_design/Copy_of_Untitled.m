function Copy_of_Untitled()
close all
clear all
clc


global L rho cp mu

rho = 1730;
cp = 1450;
mu = 2.5e-3;

T0 = 300;
T1 = 550;

dh = cp*(T1-T0);
qpp = 4e6;

L = 1e-2;



%% variables
% w = logspace(-4,-2,10);
% ww = logspace(-4,-2,10);
% h = logspace(-4,-2,10);
% w = 1e-4;
% ww = 1e-4;
% h = 1e-4;

% w =     1.016e-4;
% ww =    1.004e-4;
% h =     1.063e-3;
w =     1.016e-4;
ww =    1.000e-4;
h =     1.000e-4;
%%

M = qpp * ( w + ww ) * L / dh;

dp = pres_drop(w,h,M);



%% header

N = floor( ( ( L - w ) ./ ( w + ww ) ) + 1 );

Vc = w .* h .* L .* N;

fprintf('M single= %e\n',M);
M = M * N;

x = logspace(-5,-1,1000);
W = x;
H = x;

dplim = dp / 10;
fprintf('M total = %e\n',M);
fprintf('dp      = %e\n',dp);
fprintf('dplim   = %e\n',dplim);

dp = pres_drop(W,H,M);

X = x(dp<dplim);
X = X(1);
fprintf('header size= %e\n',X);

Vh = X.^2 .* L;

fprintf('vol ratio  = %f\n',Vh./Vc);

% channel
% dp     x           header
% 1.0    6.1064e-05  3.2849e-04
% 0.9    6.3212e-05  3.3537e-04
% 0.5    7.6893e-05  3.9047e-04

end
function f = friction(a,Re)

    a = min(1./a,a);
    f = 24.0 * ( ...
    1 - ...
    1.3553 * a + ...
    1.9467 * a.^2 - ...
    1.7012 * a.^3 + ...
    0.9564 * a.^4 - ...
    0.2537 * a.^5 ) ./ Re;

end
function dp = pres_drop( w,h,M )

global L rho mu

A = w .* h;
P = 2 * ( w + h );
D = 4 * A ./ P;
a = h ./ w;

v = M / rho ./ A;

Re = rho * v .* D / mu;

f = friction(a,Re);

dp = f * L ./ D .* ( rho * v.^2 / 2 );

end
