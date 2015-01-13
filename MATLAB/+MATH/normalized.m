function [y] = normalized(x)
%UNTITLED Summary of this function goes here
%   Detailed explanation goes here
y = (x-mean(x))/std(x);

end

