function [ pfig ] = plot2figposition( handaxes,pplot )
%UNTITLED3 Summary of this function goes here
%   Detailed explanation goes here
paxes = get(handaxes,'Position');
paxes_0=paxes(1:2);
paxes_1=paxes(3:4);

pplot_0=pplot(1:2);
pplot_1=pplot(3:4);

plotxlim=get(handaxes,'XLim');
plotylim=get(handaxes,'YLim');

plotlim_0=[plotxlim(1) plotylim(1)];
plotlim_1=[plotxlim(2) plotylim(2)];

pfig_0 = paxes_0 + (pplot_0-plotlim_0)./(plotlim_1-plotlim_0).*paxes_1;
pfig_1 = pplot_1./(plotlim_1-plotlim_0).*paxes_1;

pfig = [pfig_0 pfig_1];

end

