function [ t ] = solversub(phi,bp,at,ab,ae,aw,an,as,i,j,k)
%UNTITLED Summary of this function goes here
%   Detailed explanation goes here
t = 0;
if at(i,j,k)~=0
    t = t + at(i,j,k)*phi(i,j,k+1);
end
if ab(i,j,k)~=0
    t = t + ab(i,j,k)*phi(i,j,k-1);
end
if ae(i,j,k)~=0
    t = t + ae(i,j,k)*phi(i+1,j,k);
end
if aw(i,j,k)~=0
    t = t + aw(i,j,k)*phi(i-1,j,k);
end
if an(i,j,k)~=0
    t = t + an(i,j,k)*phi(i,j+1,k);
end
if as(i,j,k)~=0
    t = t + as(i,j,k)*phi(i,j-1,k);
end
t = t + bp(i,j,k);

end