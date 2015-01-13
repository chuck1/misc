clear all
close all
clc



n = 10;

ispath = zeros(n);
dead = zeros(n);
unvisited = ones(n);

a = 1;
b = 1;

w = 0;

while true
    
    
    ispath(a,b) = 1;
    unvisited(a,b) = 0;
    
    plot_maze( 1,w,ispath,unvisited,dead )
    
    
    
    [ unvisited ] = visit_unvisted_cells_with_high_wall_adjacency( n,ispath,unvisited );
    
    
    
    plot_maze( 1,w,ispath,unvisited,dead )
    
    
    
    [ found,a,b ] = randomly_select_unvisited_neighbor( a,b,n,unvisited );
    
    
    
    if found
        continue;
    else
        [ found,a,b,dead ] = backtrack( a,b,n,ispath,unvisited,dead );
        
        if found
            continue;
        else
            break;
        end
        
    end
    
end

plot_maze( 1,w,ispath,unvisited,dead )