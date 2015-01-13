close all
clear all
clc

%% constant conditions

qpp = 4e6;

k_s = 23;
k_f = 0.46;

T_1 = 300+273.15;
T_2 = 550+273.15;

load('Z://Windows.Documents/My Documents/SYNC/SUNSHOT/materials/ms1/ms1.mat')

%% constant geometry

L = 0.01;

%% variable geometry

[Selection,ok] = listdlg('PromptString','Select variable:',...
    'SelectionMode','multiple',...
    'ListString',{'w_w','w_c','z'});

if (~ok)
    return
end

isvar = zeros(1,3);
isvar(Selection)=1;

if isvar(1)
    w_w = logspace(-5,-2,20);
else
    w_w = 2.069e-5;
end
if isvar(2)
    w_c = logspace(-4,-2,20);
else
    w_c = 2.069e-4;
end
if isvar(3)
    z = logspace(-6,-1,20);
else
    z = 3.793e-5;
end

if sum(isvar)==2
    if  all(isvar==[1 1 0])
        [w_w,w_c] = meshgrid(w_w,w_c);
    elseif all(isvar==[1 0 1])
        [w_w,z] = meshgrid(w_w,z);
    elseif all(isvar==[0 1 1])
        [w_c,z] = meshgrid(w_c,z);
    end
end

if sum(isvar)==3
    [w_w,w_c,z] = ndgrid(w_w,w_c,z);
end

%% compute geometry

alpha = z ./ w_c;

P = 2 * ( w_c + z );

A_cs = w_c .* z;

D = 4 .* A_cs ./ P;

A_flux = L * ( w_c + w_w );

A_b = L .* w_c;

%% compute local heat transfer coefficient

% through floor and ceiling
Nu1 = heat.convection.internal.laminar.rectangular.SL1978( 1./alpha,'H1','Case 4' );

% through walls
Nu2 = heat.convection.internal.laminar.rectangular.SL1978( alpha,'H1','Case 4' );

h1 = Nu1 .* k_f ./ D;

h2 = Nu2 .* k_f ./ D;

% average with heat transfer through all walls
% Nu = heat.convection.internal.laminar.rectangular.MH1955( alpha );
Nu = (w_c.*Nu1 + z.*Nu2)./(w_c+z);

h = Nu .* k_f ./ D;

%% compute

dh = thermo.enthalpy_change(T_1,T_2,ms1);

mdot = qpp * A_flux / dh;

eta_f = heat.conduction.extended_surface.rectangular.efficiency(...
    z + w_c/2, L, w_w, h./k_s, 'adiabatic');

theta = (w_w+w_c) ./( h1.*w_c + eta_f.*(h1.*w_c + 2*h2.*z) );

%% pressure drop

DP = flow.internal.fully_dev.pressure_drop_with_heat(w_w,w_c,z,L,qpp,ms1,T_1,T_2);

%% eliminate points which do not meet pressure drop requirement

DPMAX = 1e5;
theta(DP>DPMAX) = NaN;

%% report

if sum(isvar)==1
    if isvar(1)
        x = w_w;
        XLABEL = 'w_w';
    elseif isvar(2)
        x = w_c;
        XLABEL = 'w_c';
    elseif isvar(3)
        x = z;
        XLABEL = 'z';
    end
    
    % thermal resistance and fin efficiency
    figure()
    [AX,H1,H2] = plotyy(x,theta,x,eta_f,'loglog');
    xlabel(XLABEL)
    set(get(AX(1),'Ylabel'),'String','\theta (K m^2/W)') 
    set(get(AX(2),'Ylabel'),'String','\eta_f')
    set(H1,'LineStyle','-','Color','b')
    set(H2,'LineStyle','-','Color','r')
    set(AX(1),'YColor','b')
    set(AX(2),'YColor','r')
    
    % thermal resistance and pressure drop
    figure()
    [AX,H1,H2] = plotyy(x,theta,x,DP,'loglog');
    xlabel(XLABEL)
    set(get(AX(1),'Ylabel'),'String','\theta (K m^2/W)') 
    set(get(AX(2),'Ylabel'),'String','\Delta p (Pa)')
    set(H1,'LineStyle','-','Color','b')
    set(H2,'LineStyle','-','Color','r')
    set(AX(1),'YColor','b')
    set(AX(2),'YColor','r')
    
    % thermal resistance and wall local Nusselt number
    figure()
    [AX,H1,H2] = plotyy(x,theta,x,Nu2,'loglog');
    xlabel(XLABEL)
    set(get(AX(1),'Ylabel'),'String','\theta (K m^2/W)') 
    set(get(AX(2),'Ylabel'),'String','Nu_2')
    set(H1,'LineStyle','-','Color','b')
    set(H2,'LineStyle','-','Color','r')
    set(AX(1),'YColor','b')
    set(AX(2),'YColor','r')
elseif sum(isvar)==2
    
    if  all(isvar==[1 1 0])
        x = w_c;
        y = w_w;
        XLABEL = 'log10(w_c)';
        YLABEL = 'log10(w_w)';
    elseif all(isvar==[1 0 1])
        x = w_w;
        y = z;
        XLABEL = 'log10(w_w)';
        YLABEL = 'log10(z)';
    elseif all(isvar==[0 1 1])
        x = w_c;
        y = z;
        XLABEL = 'log10(w_c)';
        YLABEL = 'log10(z)';
    end
    
    figure()
    surf(log10(x),log10(y),log10(theta))
    xlabel(XLABEL)
    ylabel(YLABEL)
    zlabel('log10(\theta)')
    
    figure()
    surf(log10(x),log10(y),log10(DP))
    xlabel(XLABEL)
    ylabel(YLABEL)
    zlabel('log10(\Delta p)')
    
elseif sum(isvar)==3
    
    [C,I] = min(theta(:));
    disp('optimal w_w')
    disp(w_w(I));
    disp('optimal w_c')
    disp(w_c(I));
    disp('optimal z')
    disp(z(I));
    disp('optimal dp')
    disp(DP(I));
    
end


