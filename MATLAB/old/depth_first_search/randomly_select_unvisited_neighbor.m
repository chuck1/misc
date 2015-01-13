function [ found,a,b ] = randomly_select_unvisited_neighbor( a,b,n,v )
%UNTITLED3 Summary of this function goes here
%   Detailed explanation goes here
    
    o = possible_offsets(a,b,n,0);
    m = size(o,1);
    
    found = false;
    
    checked = zeros(1,m);
    
    while any(~checked)
        c = rand(1,m);
        c(checked==1) = 0;
        [~,I] = max(c);
        
        checked(I) = 1;
        
        c = I;
        
        if v(a+o(c,1),b+o(c,2))
            a = a+o(c,1);
            b = b+o(c,2);
            found = true;
            break;
        end
    end

end

