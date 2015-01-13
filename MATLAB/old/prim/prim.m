close all
clear all
clc

nx = 50;
ny = 50;

N = nx*ny;

wall = ones(nx,ny);

walllist = [];



wallind = 1:N;

WallInd = zeros(nx,ny);
for a = 1:N
    WallInd(a) = a;
end

wallindx = zeros(1,N);
wallindy = zeros(1,N);
for a=1:nx
    for b=1:ny
        wallindx(WallInd(a,b)) = a;
        wallindy(WallInd(a,b)) = b;
    end
end

% pick a cell

a = ceil(rand()*N);

% remove wall
wall(a) = 0;

% add walls of cell to wall list
[ walllist ] = add_adjacent_walls_to_walllist( a,nx,ny,WallInd,wallindx,wallindy,wall,walllist );

while ~isempty(walllist)
    figure(1)
    clf
    disc_plot(wall,'k')
    pause(0.1)
    
    % pick a random wall in the list
    a = ceil(rand()*length(walllist));
    
    % index of that wall cell
    b = walllist(a);
    
    % identify adjacent cells
    [ ind ] = adjacent_wall_indicies( wallindx(b),wallindy(b),nx,ny,0,WallInd );
    
    % identify adjacent path cells
    path_ind = ind;
    path_ind(wall(ind)==1) = [];
    
    % remove path cells from adjacent cells
    for c = 1:length(path_ind)
        ind(ind==path_ind(c)) = [];
    end
    
    
    path_x = wallindx(path_ind);
    path_y = wallindy(path_ind);
    
    x = wallindx(ind);
    y = wallindy(ind);
    
    if length(path_ind)==1
        opposite = ind(x==path_x);
        
        if isempty(opposite)
            opposite = ind(y==path_y);
        end
        
        if ~isempty(opposite)
        
            

            wall(b) = 0;
            wall(opposite) = 0;

            % add walls of new path cells to walllist
            [ walllist ] = add_adjacent_walls_to_walllist( opposite,nx,ny,WallInd,wallindx,wallindy,wall,walllist );

        end
        
        
    end
    
    % remove wall from walllist
    walllist(a) = [];
    
end


figure(1)
clf
disc_plot(wall,'k')




