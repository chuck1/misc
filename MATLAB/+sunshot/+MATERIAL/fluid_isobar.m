classdef fluid_isobar < handle
    %FLUID_ISOBAR Summary of this class goes here
    %   Detailed explanation goes here
    
    properties
        pressure
        
        prop
        
    end
    
    methods
        function c=fluid_isobar(pressure_)
            c.pressure = pressure_;
        end
        function load_csv(c,STR,XUNIT,YUNIT)
            
            for a = 1:length(c.prop)
                if strcmp( c.prop(a).name, STR ) == 1
                    error('Property already exists!!')
                end
            end
            
            FILENAME = [STR '.csv'];
            M = csvread(FILENAME);
            
            newprop = series(STR,M(:,1),M(:,2));
            
            c.prop = cat(1,c.prop,newprop);
            
        end
        function load_EES_txt(c)
            
            Tin = 500 + 273.15;
            Tout = 650 + 273.15;

            filename = [num2str(c.pressure) '.txt'];
            fid = fopen(filename);
            
            nbCol = 0;

            data = [];
            a = 1;
            tline = fgetl(fid);
            first = 1;
            while ischar(tline)

                linesplit = regexp(tline,'\s+','split');
                tlinedata=[];

                if first
                    nbCol = length(linesplit);
                    first = 0;
                end

                if nbCol ~= length(linesplit)
                    error('inconsistent')
                end

                for b=1:length(linesplit)
                    tlinedata = cat(2,tlinedata,str2double(linesplit{b}));
                end
                a = a + 1;

                if isempty(data)
                    data = tlinedata;
                else
                    data = cat(1,data,tlinedata);
                end

                tline = fgetl(fid);

            end
            
            
            
            T   = data(:,2);
            
%             c.prop = series(T,data(:,6),...
%                 'temperature','(K)','density','(Kg/m3)',[Tin Tout]);
% 
%             c.prop(2) = series(T,data(:,3),...
%                 'temperature','(K)','specific-heat','(J/kg K)',[Tin Tout]);
% 
%             c.prop(3) = series(T,data(:,4),...
%                 'temperature','(K)','thermal-conductivity','(W/m K)',[Tin Tout]);
% 
%             c.prop(4) = series(T,data(:,5),...
%                 'temperature','(K)','viscosity','(Pa s)',[Tin Tout]);
            
            c.prop = series('density',T,data(:,6));
            
            c.prop(2) = series('specific-heat',T,data(:,3));

            c.prop(3) = series('thermal-conductivity',T,data(:,4));

            c.prop(4) = series('viscosity',T,data(:,5));
            
            for a=1:4
                c.prop(a).polyfit(4);
            end
            
            
            
            fid = fopen(sprintf('carbon_dioxide%.0f.scm',c.pressure),'w');
%             fid = 1;
            
            fprintf(fid,'(\n\t(carbon-dioxide fluid\n');
            fprintf(fid,'\t\t(chemical-formula . #f)\n');
            for a=1:4
                c.prop(a).printFit(fid);
                fprintf(fid,')\n');
            end
            fprintf(fid,'\t)\n');
            fprintf(fid,')\n');
            
            if fid ~= 1
                fclose(fid);
            end
        end
        
        function y = Get(c,propStr,T)
            for a=1:length(c.prop)
                if strcmp(c.prop(a).name,propStr) == 1
                    y = c.prop(a).val(T);
                    return
                end
            end
            error('Property not found!!')
            
        end
        
    end
    
end

