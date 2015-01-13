close all
clear all
clc

if ~exist('pressure.mat','file')
    error('file not found')
end

try load('pressure')
    
    Found = zeros(4,1);
    
    if exist('x','var')
       Found(1) = 1;
    end
    
    if exist('p','var')
       Found(2) = 1;
    end
    
    if exist('a','var')
       Found(3) = 1;
    end
    
    if exist('Title','var')
       Found(4) = 1;
    end
    
    if ~all(Found)
        error('variable(s) missing')
    end
    
catch err
    throw(err)
end

%% area-weighted-average
P = zeros(size(p));

for b = 1:size(p,1)
    for c = 1:size(p,2)
        P(b,c) = sum(p{b,c}.*a{b,c})/sum(a{b,c});
    end
end

%% convert Pa to bar

P = P / 100000;

%% plot

figure()


plot(x,P(:,1),'ko');hold on
plot(x,P(:,2),'ks')
    
xlabel('Position (x)')
ylabel('Pressure (bar)')
title(Title)
formatplot('ZeroY',1)
print('-dpng','-r400','pressure')