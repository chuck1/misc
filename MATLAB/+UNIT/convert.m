function [ X2 ] = convert( X1,str1,str2 )
%UNTITLED3 Summary of this function goes here
%   Detailed explanation goes here

%% check absolute temperature conversions

if ~isempty(regexp(str1,'^C$','once'))
    if ~isempty(regexp(str2,'^K$','once'))
        X2 = X1 + 273.15;
        return
    end
end

%% identify fundamental units

[fund,unit,conv] = UNIT.fundamental_units();

[~,F1,U1,exp1] = UNIT.str2unit(str1,fund,unit);
[~,F2,U2,exp2] = UNIT.str2unit(str2,fund,unit);

if any(F1==0)
    error('parts of unit_1 not recognized')
end
if any(F2==0)
    error('parts of unit_2 not recognized')
end
if any(U1==0)
    error('parts of unit_1 not recognized')
end
if any(U2==0)
    error('parts of unit_2 not recognized')
end

str1
str2
F1
F2
U1
U2

%% match terms
Y = 1;
c1=1;
while c1<=length(F1)
    c2=1;
    while c2<=length(F2)
        
        if F1(c1) == F2(c2)
            f = F1(c1);
            u1 = U1(c1);
            u2 = U2(c2);
            
            exTemp = min(exp1(c1),exp2(c2));
            
           
            
            Y = Y * (conv{f}(u2)/conv{f}(u1))^exTemp;

            exp1(c1) = exp1(c1) - exTemp;
            exp2(c2) = exp2(c2) - exTemp;

            if exp2(c2) == 0
                exp2(c2) = [];
                F2(c2) = [];
                U2(c2) = [];
            else
                c2 = c2 + 1;
            end
        else
            c2 = c2 + 1;
        end
        
        if exp1(c1) == 0
            break;
        end
        
    end
    
    if exp1(c1) == 0
        exp1(c1) = [];
        F1(c1) = [];
        U1(c1) = [];
    else
        c1 = c1 + 1;
    end
end

%% "order of magnitude" unit
c1=1;
while c1<=length(F1)
    if F1(c1)==4 
        Y = Y * 10^exp1(c1);
        
        exp1(c1) = [];
        F1(c1) = [];
        U1(c1) = [];
    else
        c1 = c1 + 1;
    end
end

c2=1;
while c2<=length(F2)
    if F2(c2)==4
        Y = Y / 10^exp2(c2);
        
        exp2(c2) = [];
        F2(c2) = [];
        U2(c2) = [];
    else
        c2 = c2 + 1;
    end
end

X2 = X1*Y;

end

