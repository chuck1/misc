function [ eta ] = efficiency( T,ep,include_reflection )
%UNTITLED Summary of this function goes here
%   Detailed explanation goes here


sigma=5.67e-8;

h=15;

qpp=1e6;

T_inf=300;

eta = qpp ./ ( qpp + sigma * ep .* (T.^4-T_inf.^4) + h .* (T-T_inf) );

if include_reflection
    eta = eta .* ep;
end

end

