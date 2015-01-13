close all;clear all;clc

figure()
% load('low_risk_9_v1_mass_estimate.mat')
load('low_risk_9_mass.mat')
hp=plot(1:length(m),m,'ko');
axis([0 11 0 6.5e-5])
hx=xlabel('Tube Number');
hy=ylabel('Mass Flow Rate (kg/s)');
ht=title('low risk 9 v1');
set(hp,'MarkerSize',10,'MarkerFaceColor','k','MarkerEdgeColor','k')
set(gca,'FontSize',16)
set(ht,'FontSize',16)
set(hx,'FontSize',16)
set(hy,'FontSize',16)
% print('-dpng','-r600','low_risk_9_v1_mass_flow')

figure()
% load('low_risk_8_v1_mass_estimate.mat')
load('low_risk_8_mass.mat')
hp=plot(1:length(m),-1*m,'ko');
axis([0 6 0 1.2e-4])
hx=xlabel('Tube Number');
hy=ylabel('Mass Flow Rate (kg/s)');
ht=title('low risk 8 v1');
set(hp,'MarkerSize',10,'MarkerFaceColor','k','MarkerEdgeColor','k')
set(gca,'FontSize',16)
set(ht,'FontSize',16)
set(hx,'FontSize',16)
set(hy,'FontSize',16)
% print('-dpng','-r600','low_risk_8_v1_mass_flow')

%%

clear all
% load('low_risk_8_v1_mass_estimate.mat')
load('med_risk_2a_1_v1_results.mat')
figure()
hp1=plot(Xmean(YAddSum(:,2)>0),abs(YAddSum(YAddSum(:,2)>0,2)),'bo');hold on
hp2=plot(Xmean(YAddSum(:,2)<0),abs(YAddSum(YAddSum(:,2)<0,2)),'ro');
axis([-1e-3 20e-3 0 1e-4])
hx=xlabel('Position (m)');
hy=ylabel('Mass Flow Rate (kg/s)');
ht=title('med risk 2a 1 v1');
set(hp1,'MarkerSize',10,'MarkerFaceColor','b')
set(hp2,'MarkerSize',10,'MarkerFaceColor','r')
set(gca,'FontSize',16)
set(ht,'FontSize',16)
set(hx,'FontSize',16)
set(hy,'FontSize',16)
legend('entrance','exit','Location','NorthWest');
% print('-dpng','-r600','med_risk_2a_1_v1_mass_flow')

%%

p1 = abs(YAddMean(YAddSum(:,2)>0,3));
p2 = abs(YAddMean(YAddSum(:,2)<0,3));

P1 = mean(p1);
P2 = mean(p2);

figure()
hp1=plot(Xmean(YAddSum(:,2)>0),abs(YAddMean(YAddSum(:,2)>0,3)),'bo');hold on
hp2=plot(Xmean(YAddSum(:,2)<0),abs(YAddMean(YAddSum(:,2)<0,3)),'ro');
axis([-1e-3 20e-3 0 1000])
hx=xlabel('Position (m)');
hy=ylabel('Pressure (Pa)');
ht=title('med risk 2a 1 v1');
set(hp1,'MarkerSize',10,'MarkerFaceColor','b')
set(hp2,'MarkerSize',10,'MarkerFaceColor','r')
set(gca,'FontSize',16)
set(ht,'FontSize',16)
set(hx,'FontSize',16)
set(hy,'FontSize',16)
legend('entrance','exit','Location','SouthWest');
% print('-dpng','-r600','med_risk_2a_1_v1_pres')



