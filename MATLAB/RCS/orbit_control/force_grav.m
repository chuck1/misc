function [ F ] = force_grav( M,m,r )
%UNTITLED Summary of this function goes here
%   Detailed explanation goes here
G = 6.67384e-11;
R = mag(r);

F = -G*M*m/R^2;

F = F*r/mag(r);

end

