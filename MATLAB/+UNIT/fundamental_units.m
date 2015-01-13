function [fund,unit,conv] = fundamental_units()

%% length
fund{1} = 'L';
unit{1} = { 'm'     'cm'	'ft'};
conv{1} = [ 1       100     3.28084];

%% time
fund{2} = 'T';
unit{2} = {'s'  'min'};
conv{2} = [1    1/60];

%% mass
fund{3} = 'M';
unit{3} = {'kg'     'g'};
conv{3} = [1        1000];

%% order of magnitude
fund{4} = '10E';
unit{4} = {'10E'};
conv{4} = 1;

%% temperature
fund{5} = 'T';
unit{5} = {'K'};
conv{5} = 1;

end