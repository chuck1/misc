close all
clear x m p
clc

load('export_data_2.mat')
p1=p;

figure(1)
plot(x,m,'bo');hold on

figure(2)
plot(x,p,'bo');hold on

load('export_data_1.mat')
p2=p;

figure(1)
plot(x,m,'ro')
xlabel('position (m)')
ylabel('mass flow (kg/s)')
legend('exit','entrance','Location','NorthOutside')
formatplot('ZeroY',1)
print('-dpng','-r400','mass_flow')

figure(2)
plot(x,p,'ro')
xlabel('position (m)')
ylabel('pressure (Pa)')
legend('exit','entrance','Location','NorthOutside')
formatplot('ZeroY',1)
print('-dpng','-r400','pressure')

%%
dp1 = range(p1);
dp2 = range(p2);
dp = abs(mean(p2-p1));

dev = abs((m-mean(m))/mean(m));
fprintf('pressure ratio entrance: %f\n',dp/dp1)
fprintf('pressure ratio exit: %f\n',dp/dp2)
fprintf('average pressure drop through channel: %f\n',dp)
fprintf('percent maximum deviation from mean: %.2f\n',max(dev)*100)