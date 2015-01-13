function [] = co2_ees( verbose )

N = 7;
Pres = 120;

var_str = {'specific heat','conductivity','viscosity','density','enthalpy','specific heat','specific heat ratio'};
unt_str = {' [J/Kg-K]',' [W/m-K]',' [kg/m-s]',' [kg/m3]',' [J/Kg]',' [J/Kg-K]',''};
str = cell(N,1);
for i=1:N
    str{i} = [var_str{i} unt_str{i}];
end

filename = [num2str(Pres) '.txt'];

fileID = fopen(filename);
C = textscan(fileID, '%f %f %f %f %f %f %f %f %f');

T = C{2};
Y = cell(N,1);
for i=1:N
    Y{i} = C{i+2};
end

fclose(fileID);

poly = cell(N+1,1);
for i=1:N
    poly{i} = polyfit(T,Y{i},N);
end
poly{N+1} = polyfit(Y{5},T,N);

T(1)
T(end)
n = length(T);
if verbose
    for i=1:N
        figure(i)
        scatter(T(1:10:n),Y{i}(1:10:n),'o')
        hold on
        hLine = plot(T,polyval(poly{i},T),'b-');
        xlabel('T (K)')
        ylabel(str{i})
        set(get(get(hLine,'Annotation'),'LegendInformation'),'IconDisplayStyle','off');
        axis([T(1) T(end) 0 max(Y{i})])
    end

    for i=1:N
        fprintf([str{i} '\n'])

        for k=1:N
        fprintf('%i\t\t\t\t',N-k+2)
        end

        fprintf('\n')

        for k=1:N
        fprintf('%e\t',poly{i}(k))
        end

        fprintf('\n\n')
    end

    for i=1:N
        figure(i)
        print('-djpeg',[var_str{i} '.jpeg'])
    end
end

save('co2_coeff','poly')