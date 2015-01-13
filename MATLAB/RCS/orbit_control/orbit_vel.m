function [ v ] = orbit_vel( r,M )
%UNTITLED4 Summary of this function goes here
%   Detailed explanation goes here
G = 6.67384e-11;
v = sqrt(G*M/r);

end