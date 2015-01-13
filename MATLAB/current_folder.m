function [ str ] = current_folder()
%UNTITLED7 Summary of this function goes here
%   Detailed explanation goes here
str = pwd;
str = regexp(str,'\<\w*\>','match');
str = str{end};

end

