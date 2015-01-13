close all
clear all
clc



D   = [...
    1e-3...
    500e-6];

P_T = [...
    1.4...
    1.4];

f = [...
    0.3192...
    0.345];





fprintf('half H, half S_T, two S_L:\n')
fprintf('D\t\tf\t\t\tmass flow rate\t\tpressure drop\tRe\t\tNu\n')

mdot    = zeros(1,length(D));
dp_cell = zeros(1,length(D));
eta     = zeros(1,length(D));
Re      = zeros(1,length(D));

for a=1:length(D)
    [ mdot(a),dp_cell(a),eta(a),Re(a),Nu(a),T(a),v_max(a) ] =...
        unit_cell_design_func( D(a),P_T(a),f(a) );
    fprintf('%0.1e\t%.3f\t\t%e\t\t%e\t%.0f\t%.0f\n',D(a),f(a),mdot(a),dp_cell(a),Re(a),Nu(a))
end

loglog(Re,f,'o')
axis([1e4 1e5 1e-1 1e0])