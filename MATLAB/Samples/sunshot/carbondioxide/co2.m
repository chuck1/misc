function [ out ] = co2( str1 , str2 , arg )
%UNTITLED Summary of this function goes here
%   Detailed explanation goes here
load('co2_coeff','poly')
switch str1
    case 'cp'
        switch str2
            case 'T'
                out = polyval(poly{1},arg); %#ok<USENS>
        end
    case 'k'
        switch str2
            case 'T'
                out = polyval(poly{2},arg);
        end
    case 'mu'
        switch str2
            case 'T'
                out = polyval(poly{3},arg);
        end
    case 'rho'
        switch str2
            case 'T'
                out = polyval(poly{4},arg);
        end
    case 'h'
        switch str2
            case 'T'
                out = polyval(poly{5},arg);
        end
    case 'cv'
        switch str2
            case 'T'
                out = polyval(poly{6},arg);
        end
    case 'alpha'
        switch str2
            case 'T'
                out = polyval(poly{7},arg);
        end
    case 'T'
        switch str2
            case 'h'
                out = polyval(poly{8},arg);
        end    
end
end