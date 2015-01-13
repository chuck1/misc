function [] = disc_plot( A,color )
%UNTITLED2 Summary of this function goes here
%   Detailed explanation goes here
% clf

for a=1:size(A,1)
    for b=1:size(A,2)
        r=rectangle('Position',[a,b,1,1]);
        set(r,'EdgeColor','none')
        if A(a,b)
            set(r,'FaceColor',color)
        end
    end
end

end

