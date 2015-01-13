function [ a ] = ttrow ( i , d , n )

a = (zeros(1,n));
for j = 1:n
	if j > d
		a(j) = (i^(j-d-1)/factorial(j-d-1));
end,end