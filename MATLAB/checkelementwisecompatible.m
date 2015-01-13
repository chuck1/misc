function [ SZ,A ] = checkelementwisecompatible( A )
%UNTITLED5 Summary of this function goes here
%   Detailed explanation goes here
SZ = [1 1];


for a=1:length(A)
    if (~isequal(size(A{a}),SZ))&&(~isscalar(A{a}))
        if isequal(SZ,[1 1])
            SZ = size(A{a});
        else
            error('Not compatible for elementwise operations!')
        end
    end
end

for a=1:length(A)
    if isscalar(A{a})
        if isa(A{a},'double')
            A{a} = A{a} * ones(SZ);
        end
    end
end


end

