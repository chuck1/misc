close all
clear all
clc

R_rama = 318;
g = 9.81;
omega = [0;0;sqrt(g/R_rama)];



r = [1;0;0];
v = cross(r,omega);
% v = [0;0;0];


CD = 0.2;

dt = 0.01;

rho = 1;
m = 100;

t=0;



R(1) = sqrt(dot(r,r));

V(1) = sqrt(dot(v,v));



for k=1:100000;

v1 = cross(r(:,k),omega);
v1m = sqrt(dot(v1,v1));
if v1m == 0
    vn = zeros(3,1);
else
    vn = v1/v1m;
end

vtm = dot(v,vn);

vtrelm = v1m - vtm;

vt = vtm*vn;

vp = v - vt;

vrel = v1 - v;
vrelm = sqrt(dot(vrel,vrel));

vpm = sqrt(dot(vp,vp));

f = CD*(vtrelm^2)/rho*vn;

v = v + f/m*dt;

r(:,k+1) = r(:,k) + v*dt;

R(k+1) = sqrt(dot(r(:,k+1),r(:,k+1)));

V(k+1) = sqrt(dot(v,v));

t(k+1) = t(k) + dt;

if R(k+1) > R_rama
    break
end

end

plot(r(1,:),r(2,:))
hold on
circle(0,0,R_rama)
axis equal
figure()
plot(t,R)
figure()
plot(t,V)