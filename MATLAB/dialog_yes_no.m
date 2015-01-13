function [ res ] = dialog_yes_no( str )
%UNTITLED Summary of this function goes here
%   Detailed explanation goes here

choice = questdlg(str, 'Dialog', ...
    'Yes','No','Yes');

switch choice
    case 'Yes'
        res = 1;
    case 'No'
        res = 0;
    otherwise
        res = 0;
end


end

