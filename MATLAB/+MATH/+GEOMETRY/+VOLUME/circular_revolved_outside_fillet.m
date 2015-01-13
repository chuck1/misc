function [ V ] = fillet_volume( R1,R2 )
%UNTITLED Summary of this function goes here
%   Detailed explanation goes here
V = pi*R2^2*((2-pi/2)*R1+(5/3-pi/2)*R2);

end

