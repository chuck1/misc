function [p1,p2] = bitangent(c1,r1,c2,r2,k,plot_)


% x1=-1.5;
% y1=-2.5;
% 
% x2=0;
% y2=0;
% 
% r1=-1;
% r2=1;
% 
% k=1;

x1=c1(1);
y1=c1(2);

x2=c2(1);
y2=c2(2);



dx = x2-x1;
dy = y2-y1;
dr = r2-r1;

d = sqrt(dx^2+dy^2);

X = dx/d;
Y = dy/d;
R = dr/d;

a = R*X-k*Y*sqrt(1-R^2);
b = R*Y+k*X*sqrt(1-R^2);
c = r1-(a*x1+b*y1);



if plot_
    x = [x1-abs(r1) x2+abs(r2)];

    y_1 = (-1*a*x-c)/b;

    c_2 = a*y1-b*x1;
    
    y_2 = (b*x-c_2)/a;
    
    figure()
    circle(x1,y1,r1);hold on
    circle(x2,y2,r2)
    plot(x,y_1)
    plot(x,y_2)
    axis equal
end