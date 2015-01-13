classdef single_var_statistic
    %UNTITLED Summary of this class goes here
    %   Detailed explanation goes here
    
    properties
        standard_deviation
        N
        mean
        max
        min
        Y
    end
    
    methods
        function obj=single_var_statistic(y)
            obj.Y=y;
            obj.N=length(obj.Y);
            obj.mean=mean(obj.Y);
        end
    end
    
end

