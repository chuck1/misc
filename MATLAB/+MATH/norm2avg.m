function [D] = norm2avg(Dold,sigma)
N = size(Dold(:),1);
n = 1;
D = Dold;
x = 1:size(Dold,2);
y = 1:size(Dold,1);
[X Y]=meshgrid(x,y);
for x = 1:size(Dold,2)
    for y = 1:size(Dold,1)
        Z = normal2(x,y,sigma,X,Y);
        Z = Z/max(Z(:));
        A = Z.*Dold;
        D(x,y) = sum(A(:))/sum(Z(:));
        n = n+1;
        fprintf('%f\',n/N*100)
    end
end
