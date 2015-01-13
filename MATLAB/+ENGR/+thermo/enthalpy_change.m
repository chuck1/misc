function [ DH ] = enthalpy_change( varargin )
%UNTITLED3 Summary of this function goes here
%   Detailed explanation goes here
[ SZ, varargin ] = checkelementwisecompatible( varargin );

T1 = varargin{1};
T2 = varargin{2};
flu = varargin{3};

DH = zeros(SZ);

assert(isequal(size(flu),[1 1]),'Only one fluid!')
assert(isa(flu,'sunshot.material.fluid'),'Invalid fluid!')

for a=1:prod(SZ)
    
    T = linspace(T1(a),T2(a),1000);
    cp = flu.Get('specific_heat',1,T);
    DH(a) = trapz(T,cp);
    
end


end


