function Untitled()
close all
clear all
clc


global l rho cp mu

rho = 1730;
cp = 1450;
mu = 2.5e-3;

T0 = 300;
T1 = 550;

dh = cp*(T1-T0);
qpp = 4e6;

l = 1e-2;

dpLim = 1e5;

%% variables
% w = logspace(-4,-2,10);
% ww = logspace(-4,-2,10);
% h = logspace(-4,-2,10);
% w = 1e-4;
% ww = 1e-4;
% h = 1e-4;
x = logspace(-5,-4,1000);
w = x;
ww = x;
h = x;

%%

M = qpp * ( w + ww ) * l / dh;

dp = pres_drop(w,h,M);

loglog(x,dp,[1e-5 1e-2],[dpLim dpLim])

X = x(dp<dpLim);
X = X(1);
M = M(dp<dpLim);
M = M(1);

disp(dpLim);
disp(X);
disp(M);

%% header

%select smallest
w = X;
ww = X;
% h = X;

N = floor( ( ( l - w ) ./ ( w + ww ) ) + 1 );

M = M * N;

x = logspace(-5,-2,1000);
W = x;
H = x;

dpLim = dpLim / 10;

dp = pres_drop(W,H,M);

X = x(dp<dpLim);
X = X(1);
disp(dpLim);
disp(X);

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

global l rho mu

A = w .* h;
P = 2 * ( w + h );
D = 4 * A ./ P;
a = h ./ w;

v = M / rho ./ A;

Re = rho * v .* D / mu;

f = friction(a,Re);

dp = f * l ./ D .* ( rho * v.^2 / 2 );

end
