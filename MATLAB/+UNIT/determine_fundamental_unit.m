function [ F,U ] = determine_fundamental_unit( str,f,u )
%UNTITLED2 Summary of this function goes here
%   Detailed explanation goes here
F=0;
U=0;



for a=1:length(f)
    for b=1:length(u{a})
        if strcmp(str,u{a}{b}) == 1
            F = a;
            U = b;
        end
    end
end



end

