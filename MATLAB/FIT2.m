classdef FIT2 < handle
    %UNTITLED Summary of this class goes here
    %   Detailed explanation goes here
    
    properties
        type
        data
        mae
    end
    
    methods
        
        function polyfit(c,x,y,n)
            warning('OFF','MATLAB:polyfit:RepeatedPointsOrRescale')
            
            c.data = polyfit(x,y,n);
            
            c.type = 'poly';
            
            c.CalcMAE(x,y);
            
            warning('ON','MATLAB:polyfit:RepeatedPointsOrRescale')
        end
        
        function powerfit(c,x,y)
            c.data = powerfit(x,y);
            c.type = 'power';
            
            c.CalcMAE;
        end
        
        function CalcMAE(c,x,y)
            err = zeros(size(x));
            for a=1:length(x)
                err(a) = abs( ( y(a)-c.val(x(a)) )/y(a) );
            end
            c.mae = mean(err)*100;
        end
        
        function [Y] = val(c,X)
            if strcmp(c.type,'poly') == 1
                Y = polyval(c.data,X);
            elseif strcmp(c.type,'power') == 1
                Y = powerval(c.data,X);
            else
                error('Fit type unknown!')
            end
        end
        
        
        function []=print(c,ylab,fid)
%             fprintf('%s mae=%f\n',c.ylab,c.mae)
            fprintf(fid,'\t\t(%s ',ylab);
            switch c.type
                case 'poly'
                    c.printpolyfit(fid);
                case 'power'
                    c.printpowerfit();
            end
        end
        
        function []=printpolyfit(c,fid)
            for a=1:length(c.data)
%                 fprintf('%i\t\t\t\t',a-1)
            end
            fprintf(fid,'(polynomial ');
            for a=1:length(c.data)
                fprintf(fid,'%.17e ',c.data(length(c.data)-a+1));
            end
            fprintf(fid,')');
        end
        
        function []=printpowerfit(c)
            fprintf('%s\n',ylab)
            fprintf('reference temeprature: %e\n',c.data(2))
            fprintf('reference value:       %e\n',c.data(3))
            fprintf('exponent:              %e\n',c.data(1))
        end
        
    end
    
end

