% U = @(r,a,umax,ut) umax - 2.5 * log(a./(a-r)) * ut;

U = @(r,a,umax,n) umax * ((a-r)/a).^(1/n);



r = 0:0.01:1;

% u = U(r,1,1,0.1);

u = U(r,1,1,6);

plot(r,u)

