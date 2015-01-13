function [ k_ray ] = intersect( d_sur, d_ray, o_ray, o_sur )
%UNTITLED4 Summary of this function goes here
%   Detailed explanation goes here


k = [d_sur -d_ray]\(o_ray-o_sur);


k_sur = k(1);


if (isinf(k_sur) || ( k_sur < 0 ) || ( k_sur > 1 ))
    k_ray = -1;
else
    k_ray = k(2);
    
    if isinf(k_ray)
        k_ray = -1;
    end
end

end

