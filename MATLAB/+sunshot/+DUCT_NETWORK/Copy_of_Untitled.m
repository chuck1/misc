close all
clear all
clc

mu = 37.6E-6;
rho = 91.28;

p=[0 0 0 0 0 1 0 0 0];

% ducts=[...
%     4 1;...
%     1 2;...
%     2 3;...
%     3 4;...
%     3 5];

joints={...
    [2 4 6]...
    [1 9]...
    [5 7 8 9]...
    [1 7 8]...
    3 ...
    1 ...
    [3 4]...
    [3 4]...
    [2 3]};

beta = 1.8;

C=ones(length(p));
C(1,2) = 4;

C(2,9) = 10;
C(3,7) = 10;
C(3,8) = 10;
C(3,9) = 10;
C(4,7) = 10;
C(4,8) = 10;

for a=1:length(p)
    for b=a:length(p)
        C(b,a)=C(a,b);
    end
end


p_hist(1,:) = p;
r_hist(1,:) = zeros(1,length(p));

for it=2:1000
    
    for a=1:length(joints)
        if length(joints{a})>1
            a_p=0;
            P=0;
            for b=1:length(joints{a})
                nbr = joints{a}(b);
                
                if abs(p(a)-p(nbr))>0
                
                    
                    a_nbr = 1/sqrt(C(a,nbr)*abs(p(a)-p(nbr)));
                    a_p = a_p + a_nbr;
                    P = P + p(nbr)*a_nbr;
                
                end
            end
            if a_p>0
                p(a) = (1-beta)*p(a) + beta*P/a_p;
            end
        end
    end
    
    p_hist(it,:) = p;
    
    r = abs((p_hist(it-1,:)-p_hist(it,:))./p_hist(it-1,:));
    r_hist(it,:) = r;
    
    r(isnan(r)) = 0;
    if max(r)<0.001
        break
    end
    
end

mdot = joints;
for a=1:length(joints)
    for b=1:length(joints{a})
        nbr = joints{a}(b);
        dp = p(a)-p(nbr);
        mdot{a}(b) = dp/sqrt(C(a,nbr)*abs(dp));
    end
end


format={...
    'bo'...
    'ro'...
    'go'...
    'mo'...
    'bs'...
    'rs'...
    'gs'...
    'ms'...
    'bd'...
    'rd'...
    'gd'...
    'md'};



% figure(1);hold on
% for a=1:length(p)
%     plot(p_hist(:,a),format{a})
%     leg{a}=sprintf('%i',a);
% end
% 
% legend(leg)
% 
% figure(2)
% for a=1:length(p)
%     semilogy(r_hist(:,a),format{a});hold on
% end
% 
% legend(leg)
