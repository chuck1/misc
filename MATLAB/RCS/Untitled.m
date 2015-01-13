clc
clear all

endpoint = [30 20];
startpoint = [50 70];

nPoints = 10;
points = zeros(nPoints,2);
lambda = linspace(0,1,nPoints);
for a = 1:nPoints
    points(a,:) = startpoint*(lambda(a)) + endpoint*(1-lambda(a));
end

sze=5;
N=100;

z=rand(N);
f=lowpassfilter([sze sze],0.2,1);
z=filter2(f,z);

x0 = 30;

p=zeros(N);

for a=1:size(z,1)
    for b=1:size(z,2)
        p(a,b) = 0;
        for c=1:nPoints
            x = [a,b] - points(c,:);
            x = dot(x,x)/x0;
            p(a,b) = p(a,b) + exp(-x);
        end
    end
end
z=z.*(p/nPoints);
z=z(sze:N-sze,sze:N-sze);

surf(z);

