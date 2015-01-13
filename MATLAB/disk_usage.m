function folder = disk_usage

listing = dir;

name = {listing(:).name};
bytes = [listing(:).bytes];
isdir = [listing(:).isdir];

subfolder_name = name(isdir & ~strcmp('.',name) & ~strcmp('..',name));

file_bytes = sum(bytes);

total_bytes = file_bytes;

subfolders = cell(1,length(subfolder_name));

for a = 1:length(subfolder_name)

	subfolders{a} = func1(subfolder_name{a});
	
	total_bytes = total_bytes+subfolders{a}{3};

end

folder = {'' file_bytes total_bytes subfolders};

end

function folder = func1(this_folder_name)

cd(this_folder_name)

listing = dir;

name = {listing(:).name};
bytes = [listing(:).bytes];
isdir = [listing(:).isdir];

subfolder_name = name(isdir & ~strcmp('.',name) & ~strcmp('..',name));

file_bytes = sum(bytes);

total_bytes = file_bytes;

subfolders = cell(1,length(subfolder_name));

for a = 1:length(subfolder_name)

	subfolders{a} = func1(subfolder_name{a});
	
	total_bytes = total_bytes+subfolders{a}{3};

end

folder = {this_folder_name file_bytes total_bytes subfolders};

cd ..\

end