clear all
close all
clc




%% construct surfaces

n_sur = 1000;

sur_start = cell(1,n_sur);
sur_end = cell(1,n_sur);

r = 3;
r = linspace(-r,r,n_sur+1);

for a = 1:n_sur
    sur_start{a} = [r(a);r(a)^2];
    sur_end{a}   = [r(a+1);r(a+1)^2];
end


% sur_start{1} = [0;0];
% sur_end{1}   = [0.25;0.5];
% 
% sur_start{2} = [0.25;0.5];
% sur_end{2}   = [1;1];
% 
% sur_start{3} = [0;0];
% sur_end{3}   = [0.25;-0.5];
% 
% sur_start{4} = [0.25;-0.5];
% sur_end{4}   = [1;-1];
% 
% 
% 
% sur_start{5} = [1;1];
% sur_end{5}   = [4;2];
% 
% sur_start{6} = [1;-1];
% sur_end{6}   = [4;-2];
% 
% sur_start{7} = [4;2];
% sur_end{7}   = [9;3];
% 
% sur_start{8} = [4;-2];
% sur_end{8}   = [9;-3];

%% construct rays


n_ray = 100;

origin = [-5;20];

rays = cell(n_ray,1);

% point source

for a = 1:n_ray
    rays{a}{1}.o = origin;
    rays{a}{1}.d = [cos(2*pi*a/n_ray);sin(2*pi*a/n_ray)];
end

% infinite distance

space = [0.1;0];

for a = 1:n_ray
    rays{a}{1}.o = origin + a*space;
    rays{a}{1}.d = [0;-1];
end

%% run

for a = 1:n_ray
    while true
    
        sur_ind = 0;
        k = 0.00000001;
        
        fprintf('tracing ray{%i}{%i}\n',a,length(rays{a}));
        
        d = rays{a}{end}.d;
        
        for b = 1:n_sur
            
            d_sur = sur_end{b} - sur_start{b};
            d_ray = d;
            
            o_sur = sur_start{b};
            o_ray = rays{a}{end}.o;
            
            k_temp = intersect( d_sur, d_ray, o_ray, o_sur );
            
            if ( k_temp > k )
                k = k_temp;
                sur_ind = b;
                
                fprintf('k = %.20f\n',k);
                
                if (k<0.000001)
                    error('wtf!\n');
                end
                
                if (k==0)
                    error('wtf!\n');
                end
            end
        end
        
        
        
        
       
        
        
        if sur_ind==0;
            rays{a}{end}.e = rays{a}{end}.o + d * 100;
            
            break
        else
            if length(rays{a}) > 100
                break
            end
            
            e = rays{a}{end}.o + d * k;
            rays{a}{end}.e = e;
            
            
            
            rays{a} = cat(1,rays{a},rays{a}{end});
            
            
            
            rays{a}{end}.o = e;
            
            t = sur_end{sur_ind} - sur_start{sur_ind};
            t = t/(sqrt(dot(t,t)));
            
            n = [0 -1;1 0] * t;
            
            
%             display(d);
%             display(t);
%             display(n);
            
            
            
            d_n = dot(d,n)*n;
            d_t = dot(d,t)*t;
            
            d = d_t - d_n;
            
%             display(d);
            
            rays{a}{end}.d = d;
            
        end
    end
end

figure(1)
for a = 1:n_sur
    plot([sur_start{a}(1) sur_end{a}(1)],[sur_start{a}(2) sur_end{a}(2)],'g')
    hold on
end

for a = 1:n_ray
    for b = 1:length(rays{a})
        r = rays{a}{b};
        
        plot([r.o(1) r.e(1)],[r.o(2) r.e(2)],'Color',DRAW.colors(b))
        hold on
    end
end

% axis([0 10 0 10])
axis equal