import sys

f = open('/nfs/mohr/sva/work/rymalc/bin/experiments/exp0002/case_1/profile','r')

for line in f:
	m = re.split(

fid = fopen(filename);

%M = fread(fid, 5, 'uint8=>char');

M = fgetl(fid);

X = regexp(M,'\s*,\s*','split');

Y = [];

M = fgetl(fid);
while ischar(M)
    
    
    X = regexp(M,'\s*,\s*','split');
    
    y = zeros(size(X));
    for a=1:length(X)
        y(a) = str2double(X{a});
    end
    
    Y = cat(1,Y,y);
    
    %fprintf('%s\n',M)
    
    
    M = fgetl(fid);
end





