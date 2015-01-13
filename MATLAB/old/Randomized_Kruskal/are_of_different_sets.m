function [ result ] = are_of_different_sets( disset,setlen,ind )
%UNTITLED4 Summary of this function goes here
%   Detailed explanation goes here

    
[ ~,~,~,values ] = find_set_containing_value( disset,setlen,ind(1) );

for a = 1:length(ind)
    if ~any(values==ind(a))
        result = true;
        return
    end
end
    
result = false;

end

