close all;clear all;clc

M = 1e17;
m = 1000;
Tmax = 100;

N = 3000;
X = [0 0];

kp = 0.1;
kd = 20;
ki = 0;

% allocate

R = zeros(N,1);
Tm = zeros(N,1);
time = zeros(N,1);
V_t = zeros(N,1);
V_n = zeros(N,1);
x = zeros(N,2);
v = zeros(N,2);
T = zeros(N,2);
F = zeros(N,2);


% target
Rtar = 10000;

V_ttar = orbit_vel( Rtar,M );

dt = 1;

% initialize

i = 1;

x(i,:) = [0 -20000];
v(i,:) = [0 0];
%v(n,:) = [100 100];
%v(n,:) = [orbit_vel( abs(x(n,2)),M ) 0];

r = x(i,:) - X;

R(i) = mag(r);

RI = 0;

for i = 2:N
    
    time(i) = time(i-1) + dt;
    
    r = x(i-1,:) - X;
    n = r/mag(r);
    t = n*[0 1;-1 0];
    R(i) = mag(r);
    
    RI = RI + (Rtar-R(i))*dt;
    
    dot(v(i-1,:),n)
    V_n(i-1) = dot(v(i-1,:),n);
    V_t(i-1) = dot(v(i-1,:),t);
    
    T_t = t*(V_ttar - V_t(i-1))*m/dt;
    %T_t = [0 0];
    
    %T_n = (v_ntar - v_n)*m/dt;
    T_n = kp*(Rtar-R(i))*n + kd*V_n(i)*n + ki*RI*n;
    
    T(i,:) = T_t + T_n;
    
    Tm(i) = mag(T(i));
    
    if Tm(i)>Tmax
        T(i,:) = T(i,:)/Tm(i)*Tmax;
    end
    
    F(i,:) = force_grav( M,m,r );
    %T(n,:) = [0 0];
    
    T(i,:) = T(i,:) - F(i,:);
    
    v(i,:) = v(i-1,:) + (T(i,:)+F(i,:))/m*dt;
    
    x(i,:) = x(i-1,:) + v(i,:)*dt;

end

figure()
plot(x(:,1),x(:,2));hold on
circle(X(1),X(2),Rtar)
axis equal

figure()
plot(time,R)
xlabel('t')
ylabel('R')

figure()

plot(time,T)
xlabel('t')
ylabel('T')

figure()
plot(time,V_t,time,V_n)
xlabel('t')
legend('V_t','V_n')