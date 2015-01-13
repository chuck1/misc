%% option 1 temp dist analysis

clear all
close all
clc



L =  0.016;
Lc = 0.010;
n=32;

dx = L/n;
nc = Lc/dx;

n_up = (n-nc)/2;
n_dn = (n-nc)/2;

%% determine heat transfer to this domain from the heated surface.
Q = 104.5;
N = 9.5;

q = Q/N;

% adjust to make sure heat exist out the end
q = q*1.4;
% too high too low
% 1.4      1.2

qh = zeros(n,1);
qh(n_up+1:n_up+nc) = q/nc;

qtot = sum(qh);

qd_right = 0.1 * qtot;

%%

cp = 1224;
mdot = 0.00008339;

% boundary index of zero flux

Ttemp = [913.70...
    912.50...
    911.30...
    909.90...
    908.30...
    906.30...
    904.10...
    901.20...
    897.90...
    894.20...
    890.10...
    885.80...
    881.20...
    876.50...
    871.60...
    866.60...
    861.60...
    856.40...
    851.30...
    846.10...
    840.90...
    835.70...
    830.70...
    825.70...
    820.90...
    816.30...
    812.00...
    808.10...
    804.70...
    801.70...
    798.90...
    796.30...
    793.80];
for a=1:n+1
    T(a) = Ttemp((n+1)-a+1);
end

for a=1:n
    DT(a) = T(a+1)-T(a);
end

for a=1:n
    qf(a) = -mdot*cp*DT(a);
end


A = zeros(n,n);
B = zeros(n,1);



for a=1:(n-1)
    A(a,a) = 1;
    A(a,a+1) = -1;
    
	B(a) = -qh(a) - qf(a);
   
end

for a=n
    A(a,a) = 1;
    B(a) = -qh(a) - qf(a) + qd_right;
end

qd = A\B;

qd = [qd;qd_right];

%qd = [qd(1:(nd_0-1));0;qd(nd_0:end)];

x=linspace(-0.75,14.75,n);
xd=linspace(-1,15,n+1);

figure()
plot(x,qh,'ob');hold on
plot(x,qf,'or')
plot(xd,qd,'og')
xlabel('Location (mm)')
ylabel('Heat Transfer (W)')
%formatplot()
%print('-depsc2','hx')

%figure()
%plot(xd,T);hold on
%xlabel('Location (mm)')
%ylabel('Bult Fluid Temperature (K)')
%%formatplot()
%plot([2 2],[800 900])
%plot([12 12],[800 900])
%print('-depsc2','bulk')



qtot2 = -sum(qf)-qd(1)+qd(end);

fprintf('heat in %f heat out %f\n',qtot,qtot2)

fprintf('heat out %f %f %f\n',-sum(qf)/qtot,-qd(1)/qtot,qd(end)/qtot)
