function myprint(fmt_str,ext_str,filler_str,strings)
m = length(filler_str);
n = length(fmt_str);
file_str = cell(1,n);
for a = 1:n
    file_str{a} = filler_str{1};
    for b = 2:m
        file_str{a} = [file_str{a} strings{b-1}{a} filler_str{b}];
    end
    file_str{a} = [file_str{a} ext_str{a}];
    
    % print
    print(['-d' fmt_str{a}],file_str{a})
end
