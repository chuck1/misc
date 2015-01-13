function [ c ] = colors( a )
%UNTITLED2 Summary of this function goes here
%   Detailed explanation goes here
if numel(a) ~= 1
    error('invalid input')
end

C = [...
    0 0 1;...
    1 0 0;...
    0 1 0;...
    1 0 1;...
    0 1 1;...
    ];

a = mod(a-1,size(C,1))+1;

c = C(a,:);

end

