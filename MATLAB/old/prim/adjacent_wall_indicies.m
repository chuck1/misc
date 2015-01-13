function [ ind ] = adjacent_wall_indicies( a,b,nx,ny,corners,WallInd )
%UNTITLED2 Summary of this function goes here
%   Detailed explanation goes here
    if corners
        o = [...
            -1 0;...
            1 0;...
            0 -1;...
            0 1;...
            -1 -1;...
            1 -1;...
            -1 1;...
            1 1];
    else
        o = [...
            -1 0;...
            1 0;...
            0 -1;...
            0 1];
    end
    
    
    c=1;
    while c<=size(o,1)
        
        if ( (o(c,1)==-1) && (a==1) ) || ( (o(c,1)==1) && (a==nx) ) ||...
                ( (o(c,2)==-1) && (b==1) ) || ( (o(c,2)==1) && (b==ny) )
            o(c,:)=[];
        else
            c=c+1;
        end
    end
    
    ind = zeros(1,size(o,1));
    for c = 1:size(o,1)
        ind(c) = WallInd(a+o(c,1),b+o(c,2));
    end
    
    
    
end
