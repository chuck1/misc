close all
clear all
clc

if ~exist('mass_flow.mat','file')
    error('file not found')
end

try load('mass_flow')
    
    Found = zeros(3,1);
    
    if exist('x','var')
       Found(1) = 1;
    end
    
    if exist('y','var')
       Found(2) = 1;
    end
    
    if exist('Title','var')
       Found(3) = 1;
    end
    
    if ~all(Found)
        error('variable(s) missing')
    end
    
catch err
    throw(err)
end

figure()
plot(x,y,'ko')
xlabel('Position (x)')
ylabel('Mass Flow (kg/s)')
title(Title)
formatplot('ZeroY',1)
print('-dpng','-r400','mass_flow')