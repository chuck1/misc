function [ found,a,b,dead ] = backtrack( a,b,n,ispath,unvisited,dead )
%UNTITLED4 Summary of this function goes here
%   Detailed explanation goes here

    found = false;
    
    while true
        dead(a,b) = 1;
        
        progress = false;
        
        o = possible_offsets(a,b,n,0);

        for c=1:size(o,1)
            if ispath(a+o(c,1),b+o(c,2)) && ~dead(a+o(c,1),b+o(c,2))
                progress = true;
                
                a = a+o(c,1);
                b = b+o(c,2);
                
                [ found,a,b ] = randomly_select_unvisited_neighbor( a,b,n,unvisited );

                if found
                    return;
                end
                
                break;
            end
        end
        
        if ~progress
            break;
        end
        
    end

end

