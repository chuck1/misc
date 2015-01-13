close all
clc
clear all


size_array = [];
file_array = {};

fid = fopen('dir_size.txt');

tline = fgetl(fid);
while ischar(tline)
    %disp(tline)
    
    size = str2double(regexp(tline, '^\d+', 'match'));
    
    file = regexp(tline, '^\d+\s+([^\s]+)', 'tokens');
    file = file{1};
    
    %display(size)
    %display(file)
    
    size_array = cat(1,size_array,size);
    file_array = cat(1,file_array,file);
    
    tline = fgetl(fid);
end

fclose(fid);

%% separate total

total = size_array(end);

size_array(end) = [];
file_array(end) = [];

%% replace small entries with 'other'

small = 0.05;

small_ind = 1:length(size_array);

small_ind = small_ind(size_array < (total * small));

small_total = sum(size_array(small_ind));

size_array(small_ind) = [];
file_array(small_ind) = [];

size_array = cat(1,size_array,small_total);
file_array = cat(1,file_array,'other');

%% plot

size_str_array = cell(1,length(size_array));

for a = 1:length(size_array)
    size_str_array{a} = num2str(size_array(a));
end

h = pie(size_array,size_str_array);

hl = legend(file_array);

%get(get(h(1),'parent'))

%ha = get(h(1),'Annotation');
%get(get(ha,'LegendInformation'))

%set(gca,'Interpreter','none')

%set(get(gca,'YLabel'),'Interpreter','tex')

set(hl,'Interpreter','none','Location','NorthWestOutside')

get(h(1))

for a=1:length(h)
    %set(h(a),'Interpreter','none');
end

%fprintf('%s\n',F)