function [dev] = header_pres(w0,w1)
close all
%UNTITLED Summary of this function goes here
%   Detailed explanation goes here

N = 4;
n = 100;

M = 0.01;

m = M - (1:N)*(M/(N+1));

h = 0.5;

L = 100;
l = L/4;
dx = l/n;

Mfun = @(x) 0;
mfun = cell(N,1);
for a = 1:N
    mfun{a} = @(x) ( ( x >= ( l*(a-1) ) ) & ( x < ( l*a ) ) ) * m(a);
    Mfun = @(x) Mfun(x) + mfun{a}(x);
end



rho = 1000;
mu = 1e-5;



% w0 = 10;
% w1 = 1;




w = @(x) w0 + (w1-w0)/L*x;
al = @(x) w(x)/h;
A = @(x) w(x)*h;
P = @(x) 2*(w(x)+h);
D = @(x) 4*A(x)/P(x);

v = @(x,m) m./(rho*h*w(x));

Re = @(x,m) rho*D(x)*v(x,m)/mu;

p = @(x,m) dx/D(x)*(rho*v(x,m)^2/2)*fric(al(x),Re(x,m));





ptot = zeros(N,1);
pcum = zeros(n*N,1);
c = 1;
for a = 1:N
    x = (0:dx:(l-dx))+l*(a-1);
    pres = zeros(n,1);
    
    for b = 1:n
        
        pres(b) = p(x(b),m(a));
        
        if c==1
            pcum(c) = 0 + pres(c);
        else
            pcum(c) = pcum(c-1) - pres(b);
        end
        c = c + 1;
        
        ptot(a) = ptot(a) + pres(b);
        
    end
end



x = 0:dx:(L-dx);

figure()
plot(x,pcum)

figure()
plot(x,Mfun(x))

figure()
plot(x,Re(x,Mfun(x)))

figure()
plot(ptot,'o')
ylim([0,max(ptot)]);
xlim([0,N+1])
dev = (max(ptot)-min(ptot))/(min(ptot));

end






function f = fric( al, Re )

al = min( al, 1.0/al );

f = 4.0 * 24.0 * ( ...
    1 - ...
    1.3553 * al + ...
    1.9467 * (al^2) - ...
    1.7012 * (al^3) +...
    0.9564 * (al^4) - ...
    0.2537 * (al^5) ...
    ) / Re;

end