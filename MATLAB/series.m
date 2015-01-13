classdef series < handle
    %SERIES 2D data series
    %   Detailed explanation goes here
    
    properties
        name
        
        x_orig
        y_orig
        x
        y
        
        
        
        fit
        
        xlab
        ylab
        xunit
        yunit
        
        xref
    end
    
    methods
        function c=series(name_,X,Y)
            c.name = name_;
            
            c.x_orig=X;
            c.y_orig=Y;
            c.x=X;
            c.y=Y;
            
%             c.xlab = Xlab;
%             c.ylab = Ylab;
%             c.xunit = Xunit;
%             c.yunit = Yunit;
%             
%             c.xref = Xref;
            
            c.fit = FIT2;
        end
        
        function trim(c,first,last)
            c.x=c.x_orig(first:(end+1-last));
            c.y=c.y_orig(first:(end+1-last));
        end
        
        function TrimVal(c,first,last)
            c.x=c.x_orig((c.x_orig>first) & (c.x_orig<last));
            c.y=c.y_orig((c.x_orig>first) & (c.x_orig<last));
        end
        
        function h=plot_orig(c)
            h=plot(c.x_orig,c.y_orig,'o');
        end
        function h=plot(c)
            h=plot(c.x,c.fit.val(c.x),'b-');hold on
            plot(c.x,c.y,'ro');
        end
        
        function polyfit(c,n)
            c.fit.polyfit(c.x,c.y,n);
        end
        
        function powerfit(c)
            c.fit.polyfit(c.x,c.y);
        end
        
        function plot_vline(c,X)
            for a=1:length(X)
                plot([1 1]*X(a),[c.y_orig(1) c.y_orig(end)])
            end
        end
        
        function plot_all(c)
            c.plot_orig;hold on
            c.plot_vline(c.xref)
            c.plot();
            xlabel(c.xlab)
            ylabel(c.ylab)
        end
        
        function printFit(c,fid)
            c.fit.print(c.ylab,fid);
        end
        
        function [y] = val(c,x)
            y = c.fit.val(x);
        end
        
        function convert(c,XUNIT,YUNIT)
            c.x = UNIT.convert(c.x,c.xunit,XUNIT);
            c.y = UNIT.convert(c.y,c.yunit,YUNIT);
        end
    end
    
end

