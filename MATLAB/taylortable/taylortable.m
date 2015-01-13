

%i = [0 0 1 2 0];
%d = [1 0 0 0 3];

% APPLIES TO UNIFORM GRID
% i is the index or location
% d is the orderof the term
% X is a coefficient of the terms not including the first
% the coefficnet of the first term is one

i = [1 0 0 1];
d = [1 1 2 2];




m = length(i);
n = m-1;

T = sym(zeros(m,n));
for j = 1:m
    T(j,:) = ttrow(i(j),d(j),n);
end

T

A = T(2:m,1:m-1)';
b = -T(1,1:m-1)';
X = A\b