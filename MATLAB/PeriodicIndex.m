function [ a ] = PeriodicIndex( a,b )
%UNTITLED3 Summary of this function goes here
%   Detailed explanation goes here
if a<1
    a = a + b;
elseif a>b
    a = a - b;
end

end

