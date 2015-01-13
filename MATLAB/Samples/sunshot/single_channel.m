clc
clear all
close all
%% geometric
alpha = 0.42;
%alpha = 0:0.001:1;

%b = 100E-6;
b = 1E-6:0.1E-6:500E-6;

a = b*alpha;

L = 5E-3;
w_w = 20E-6;

A_cs = a.*b;
P_ch = 2*(a+b);
D = 4*A_cs./P_ch;
A_rec = L*(a+w_w);

w_f = w_w./b;

%% fluid properties
k = 62E-6;
rho = 49;
mu = 36E-6;
Cp = 1200;
nu = mu/rho;

%% conditions
q_rec = 1E6;
DT = 150;

%% solve
mstar = q_rec*A_rec/Cp/DT;
vstar = mstar/rho./A_cs;
Re = D.*vstar/nu;
p = 64./Re*L./D*rho/2.*vstar.^2;

m = mstar./(b.^4.*p/nu/L);

chi = k*L/Cp./mstar;

Nu = 8.235*(1-1.883*alpha+3.767*alpha.^2-5.814*alpha.^3+5.361*alpha.^4-2*alpha.^5);

x=0:0.001:1;

% thetasmax = zeros(1,length(alpha));
% for i=1:length(alpha)
%     thetas = (alpha(i)+w_f)*(2*alpha(i)/(Nu(i)*(1+alpha(i))*(2+alpha(i)))+chi(i)/m(i)*x);
%     thetasmax(i) = max(thetas);
% end

thetasmax = zeros(1,length(b));
for i=1:length(b)
    thetas = (alpha+w_f(i))*(2*alpha/(Nu*(1+alpha)*(2+alpha))+chi(i)/m(i)*x);
    thetasmax(i) = max(thetas);
end

% plot(alpha,thetasmax)
% axis([0 1 0 1])
% figure;
% plot(alpha,p,[0 1],[30000 30000])
% axis([0 1 0 100000])

plot(b,thetasmax)
axis([min(b) max(b) 0 1])
figure;
plot(b,p,[min(b) max(b)],[30000 30000])
axis([min(b) max(b) 0 100000])


% minthetasmax = min(thetasmax);
% alphamin = alpha(thetasmax==minthetasmax);

minthetasmax = min(thetasmax);
bmin = b(thetasmax==minthetasmax);