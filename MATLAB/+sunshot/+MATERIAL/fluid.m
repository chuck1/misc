classdef fluid < handle
    %FLUID Summary of this class goes here
    %   Detailed explanation goes here
    
    properties
        isobar;
        
        
        
    end
    
    methods
        
        function AddIsobar(c,P)
            
            for a = 1:length(c.isobar)
                if c.isobar(a).pressure == P
                    error('Pressure already exists!!')
                end
            end
            
            newIsobar = sunshot.MATERIAL.fluid_isobar(P);
            
            c.isobar = cat(1,c.isobar,newIsobar);
            
        end
        
        function y=Get(c,propStr,P,T)
            
            for a = 1:length(c.isobar)
%                 disp(c.isobar(a).pressure)
                if c.isobar(a).pressure == P
                    y = c.isobar(a).Get(propStr,T);
                    
                    return
                end
            end
            error('Pressure not found!!')
        end
    end
    
end

