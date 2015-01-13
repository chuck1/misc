function [ x ] = possible_offset_stencil( a,b,n,X )
%UNTITLED6 Summary of this function goes here
%   Detailed explanation goes here
    a_span = [-1 +1];
    b_span = [-1 +1];


    if a==1
        a_span(1) = 0;
    end
    if a==n
        a_span(2) = 0;
    end
    
    if b==1
        b_span(1) = 0;
    end
    if b==n
        b_span(2) = 0;
    end

    a_span = a_span+a;
    b_span = b_span+b;

    
    x = X(a_span(1):a_span(2),b_span(1):b_span(2));




%     a_stencil=[...
%         -1,0,1;...
%         -1,0,1;...
%         -1,0,1];
%     
%     b_stencil=[...
%         1 1 1;...
%         0 0 0;...
%         -1 -1 -1];
%     
%     A = a_stencil + a;
%     B = b_stencil + b;
%     
%     if a==1
%         A(:,1)=[];
%         B(:,1)=[];
%     end
%     if a==n
%         A(:,3)=[];
%         B(:,3)=[];
%     end
%     if b==1
%         A(3,:)=[];
%         B(3,:)=[];
%     end
%     if b==n
%         A(1,:)=[];
%         B(1,:)=[];
%     end
    
end

