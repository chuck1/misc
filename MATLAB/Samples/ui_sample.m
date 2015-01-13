function [out] = ui_sample(args)

h_fig = figure();

%create a uicontrol
h_ui = uicontrol('Style','pushbutton','Position',[0 0 30 30],'Callback',{@pushbutton_Callback args});

%wait for a Callback function to enter uiresume
uiwait

%get extra data from Callback function
out = get(h_ui,'UserData'); 

%close the figure
close(h_fig)

end

function pushbutton_Callback(hObject, eventdata, args)
	args = args + 1;
	
	%pass extra data back to main function
	set(hObject,'UserData',args)
	
	%allow main function to proceed past uiwait
	uiresume
end