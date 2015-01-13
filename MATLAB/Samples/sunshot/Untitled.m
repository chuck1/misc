clear all
close all
clc
% the enemy's gate is down
rho = 91;
cp = 1200;
Gsol = 10;
Gflu = 0.01;

Wwall = 100;
Wch = 100;
Hch = 500;
Htop = 100;
Hbottom = 100;
L = 1000;

dx = 20;
dy = 20;
dz = 10;

Nx1 = Wch/dx;
Nx2 = (Wwall+Wch)/dx;
Ny1 = Hbottom/dy;
Ny2 = (Hbottom+Hch)/dy;
Ny3 = (Hbottom+Hch+Htop)/dy;
Nz = L/dz;

dx = dx/1000000;
dy = dy/1000000;
dz = dz/1000000;

phit = 100;
q = 1000;

maxit = 100;

%% w
w = zeros(Nx2,Ny3,Nz);
w(1:Nx1,Ny1+1:Ny2,1:Nz) = -3;

%% G
G = Gsol*ones(Nx2,Ny3,Nz);
G(1:Nx1,Ny1+1:Ny2,1:Nz) = Gflu;

Gt = G;
Gt(:,:,1:Nz-1) = 2*G(:,:,1:Nz-1).*G(:,:,2:Nz)./(G(:,:,1:Nz-1)+G(:,:,2:Nz));

Gb = G;
Gb(:,:,2:Nz) = 2*G(:,:,1:Nz-1).*G(:,:,2:Nz)./(G(:,:,1:Nz-1)+G(:,:,2:Nz));

Ge = G;
Ge(1:Nx2-1,:,:) = 2*G(1:Nx2-1,:,:).*G(2:Nx2,:,:)./(G(1:Nx2-1,:,:)+G(2:Nx2,:,:));

Gw = G;
Gw(2:Nx2,:,:) = 2*G(1:Nx2-1,:,:).*G(2:Nx2,:,:)./(G(1:Nx2-1,:,:)+G(2:Nx2,:,:));

Gn = G;
Gn(:,1:Ny3-1,:) = 2*G(:,1:Ny3-1,:).*G(:,2:Ny3,:)./(G(:,1:Ny3-1,:)+G(:,2:Ny3,:));

Gs = G;
Gs(:,2:Ny3,:) = 2*G(:,1:Ny3-1,:).*G(:,2:Ny3,:)./(G(:,1:Ny3-1,:)+G(:,2:Ny3,:));

%% at
% interior
at = Gt*dx*dy/dz-rho*cp*w*dx*dy;
% top boundary
at(:,:,Nz) = 0;

%% ab
% interior
ab = Gb*dx*dy/dz-rho*cp*w*dx*dy;
% bottom boundary
ab(:,:,1) = 0;

%% ae
% interior
ae = Ge*dy*dz/dx;
% east boundary
ae(Nx2,:,:) = 0;

%% aw
aw = Gw*dy*dz/dx;
% east boundary
aw(1,:,:) = 0;

%% an
an = Gn*dx*dz/dy;
% north boundary
an(:,Ny3,:) = 0;

%% as
as = Gn*dx*dz/dy;
% north boundary
as(:,1,:) = 0;

%% ap
% interior
ap = -at-ab-an-as-ae-aw;
% top fluid boundary
ap(1:Nx1,Ny1+1:Ny2,Nz) = ap(1:Nx1,Ny1+1:Ny2,Nz) - (2*Gt(1:Nx1,Ny1+1:Ny2,Nz)*dx*dy/dz - rho*cp*w(1:Nx1,Ny1+1:Ny2,Nz)*dx*dy);

%% bp
% interior
bp = zeros(Nx2,Ny3,Nz);
% top fluid boundary
bp(1:Nx1,Ny1+1:Ny2,Nz) = -(2*Gt(1:Nx1,Ny1+1:Ny2,Nz)*dx*dy/dz - rho*cp*w(1:Nx1,Ny1+1:Ny2,Nz)*dx*dy)*phit;
% north boundary
bp(:,Ny3,:) = q*dx*dz;

phi = phit*ones(Nx2,Ny3,Nz);
for n = 1:maxit
    oldphi = phi;
    for i = 1:Nx2
        for j = 1:Ny3
            for k = 1:Nz
                t = solversub(phi,bp,at,ab,ae,aw,an,as,i,j,k);
                phi(i,j,k) = t/(-ap(i,j,k));
            end
        end
    end
    R = abs(oldphi-phi);
    R = mean(R(:));
    fprintf('iteration %3i residual %f\n',n,R)
end
