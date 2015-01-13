function [ Nu ] = MH1955( a )
%MH1955 Nusselt number for H1 boundary condition heat transfer through
%all walls
%   Detailed explanation goes here

a = min(a,1./a);

Nu = 8.235*(1 - 2.0421*a + 3.0853*a.^2 - 2.4765*a.^3 + 1.0578*a.^4 -...
    0.1861*a.^5);

end

