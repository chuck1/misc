function [ unvisited ] = visit_unvisted_cells_with_high_wall_adjacency( n,ispath,unvisited )
%UNTITLED5 Summary of this function goes here
%   Detailed explanation goes here
    
    
    for a = 1:n
        for b = 1:n
            count = 0;
            if unvisited(a,b)
                o = possible_offsets(a,b,n,0);
                
                for e=1:size(o,1)
                    count = count + ispath(a+o(e,1),b+o(e,2));
                end
                
                if count > 1
                    unvisited(a,b) = 0;
                end
            end
            
            
            
            
            if unvisited(a,b)
                [ x ] = possible_offset_stencil( a,b,n,ispath );
                
                if sum(any(x,1))>1 && sum(any(x,2))>1
                    unvisited(a,b) = 0;
                end
            end
            
            
            
        end
    end
    
    

end

