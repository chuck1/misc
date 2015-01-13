function [t,y] = euler(f,tspan,y0,N)
%EULER Forward Euler
%   [t,y] = EULER(f,tspan,y0,N) returns vectors of length N+1 representing
%   the solution to the problem dy/dt = f(t,y), solved using forward euler
%   from t=tspan(1) to t=tspan(2) with initial value y0.
m = length(y0);
t = linspace(tspan(1),tspan(2),N+1);
y = zeros(m,N+1);
h = (tspan(2)-tspan(1))/N;
y(:,1) = y0;

for i = 1:N
    y(:,i+1) = y(:,i) + h*f(t(i),y(:,i));
end
