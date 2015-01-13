close all
clear all
clc


nx = 10;
ny = 10;

N = nx*ny;

wall = ones(nx,ny);



disset = 1:N;
setlen = ones(1,N);

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



%% loop

while ~isempty(wallind)
    
    
    % randomly select a wall
    a = ceil(rand()*length(wallind));

    % wall has been visited
    wallind(a) = [];

    % select cells adjacent to wall
    [ ind ] = adjacent_wall_indicies( wallindx(a),wallindy(a),nx,ny,0,WallInd );

    % are the cell indicies of different sets?
    [ result ] = are_of_different_sets( disset,setlen,ind );

    if result
        % remove wall
        wall(a) = 0;

        %% join sets

        ind = [ind a];

        [disset,setlen] = join_sets_containing_indicies(disset,setlen,ind);



    end

end

figure(1)
clf
disc_plot(wall,'k')
