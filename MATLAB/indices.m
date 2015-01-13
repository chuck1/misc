%INDICES   index combinations
%   A = INDICES generates a PROD(n) by LENGTH(n) matrix where each row is a
%   vector of indices cooresponding to each element of n. The matrix
%   contains all possible combinations of indices where the values in n
%   determine the maximum index for each column.
function [A] = indices(n)

m = length(n);
p = zeros(1,m);
p(1) = prod(n)/n(1);
for a = 2:m
    p(a) = p(a-1)/n(a);
end

a = (1:prod(n))';

A = zeros(prod(n),m);
b = prod(n)/n(1);
A(:,1) = (a-mod(a-1,b)+b-1)/b;

c = 2;

while c <= m
    A(:,c) = (mod(a-1,p(c-1))-mod(a-1,p(c))+p(c))/p(c);
    c = c+1;
end