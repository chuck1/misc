function [ y ] = squeezesum( varargin )
%UNTITLED2 Summary of this function goes here
%   Detailed explanation goes here
if nargin==0
    error('Not enough input arguments.')
end

y = varargin{1};

if nargin==1
    d = 1;
else

    d = zeros(1,nargin-1);
    for a=1:(nargin-1)
        d(a) = varargin{a+1};
    end
    
end

for a = 1:length(d)
    y = squeeze(sum(y,d(a)));
end

end

