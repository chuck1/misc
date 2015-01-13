function [ s,F,U,exp ] = str2unit( str,fund,unit )
%UNTITLED2 Summary of this function goes here
%   Detailed explanation goes here

%% split terms
% units with exponents
s = regexp(str,'\w+(-|\+)\w+','match');

% units without exponents
s_noexp = regexp(str,'$[a-zA-Z]+^','match');

% add '+1' to units without exponents
for a=1:length(s_noexp)
    s_noexp{a} = strcat(s_noexp{a},'+1');
end

% combine units with and without exponents
s = cat(2,s,s_noexp);

s

%% split unit and exponent
exp_str = cell(size(s));
for a=1:length(s)
    exp_str{a} = regexp(s{a},'(-|\+)\w*','match','once');
end
exp = str2double(exp_str);

s = regexp(s,'\w+(?=(-|\+))','match');

s{1}
exp

%% decompose compound units
[comp] = UNIT.compound_units();

a=1;
while a<=length(s)
    val = 0;
    for b=1:size(comp,1)
        
        if strcmp(s{a},comp{b,1}) == 1
            s = [s,comp{b,2}]; %#ok<AGROW>
            exp = [exp,comp{b,3}*exp(a)]; %#ok<AGROW>
            val = 1;
            break;
        end
    end
    if val
        s(a)=[];
        exp(a)=[];
    else
        a = a + 1;
    end
end

%% identify fundamental units


F = zeros(size(s));
U = zeros(size(s));

for a=1:length(s)
    [ F(a),U(a) ] = UNIT.determine_fundamental_unit( s{a},fund,unit );
end

end