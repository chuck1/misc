close all;clear all;clc

%% choose file

[FileName,PathName,FilterIndex] = ...
    uigetfile({...
    '*.csv','Comma Seperated Files (*.csv)';...
    '*.txt','Text Files (*.txt)'...
    },'Select data file');

if isempty(FileName)
    return
end

FileNameWOExt = regexp(FileName,'\w+(?=\.)','match','once');

selectionPath = sprintf('%s%s_selection',PathName,FileNameWOExt);



%% choose quantities

switch FilterIndex
    case 1 % csv
        [num,txt,raw] = xlsread([PathName FileName]);
        txt = txt(1,:);
        try load(selectionPath,'xIndex','yIndex','zIndex','yAddIndex')
            % Construct a questdlg with three options
            choice = questdlg(['Use existing selection in ' FileNameWOExt '_selection.mat?'], ...
                'Selection', ...
                'Yes','No','Yes');
            % Handle response
            switch choice
                case 'Yes'
                    shouldGetSeletion = 0;
                case 'No'
                    shouldGetSeletion = 1;
            end
        catch err
            shouldGetSeletion = 1;
        end
        
        if shouldGetSeletion
            clear('xIndex','yIndex','zIndex','yAddIndex')
            
            [Selection,ok] = listdlg('PromptString','Select x quantity:',...
                'SelectionMode','single',...
                'ListString',txt(1,:));

            if (~ok)
                return
            end

            xIndex = Selection;

            [Selection,ok] = listdlg('PromptString','Select y quantity:',...
                'SelectionMode','single',...
                'ListString',txt(1,:));

            if (~ok)
                return
            end
            yIndex = Selection;
            
            [Selection,ok] = listdlg('PromptString','Select z quantity:',...
                'SelectionMode','single',...
                'ListString',txt(1,:));

            if (~ok)
                return
            end
            zIndex = Selection;
            
            [Selection,ok] = listdlg('PromptString','Select additional y quantity:',...
                'SelectionMode','multiple',...
                'ListString',txt(1,:));

            if (~ok)
                return
            end

            yAddIndex = Selection;
            
            save(selectionPath,'xIndex','yIndex','zIndex','yAddIndex')
        end
        
        
        x = num(:,xIndex);
        y = num(:,yIndex);
        z = num(:,zIndex);
        yAdd = num(:,yAddIndex);
        
        nbyAdd = length(yAddIndex);
        
    case 2 % txt
        return
end

a = 1;
while a < size(x,1);
    if any(isnan(x(a,:)))
        x(a,:) = [];
    else
        a = a + 1;
    end
end



%% position selection

positionFile = sprintf('%s_position_%i_%i_%i',...
    FileNameWOExt,xIndex,yIndex,zIndex);

positionPath = [PathName positionFile];

try load(positionPath,'position1','position2')
    % Construct a questdlg with three options
    choice = questdlg(['Use existing position data in ' positionFile '.mat?'], ...
        'Position Data', ...
        'Yes','No','Yes');
    % Handle response
    switch choice
        case 'Yes'
            shouldGetPosition = 0;
        case 'No'
            shouldGetPosition = 1;
    end
catch err
    shouldGetPosition = 1;
end

if shouldGetPosition
    clear position1 position2
    %% xy position selection
    choice = questdlg('Use automatric x positioning?', ...
        'Position', ...
        'Yes','No','Yes');
    % Handle response
    switch choice
        case 'Yes'
            
            prompt = {'Enter starting position (mm):','Enter offset (mm):',...
                'Enter number of channels:'};
            dlg_title = 'Input for peaks function';
            num_lines = 1;
            def = {'-0.1','0','0'};
            answer = inputdlg(prompt,dlg_title,num_lines,def);
            
            startx = str2double(answer(1))/1000;
            offsetx = str2double(answer(2))/1000;
            
            for a=1:(str2double(answer(3)))
                position1{a}=[startx + (a-1)*offsetx -1 offsetx 2]; %#ok<SAGROW>
            end
            
        case 'No'
            hf=figure();

            skip = floor(length(x)/1000);

            temp_ind = 1:skip:length(x);

            xtemp = x(temp_ind);
            ytemp = y(temp_ind);
            scatter(xtemp,ytemp)

        %     xlimit = [min(xtemp) max(xtemp)];
        %     ylimit = [min(ytemp) max(ytemp)];
        %     xrange = xlimit(2)-xlimit(1);
        %     yrange = ylimit(2)-ylimit(1);
        %     xlimit = xlimit + [-1 1]*xrange*0.01;
        %     ylimit = ylimit + [-1 1]*yrange*0.01;
        %     axis([xlimit ylimit])

            h=imrect;
            pos = wait(h);
            a=0;
            while ~isempty(pos)
                a=a+1;
                position1{a} = pos; %#ok<SAGROW>
                h=imrect;
                pos = wait(h);
            end

            close(hf)
    end
    
    
    
    
    %% xz position selection
    
    hf=figure();
%     temp_ind = 1:10:length(x);
%     scatter(x(temp_ind),y(temp_ind))
    scatter(x,z)
    xlimit = get(gca,'XLim');
    ylimit = get(gca,'YLim');
    xrange = xlimit(2)-xlimit(1);
    yrange = ylimit(2)-ylimit(1);
    xlimit = xlimit + [-1 1]*xrange*0.1;
    ylimit = ylimit + [-1 1]*yrange*0.1;
    set(gca,'XLim',xlimit)
    set(gca,'YLim',ylimit)
    
    h=imrect;
    pos = wait(h);
    a=0;
    while ~isempty(pos)
        a=a+1;
        position2{a} = pos; %#ok<SAGROW>
        h=imrect;
        pos = wait(h);
    end
    
    close(hf)
    
    %% save position selections
    
    save(positionPath,'position1','position2')
    
end

%% process positions
nbBlocks = length(position1)*length(position2);

blockPos = cell(nbBlocks,1);
blockRec = cell(nbBlocks,1);

c = 0;
for a = 1:length(position1)
    for b = 1:length(position2)
        c = c + 1;
    
        blockPos{c}(1) = position1{a}(1);
        blockPos{c}(2) = position1{a}(1)+position1{a}(3);
        
        blockRec{c}(1) = position1{a}(1);
        blockRec{c}(2) = position1{a}(3);
        
        blockPos{c}(3) = position1{a}(2);
        blockPos{c}(4) = position1{a}(2)+position1{a}(4);
        
        blockRec{c}(3) = position1{a}(2);
        blockRec{c}(4) = position1{a}(4);
        
        blockPos{c}(5) = position2{b}(2);
        blockPos{c}(6) = position2{b}(2)+position2{b}(4);
        
        blockRec{c}(5) = position2{b}(2);
        blockRec{c}(6) = position2{b}(4);
        
    end
end

%% seperate blocks


X = cell(nbBlocks,1);
Y = cell(nbBlocks,1);
Z = cell(nbBlocks,1);
YAdd = cell(nbBlocks,nbyAdd);
YCalc = cell(length(position1),1);

xstack = x;
ystack = y;
zstack = z;
wstack = yAdd;

for c = 1:nbBlocks
    xind = 1:size(xstack,1);
    yind = 1:size(ystack,1);
    zind = 1:size(zstack,1);
    
    xind = xind( ( xstack>blockPos{c}(1) ) & ( xstack<blockPos{c}(2) ) );
    yind = yind( ( ystack>blockPos{c}(3) ) & ( ystack<blockPos{c}(4) ) );
    zind = zind( ( zstack>blockPos{c}(5) ) & ( zstack<blockPos{c}(6) ) );

    ind = intersect(xind,yind);
    ind = intersect(ind,zind);
    
    X{c} = xstack(ind);
    Y{c} = ystack(ind);
    Z{c} = zstack(ind);

    for d = 1:nbyAdd
        YAdd{c,d} = wstack(ind,d);
    end

    % remove used datapoints from stack
    xstack(ind)=[];
    ystack(ind)=[];
    zstack(ind)=[];
    wstack(ind,:)=[];

end

%% calculate statistics

Xmean = zeros(nbBlocks,1);
Ymean = zeros(nbBlocks,1);
Zmean = zeros(nbBlocks,1);
Wmean = zeros(nbBlocks,nbyAdd);
Wsum =  zeros(nbBlocks,nbyAdd);
Wabsmean = zeros(nbBlocks,nbyAdd);
Wabssum = zeros(nbBlocks,nbyAdd);
for a=1:nbBlocks
    Xmean(a) = mean(X{a});
    Ymean(a) = mean(Y{a});
    Zmean(a) = mean(Z{a});
    for b=1:nbyAdd
        Wmean(a,b) = mean(YAdd{a,b},1);
        Wsum(a,b) = sum(YAdd{a,b},1);
        Wabsmean(a,b) = mean(abs(YAdd{a,b}),1);
        Wabssum(a,b) = sum(abs(YAdd{a,b}),1);
    end
end

%% save

save([FileNameWOExt '_data'],'X','Y','Z','YAdd',...
    'Xmean','Ymean','Zmean','Wmean','Wsum','txt')

%% plot
% figure()
% scatter(Xmean,YCalcSum(:,1))
figure()
for a=1:length(X)
    plot(X{a},Z{a},'Marker',DRAW.markers(a),'Color',DRAW.colors(a));hold on
end
for a=1:length(blockPos)
    rectangle('Position',blockRec{a}([1 5 2 6]))
end

