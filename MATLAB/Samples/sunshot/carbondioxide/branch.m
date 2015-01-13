function [dtmax] = branch()

global q enthalpy_in enthalpy_out rho mu k

q = 100;

T_in = 500+273.15;
T_out = 650+273.15;
T_avg = (T_in+T_out)/2;

enthalpy_in = co2('h','T',T_in);
enthalpy_out = co2('h','T',T_out);

rho = co2('rho','T',T_avg);
mu = co2('mu','T',T_avg);
k = co2('k','T',T_avg);

%% input
param=0.3:0.001:0.99;
paramstr='length reduction factor';
n=length(param);

N = 5;

Ltot = 5e-3;
Wout = 100e-6;

a = 0.7; % length reduction factor
b = param; % width reduction factor

L = Ltot/sum(a.^(0:N-1));
H = 500e-6;
W = Wout./(b.^(N-1));

r = 200E-6;
phi = 2*pi/12;

%% solve
dptot=zeros(n,1);
dtmax=zeros(n,1);
pow=zeros(n,1);
for i=1:n
    [dptot(i),dtmax(i),pow(i)]=branch_sub(N,phi,W(i),H,L,r,a,b(i));
end

figure(1)
semilogy(param,dptot,[param(1) param(end)],[35000 35000])
ylabel('pressure drop [Pa]')
xlabel(paramstr)
figure(2)
plot(param,dtmax)
ylabel('max temperature different [K]')
xlabel(paramstr)
figure(3)
plot(param,pow)
ylabel('k power [W]')
xlabel(paramstr)

end

function [dptot,dtmax,pow] = branch_sub(N,phi,W,H,L,r,a,b)
global q enthalpy_in enthalpy_out rho mu k
%% geometric
phi = [phi;zeros(N-1,1)];
W = [W;zeros(N-1,1)];
L = [L;zeros(N-1,1)];
r = [r;zeros(N-0,1)];
Arec = zeros(N,1);
A = zeros(N,1);
P = zeros(N,1);
D = zeros(N,1);

for i=2:N
    phi(i)=phi(i-1)/2;
    L(i)=L(i-1)*a;
    W(i)=W(i-1)*b;
end
for i=1:N
    A(i)=W(i)*H;
    P(i)=2*(W(i)+H);
    D(i)=4*A(i)/P(i);
end
for i=1:N
    r(i+1)=it_r(r(i),L(i),phi(i));
end

Arectot=0;
for i=1:N
    Arec(i)=phi(i)/2*(r(i+1)^2-r(i)^2);
    Arectot=Arectot+Arec(i)/2^(i-1);
end

    
%% compute
al = zeros(N,1);
dt = zeros(N,1);
dp = zeros(N,1);
Nu = zeros(N,1);
Re = zeros(N,1);
V = zeros(N,1);
f = zeros(N,1);
h_f = zeros(N,1);
h = zeros(N,1);

m = q*Arectot/(enthalpy_out-enthalpy_in);
m = [m;zeros(N-1,1)];

for i=2:N
    m(i)=m(i-1)/2;
end
for i=1:N

    al(i) = W(i)/H;

    Nu(i) = 6;

    h(i) = Nu(i)*k./D(i);

    dt(i) = (Arec(i)/P(i)/L(i))*q/h(i);

    V(i) = m(i)/rho/A(i);

    Re(i) = rho*D(i)*V(i)/mu;
    f(i) = 64./Re(i);
    h_f(i) = f(i)*(L(i)/D(i))*(rho*V(i)^2/2);

    dp(i) = h_f(i);

end

dptot=sum(dp);
dtmax=max(dt);
pow=m(1)/rho*dptot;

end

function [r1] = it_r(r,l,phi)
    
    r1=r+l;
    r1old=0;
    while (abs(r1old-r1)/r1)>0.01;
        theta=asin(r1/l*sin(phi/2));
        c=l*cos(theta);
        r1old=r1;
        r1=(r+c)/cos(phi/2);
    end
    
end