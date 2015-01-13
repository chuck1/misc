function [R] = xtrans(a)
%a=a*pi()/180;
R=[
    1 0 0;
    0 cos(a) sin(a);
    0 -sin(a) cos(a)];