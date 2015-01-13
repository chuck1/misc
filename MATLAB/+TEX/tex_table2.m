function [ tex_line ] = tex_table2( c,filename )
%UNTITLED6 Summary of this function goes here
%   Detailed explanation goes here
head=3;
foot=3;

tex_line=cell(1,size(c,1)+head+foot);



for row=1:size(c,1)
    
    [str,col_countdown] = get_str(c,row,1);
    
    tex_line{row+head} = str;
    
    for col=2:size(c,2)
        if col_countdown>0
            col_countdown = col_countdown-1;
%             tex_line{row+head} = [tex_line{row+head} ' & '];
        else
            [str,col_countdown] = get_str(c,row,col);
            tex_line{row+head} = [tex_line{row+head} ' & ' str];
        end
    end
    
    tex_line{row+head} = [tex_line{row+head} '\\\hline'];
end

col_str='|';
for col=1:size(c,2)
    col_str=[col_str 'c|'];
end

%% head
tex_line{1}    = '\begin{center}';
tex_line{2}    = '\resizebox{\textwidth}{!}{';
tex_line{3}    =['\begin{tabular}{' col_str '}\hline'];

%% foot

tex_line{end-2}= '\end{tabular}';
tex_line{end-1}= '}';
tex_line{end}  = '\end{center}';

%% print to screen

for row=1:length(tex_line)
    fprintf('%s\n',tex_line{row})
end

fileID = fopen(filename,'w')

for row=1:length(tex_line)
    fprintf(fileID,'%s\n',tex_line{row});
end

fclose(fileID);

end

function [str,col_countdown]=get_str(c,row,col)

col_countdown=0;
str = c{row,col};
if isempty(str)
    str = '';
else
    if ~isempty(regexp(str,'\\c(\d)(.*)','once'))
        col_countdown_str=regexp(str,'(?<=\\c)\d','match');
        col_countdown = str2num(col_countdown_str{1}) - 1; %#ok<ST2NM>
        str = regexprep(str,'\\c(\d)(.*)','\\multicolumn{$1}{|c|}{$2}');
    end
    
    if ~isempty(regexp(str,'\\r(\d)(.*)','once'))
        str = regexprep(str,'\\r(\d)(.*)','\\multirow{$1}{*}{$2}');
    end
end



end
