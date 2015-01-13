function [ c ] = markers( a )
%UNTITLED Summary of this function goes here
%   Detailed explanation goes here

if numel(a) ~= 1
    error('invalid input')
end



C = {...
    'o';...
    's';...
    '^';...
    'v'};

a = mod(a-1,size(C,1))+1;

c = C{a};

end

