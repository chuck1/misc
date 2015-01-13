function [R] = ytrans(a)
%a=a*pi()/180;
R=[
	cos(a) 0 -sin(a);
	0 1 0;
	sin(a) 0 cos(a)];
