function [ startind,len,setno,values ] = find_set_containing_value( disset,setlen,value )
%UNTITLED5 Summary of this function goes here
%   Detailed explanation goes here

startind = 1;
setno = 1;

while startind < length(disset)
    len = setlen(setno);
    values = disset(startind:(startind+len-1));
    
    for a=1:length(values)
        if values(a)==value
            return
        end
    end
    
    startind = startind + len;
    setno = setno + 1;
    
end

startind = 0;
len = 0;
setno = 0;
values = [];


end

