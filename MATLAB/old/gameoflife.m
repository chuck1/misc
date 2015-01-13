close all
clear all
clc

% m=zeros(20);
m=rand(50);

c = 0.7;

m(m>c)=1;
m(m<=c)=0;
N=20;

B = [3];
S = [1 2 3 4];

for n=1:N
    neighbors = zeros(size(m));
    for a=1:size(m,1)
       for b=1:size(m,2)
           neighbors(a,b) = neighbors(a,b) + m(PeriodicIndex(a-1,size(m,1)),b);
           neighbors(a,b) = neighbors(a,b) + m(PeriodicIndex(a+1,size(m,1)),b);
           neighbors(a,b) = neighbors(a,b) + m(a,PeriodicIndex(b-1,size(m,2)));
           neighbors(a,b) = neighbors(a,b) + m(a,PeriodicIndex(b+1,size(m,2)));
       end
    end
    
%     figure(2)
%     contour(neighbors)
    for a=1:size(m,1)
        for b=1:size(m,2)
            if m(a,b)
                if ( any( neighbors(a,b) == S ) )
                else
                    m(a,b)=0;
                end
            else
                if ( any( neighbors(a,b) == B ) )
                    m(a,b)=1;
                end
            end
        end
    end
    
    figure(1)
%     contourf(m,[0.5 0.5])
    disc_plot(m)
    grid on
    pause(0.01)
end