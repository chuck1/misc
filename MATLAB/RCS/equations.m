close all;clear all;clc

str{1}='m2*(-L(t)*sin(P(t))*(diff(P(t), t, t))+(diff(L(t), t, t))*cos(P(t))-2*(diff(L(t), t))*sin(P(t))*(diff(P(t), t))-L(t)*cos(P(t))*(diff(P(t), t))^2+D(t)*cos(P(t))*(diff(P(t), t, t))+(diff(D(t), t, t))*sin(P(t))+2*(diff(D(t), t))*cos(P(t))*(diff(P(t), t))-D(t)*sin(P(t))*(diff(P(t), t))^2)/(m1+m2)';
str{2}='m2*(L(t)*cos(P(t))*(diff(P(t), t, t))+(diff(L(t), t, t))*sin(P(t))+2*(diff(L(t), t))*cos(P(t))*(diff(P(t), t))-L(t)*sin(P(t))*(diff(P(t), t))^2+D(t)*sin(P(t))*(diff(P(t), t, t))-(diff(D(t), t, t))*cos(P(t))+2*(diff(D(t), t))*sin(P(t))*(diff(P(t), t))+D(t)*cos(P(t))*(diff(P(t), t))^2)/(m1+m2)';
str{3}='-(-cos(P(t))*(diff(X(t), t, t))-L(t)*cos(P(t))^2*(diff(P(t), t))^2+2*(diff(D(t), t))*cos(P(t))^2*(diff(P(t), t))+D(t)*cos(P(t))^2*(diff(P(t), t, t))-sin(P(t))*(diff(Y(t), t, t))-L(t)*sin(P(t))^2*(diff(P(t), t))^2+2*(diff(D(t), t))*sin(P(t))^2*(diff(P(t), t))+D(t)*sin(P(t))^2*(diff(P(t), t, t)))/(cos(P(t))^2+sin(P(t))^2)';
str{4}='(sin(P(t))*(diff(X(t), t, t))+2*(diff(L(t), t))*sin(P(t))^2*(diff(P(t), t))+L(t)*sin(P(t))^2*(diff(P(t), t, t))+D(t)*sin(P(t))^2*(diff(P(t), t))^2-cos(P(t))*(diff(Y(t), t, t))+2*(diff(L(t), t))*cos(P(t))^2*(diff(P(t), t))+L(t)*cos(P(t))^2*(diff(P(t), t, t))+D(t)*cos(P(t))^2*(diff(P(t), t))^2)/(cos(P(t))^2+sin(P(t))^2)';
str{5}='-m2*((diff(X(t), t, t))*L(t)*sin(P(t))-(diff(X(t), t, t))*D(t)*cos(P(t))+(diff(L(t), t, t))*cos(P(t))^2*D(t)-(diff(D(t), t, t))*sin(P(t))^2*L(t)-(diff(Y(t), t, t))*L(t)*cos(P(t))-(diff(Y(t), t, t))*D(t)*sin(P(t))+(diff(L(t), t, t))*sin(P(t))^2*D(t)-(diff(D(t), t, t))*cos(P(t))^2*L(t)+2*(diff(L(t), t))*sin(P(t))^2*(diff(P(t), t))*L(t)+2*(diff(D(t), t))*cos(P(t))^2*(diff(P(t), t))*D(t)+2*(diff(L(t), t))*cos(P(t))^2*L(t)*(diff(P(t), t))+2*(diff(D(t), t))*sin(P(t))^2*D(t)*(diff(P(t), t)))/(m2*L(t)^2*sin(P(t))^2+m2*D(t)^2*cos(P(t))^2+m2*L(t)^2*cos(P(t))^2+m2*D(t)^2*sin(P(t))^2+I1+I2)';

str=regexprep(str,'diff\(X\(t\), t, t\)','xpp');
str=regexprep(str,'diff\(Y\(t\), t, t\)','ypp');
str=regexprep(str,'diff\(D\(t\), t, t\)','Dpp');
str=regexprep(str,'diff\(L\(t\), t, t\)','Lpp');
str=regexprep(str,'diff\(P\(t\), t, t\)','ppp');

str=regexprep(str,'diff\(X\(t\), t\)','xp');
str=regexprep(str,'diff\(Y\(t\), t\)','yp');
str=regexprep(str,'diff\(D\(t\), t\)','Dp');
str=regexprep(str,'diff\(L\(t\), t\)','Lp');
str=regexprep(str,'diff\(P\(t\), t\)','pp');

str=regexprep(str,'X\(t\)','x');
str=regexprep(str,'Y\(t\)','y');
str=regexprep(str,'D\(t\)','D');
str=regexprep(str,'L\(t\)','L');
str=regexprep(str,'P\(t\)','p');

prefix='@(x,y,D,L,p,xp,yp,Dp,Lp,pp,xpp,ypp,Dpp,Lpp,ppp,m1,m2,I1,I2)';
for a=1:5
    func{a} = str2func([prefix str{a}]);
end

save('func','func')