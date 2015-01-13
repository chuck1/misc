function [ ] = formatplot( varargin )
%UNTITLED Summary of this function goes here
%   Detailed explanation goes here
%   Properties
%       tex (0,1)
%       ZerY (0,1)
%% process varargin

optStr = {...
    'tex',...
    'ZeroY'};
optVal = {...
    0,...
    0};
nbOpt = length(optStr);

a = 1;
while a <= nargin
    if (a+1)>nargin
        error('Error in formatplot option argument')
    end
    
    FoundOpt = 0;
    for b = 1:nbOpt
        if ~isempty(regexp(varargin{a},optStr{b},'once'))
            FoundOpt = 1;
            optVal{b} = varargin{a+1};
            break;
        end
    end
    if ~FoundOpt
        error('formatplot option not found')
    end
    a = a + 2;
end

%% handles

h_axes = gca;
h_fig  = gcf;

hp = findobj(h_axes,'Type','line');

%% axes limits

xlimit=[inf -inf];
ylimit=[inf -inf];

for a=1:length(hp)
    
    x=get(hp(a),'XData');
    y=get(hp(a),'YData');
    
    xlimit(1)=min(min(min(x,xlimit(1))));
    xlimit(2)=max(max(max(x,xlimit(2))));
    ylimit(1)=min(min(min(y,ylimit(1))));
    ylimit(2)=max(max(max(y,ylimit(2))));
    
    set(hp(a),...
        'MarkerSize',8,...
        'MarkerFaceColor',DRAW.colors(a),...
        'Color',DRAW.colors(a),...
        'Marker',DRAW.markers(a),...
        'LineStyle','none');
end

if optVal{2} % ZeroY
    if all(ylimit<0)
        ylimit(2)=0;
        ylimit=ylimit+0.1*(ylimit(2)-ylimit(1))*[-1 0];
    elseif all(ylimit>0)
        ylimit(1)=0;
        ylimit=ylimit+0.1*(ylimit(2)-ylimit(1))*[0 1];
    end
else
    ylimit=ylimit+0.1*(ylimit(2)-ylimit(1))*[-1 1];
end

xlimit=xlimit+0.1*(xlimit(2)-xlimit(1))*[-1 1];




%% axes


set(h_axes,...
    'FontSize',16,...
    'Box','on',...
    'XLim',xlimit,...
    'YLim',ylimit)

%% labels

set(get(h_axes,'XLabel'),...
    'FontSize',16,...
    'FontWeight','bold'...
    )

set(get(h_axes,'YLabel'),...
    'FontSize',16,...
    'FontWeight','bold'...
    )

%% title

set(get(h_axes,'Title'),...
    'FontSize',16 ...
    )

%% legend

h_legend = findobj(h_fig,'Type','axes','Tag','legend');



%% latex interpreter

if optVal{1}
    set(get(h_axes,'XLabel'),...
        'Interpreter','latex'...
        )

    set(get(h_axes,'YLabel'),...
        'Interpreter','latex'...
        )
    
    set(h_legend,'Interpreter','latex');
end

%% figure options
pap = [6 4];
set(h_fig,'PaperSize',[pap(1) pap(2)],'PaperPosition',[0 0 pap(1) pap(2)])

end

