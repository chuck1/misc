function [ tex ] = tex_table( M,format )
%UNTITLED2 Summary of this function goes here
%   Detailed explanation goes here
tex=cell(size(M,1),1);
for row=1:size(M,1)
    tex{row} = sprintf(format{1},M(row,1));
    for col=2:size(M,2)
        tex{row} = [tex{row} ' & ' sprintf(format{col},M(row,col))];
    end
    fprintf('%s\n',tex{row})
end


