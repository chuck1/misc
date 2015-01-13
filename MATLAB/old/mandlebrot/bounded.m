function [ b ] = bounded( c )
%UNTITLED2 Summary of this function goes here
%   Detailed explanation goes here
b = true;

z = 0;

for a=1:1000
    z = z^2 + c;
    %fprintf('%f\n',z);
    if isinf(z)
        b = false;
        return
    end
end

end

