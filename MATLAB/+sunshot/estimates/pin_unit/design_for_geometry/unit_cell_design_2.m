close all
clear all
clc
%   D           P_T         f           N_L
vars = [...
    100e-6      1.5         0.45        33;...
    200e-6      1.5         0.45        33;...
    300e-6      1.5         0.45        33;...
    300e-6      1.3         0.45        13;...
    500e-6      1.5         0.35        33];


D =   vars(:,1);
P_T = vars(:,2);
f =   vars(:,3);
N_L = vars(:,4);

fprintf('half H, half S_T, two S_L:\n')
fprintf('D\t\tf\t\t\tmass flow rate\t\tpressure drop\tRe\t\tNu\n')

mdot    = zeros(1,length(D));
dp_cell = zeros(1,length(D));
eta     = zeros(1,length(D));
Re      = zeros(1,length(D));

for a=1:length(D)
    [ mdot(a),dp_cell(a),eta(a),Re(a),Nu(a),T(a),v_max(a),L(a),N_L(a),v(a),A_hs(a) ] =...
        unit_cell_design_func( D(a),P_T(a),f(a),N_L(a) );
    fprintf('%0.1e\t%.3f\t\t%e\t\t%e\t%.0f\t%.0f\n',D(a),f(a),mdot(a),dp_cell(a),Re(a),Nu(a))
end
