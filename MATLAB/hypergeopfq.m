%HYPERGEOPFQ Hypergeometric Function Approximation
%   HYPERGEOPFQ(P,Q,z,n) Returns the sum of the first n terms of the
%   hypergeometric function for the form
%                            p1*p2*... z    (p1+1)*(p2+1)*...  z^2
%   hypergeopfq(P,Q,z,n)=1 + --------- -- + ------------------ --- + ...
%                            q1*q2*... 1!   (q1+1)*(q2+1)*...  2!
%   where P=[p1 p2 ...]
%         Q=[q1 q2 ...]
%   and z is a columnwise vector
function [F] = hypergeopfq(P,Q,z,n)
D=zeros([n size(z)]);
D(:,:,:,1)=ones([size(z) 1]);
for m=2:n
    D(m,:,:,:)=D(m-1,:,:,:).*(prod(P+m-2)*ones(size(z)))./(prod(Q+m-2)*ones(size(z)))/(m-1).*z;
end
F=sum(D,1);