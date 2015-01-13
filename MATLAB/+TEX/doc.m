classdef doc < handle
    %DOC Summary of this class goes here
    %   Detailed explanation goes here
    
    properties
        FID
        FILENAME
        FILENAME_WO_EXT
    end
    
    methods
        function [FID_] = open(c,FILENAME_,PERMISSION)
            c.FILENAME = FILENAME_;
            c.FILENAME_WO_EXT = regexp(FILENAME_,'.*(?=\.tex)','match');
            c.FILENAME_WO_EXT = c.FILENAME_WO_EXT{1};
            
            FID_ = fopen(FILENAME_,PERMISSION);
            c.FID = FID_;
        end
        
        function BYTES = print(varargin)
            FORMAT = '';
            c=varargin{1};
            
            a = 2;
            while a <= length(varargin)
                arg = varargin{a};
                S = whos('arg');
                if ( strcmp(S.class,'char') == 1 )
                    if ~isempty(regexp(arg,'^(\\n)+$','once'))
                        FORMAT = strcat(FORMAT,arg);
                        fprintf('breakline found!\n')
                        varargin(a) = [];
                        continue
                    end
                    FORMAT = strcat(FORMAT,'%s');
                elseif ( strcmp(S.class,'double') == 1 )
                    FORMAT = strcat(FORMAT,'%0.3g');
                end
                
                a = a + 1;
            end
            
            
            STR = sprintf(FORMAT,varargin{2:length(varargin)});
            
            STR = regexprep(STR,'(\d+\.)?(\d+)e(\+|-)0*(\d+)','$1$2\\times 10^{$3$4}');
            
            BYTES = fprintf(c.FID,'%s',STR);
            
        end
        
        function [  ] = figure( c,file,cap )
            %UNTITLED Summary of this function goes here
            %   Detailed explanation goes here

            print('-depsc2',['tex\figures\' file])

            fprintf(c.FID,'%s\n','\begin{figure}[ht]');
            fprintf(c.FID,'%s\n','\centering');
            fprintf(c.FID,'%s\n',['\includegraphics[width=0.5\columnwidth]{figures/' file '.eps}']);
            fprintf(c.FID,'%s\n',['\caption{' cap '}']);
            fprintf(c.FID,'%s\n',['\label{' file '}']);
            fprintf(c.FID,'%s\n','\end{figure}');


        end
        
        function close(c)
            fclose(c.FID);
        end
        
        function pdflatex(c)
            
            system(['pdflatex ',c.FILENAME]);
            
            open([c.FILENAME_WO_EXT,'.pdf'])
        end
        
        function default_header(c)
            fprintf(c.FID,'%s\n','\documentclass{article}');
            fprintf(c.FID,'%s\n','\usepackage{fullpage}');
            fprintf(c.FID,'%s\n','\usepackage{amsmath}');
            fprintf(c.FID,'%s\n','\usepackage{graphicx}');
            fprintf(c.FID,'%s\n','\usepackage{mathtools}');
            fprintf(c.FID,'%s\n','\usepackage[final]{pdfpages}');
            fprintf(c.FID,'%s\n','\usepackage{url}');
            fprintf(c.FID,'%s\n','\usepackage[]{natbib}');
            fprintf(c.FID,'%s\n','\usepackage{setspace}');
            fprintf(c.FID,'%s\n','\usepackage{epstopdf}');
            fprintf(c.FID,'%s\n','\usepackage[pdftex,bookmarks=true]{hyperref}');

            fprintf(c.FID,'%s\n','\onehalfspacing');

            fprintf(c.FID,'%s\n','\bibliographystyle{plainnat}');
            fprintf(c.FID,'%s\n','%\bibliography{bib}');

            fprintf(c.FID,'%s\n','\newcommand{\pp}[2]{\frac{\partial #1}{\partial #2}}');
            fprintf(c.FID,'%s\n','\newcommand{\ppp}[2]{\frac{\partial^2 #1}{\partial #2^2}}');
            fprintf(c.FID,'%s\n','\newcommand{\pppa}[3]{\frac{\partial^2 #1}{\partial #2 \partial #3}}');
            fprintf(c.FID,'%s\n','\newcommand{\dd}[2]{\frac{d #1}{d #2}}');
            fprintf(c.FID,'%s\n','\newcommand{\ddd}[2]{\frac{d^2 #1}{d #2^2}}');
            fprintf(c.FID,'%s\n','\newcommand{\DD}[2]{\frac{D #1}{D #2}}');
            fprintf(c.FID,'%s\n','\newcommand{\dede}[2]{\frac{\delta #1}{\delta #2}}');
            fprintf(c.FID,'%s\n','\newcommand{\dedede}[2]{\frac{\delta^2 #1}{\delta #2^2}}');
            fprintf(c.FID,'%s\n','\newcommand{\E}[1]{\times 10^{#1}}');

            fprintf(c.FID,'%s\n','\newcommand{\bomega}{\boldsymbol\omega}');

            fprintf(c.FID,'%s\n','\DeclareMathOperator{\sech}{sech}');

        end
    end
    
end

