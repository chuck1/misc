function [  ] = tickformat( ha,str,format )
%UNTITLED2 Summary of this function goes here
%   Detailed explanation goes here
if strcmp(str,'X')==1 || strcmp(str,'Y')==1

    y=get(ha,[str 'Tick']);
    tl=cell(size(y));

    for a=1:length(get(gca,[str 'Tick']))
        tl{a}=sprintf(format,y(a));
    end
    
    set(gca,[str 'TickLabel'],tl)

end

end

