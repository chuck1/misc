function [ ret ] = search( s0,search_str )
%UNTITLED6 Summary of this function goes here
%   Detailed explanation goes here
path='';


if search_sub(search_str)
    ret = return_str(path,search_str);
    return
end


try 
    cd(s0)
    found=search_sub(search_str);
    cd ../
    if found
        path=[s0 '/'];
        ret = return_str(path,search_str);
        return
    end
catch err 
    err %#ok<NOPRT>
end

[found,path] = descend(search_str);
if found
    ret = return_str(path,search_str);
    return
end

ret=search_str;

end

function [found,path] = descend(search_str)
found=false;
path='';

if strcmp(current_folder,'doc')
    return
else
    prev_folder = current_folder;
    cd ../
    path=[path '../'];
    if search_sub(search_str)
        found=true;
        cd(prev_folder)
        return
    else
        descend(search_str)
    end
    cd(prev_folder)
end

end

function [found] = search_sub(search_str)
found=false;
l = dir;
for a=1:length(l)
    if strcmp(l(a).name,[search_str '.txt'])
        found=true;
        return
    end
end

end

function [str] = return_str(path,search_str)

str = ['<a href="' path search_str '.html">' search_str '</a>'];

end