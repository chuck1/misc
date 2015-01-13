close all
clear all
clc

[FileName,PathName,FilterIndex] = ...
    uigetfile({...
    '*.mat','MAT files (*.mat)';...
    },'Select data file');

if isempty(FileName) || (FileName(1) == 0)
    return
end

FileNameWOExt = regexp(FileName,'\w+(?=\.)','match','once');

load(FileNameWOExt)

if ~exist('txt','var')
    error([FileName ' does not contain variable txt'])
elseif ~exist('txt','var')
    error([FileName ' does not contain variable txt'])
elseif ~exist('txt','var')
    error([Filename ' does not contain variable txt'])
elseif ~exist('txt','var')
    error([FileName ' does not contain variable txt'])
elseif ~exist('txt','var')
    error([FileName ' does not contain variable txt'])
end

%% determine column numbers

TXT = txt(1,:);

REG = regexp(TXT,'.*Pressure.*','once');

pres_ind = 0;
for a=1:length(TXT)
    if ( ~isempty(REG{a}) )
        pres_ind = a-3;
    end
end
if pres_ind == 0
    error('pressure not found')
end

REG = regexp(TXT,'.*Area.*','once');

area_ind = 0;
for a=1:length(TXT)
    if ( ~isempty(REG{a}) )
        area_ind = a-3;
    end
end
if area_ind == 0
    error('Area not found')
end

REG = regexp(TXT,'.*Mass.*','once');

mass_ind = 0;
for a=1:length(TXT)
    if ( ~isempty(REG{a}) )
        mass_ind = a-3;
    end
end
if mass_ind == 0
    error('Mass not found')
end


%% compute awa pressure
AWA_pressure = zeros(size(X));
for a = 1:length(X)
    
    AWA_pressure(a) = sum( YAdd{a,pres_ind} .* YAdd{a,area_ind} ) /...
        sum( YAdd{a,area_ind} );
    
end

%% separate entrance/exit
x=Xmean(Zmean>0.005);

m1=Wsum(Zmean>0.005,mass_ind);
p1=Wmean(Zmean>0.005,pres_ind);
awap1=AWA_pressure(Zmean>0.005);


m2=Wsum(Zmean<0.005,mass_ind);
p2=Wmean(Zmean<0.005,pres_ind);
awap2=AWA_pressure(Zmean<0.005);

%% report

figure(1)
plot(x,abs(m1),'bo');hold on
plot(x,abs(m2),'ro')
xlabel('position (m)')
ylabel('mass flow (kg/s)')
legend('exit','entrance','Location','South')
formatplot('ZeroY',1)
print('-dpng','-r400','mass_flow')


figure(2)
plot(x,p1,'bo');hold on
plot(x,p2,'ro')
xlabel('position (m)')
ylabel('pressure (Pa)')
legend('exit','entrance','Location','NorthOutside')
formatplot('ZeroY',1)
print('-dpng','-r400','pressure')


%%
dp1 = range(p1);
dp2 = range(p2);
dp = abs(mean(p2-p1));

dev = abs((m1-mean(m1))/mean(m1));
fprintf('pressure ratio entrance: %f\n',dp/dp1)
fprintf('pressure ratio exit: %f\n',dp/dp2)
fprintf('average pressure drop through channel      : %f\n',dp)
fprintf('average pressure drop through channel (AWA): %f\n',mean(awap1-awap2))
fprintf('percent maximum deviation from mean: %.2f\n',max(dev)*100)