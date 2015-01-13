close all;clear all;clc

dt=[0.1 0.5 1 2];

for a=1:length(dt)
    [ t{a},x{a} ] = Untitled3( dt(a) );
end

%% plot
figure();hold on
for a=1:length(dt)
    plot(t{a},x{a})
end