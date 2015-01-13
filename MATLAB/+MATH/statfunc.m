function s = statfunc(s,y)
statfunc ={'mean' 'std' 'min' 'max'};
for a = 1:length(statfunc)
    func = str2func(['@' statfunc{a}]);
    s.(statfunc{a}) = func(y);
end