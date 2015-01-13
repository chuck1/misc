close all
clear all
clc

p=[1 0 0 0 0];

ducts=[...
    4 1;...
    1 2;...
    2 3;...
    3 4;...
    3 5];

joints={...
    [1 2];...
    [2 3];...
    [3 4];...
    [4 1];...
    5};

joint_s=[1 0 0 0 0];

joint_a = joints;

for a=1:size(joints,1)
    for b=1:size(joints{a},2)
        if a==ducts(joints{a}(b),1)
            joint_a{a}(b) = -1;
        else
            joint_a{a}(b) = 1;
        end
    end
end

mdot=[0 0 0 0 0];

C=[1 1 1 1 1];


for it=1:100
    
    
    for a=1:size(ducts,1)
        dp = C(a)*mdot(a)^2;
        if mdot(a)<0
            dp = -dp;
        end
        p_ = (p(ducts(a,1))+p(ducts(a,2)))/2;

        if size(joints{ducts(a,1)},2)==1
            p(ducts(a,2)) = p_ - dp;
        elseif size(joints{ducts(a,2)},2)==1
            p(ducts(a,1)) = p_ + dp;
        else
            p(ducts(a,1)) = p_ + dp/2;
            p(ducts(a,2)) = p_ - dp/2;
        end
        
        
        
            
    end

    for a=1:size(ducts,1)
        dp = p(ducts(a,1))-p(ducts(a,2));
        if dp >= 0
            mdot(a) = sqrt(dp/C(a));
        else
            mdot(a) = -sqrt(-dp/C(a));
        end
    end
    
    for a=1:size(joints,1)
        if size(joints{a},2)==1
            
        else
        
            mdot_accu = joint_s(a);
            for b=1:size(joints{a},2)
                mdot_accu = mdot_accu + mdot(joints{a}(b))*joint_a{a}(b);
            end
            for b=1:size(joints{a},2)
                mdot(joints{a}(b)) = mdot(joints{a}(b)) -...
                    mdot_accu/size(joints{a},2)*joint_a{a}(b);
            end
        
        end
    end
    
    mdot_iter(it,:) = mdot;
    p_iter(it,:) = p;
end

it=1:100;

scatter(it,mdot_iter(:,1))

figure();
scatter(it,p_iter(:,1))

% p(ducts(a,1))-p(ducts(a,2)) = C(a)*mdot(a)^2
% dp = C(a)*mdot(a)^2
