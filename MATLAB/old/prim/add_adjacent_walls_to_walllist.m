function [ walllist ] = add_adjacent_walls_to_walllist( a,nx,ny,WallInd,wallindx,wallindy,wall,walllist )
%UNTITLED8 Summary of this function goes here
%   Detailed explanation goes here
if isempty(a)
    error('a is empty')
end

[ ind ] = adjacent_wall_indicies( wallindx(a),wallindy(a),nx,ny,0,WallInd );

ind(wall(ind)==0) = [];

walllist = cat( 2, walllist, ind );

walllist = unique(walllist);

end

