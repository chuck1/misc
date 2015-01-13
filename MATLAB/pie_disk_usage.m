function pie_disk_usage(folder)

subfolders = folder{4};

bytes = zeros(1,length(subfolders));
name{length(subfolders)} = {};

for a = 1:length(subfolders)
    bytes(a) = subfolders{a}{3};
    name{a} = subfolders{a}{1};
end

pie(bytes,name)