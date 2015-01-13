function [disset,setlen] = join_sets_containing_indicies(disset,setlen,ind)
%UNTITLED6 Summary of this function goes here
%   Detailed explanation goes here

sets_startind = [];
sets_len = [];
sets_setno = [];
sets_values = {};



for a=1:length(ind)
    [ startind,len,setno,values ] = find_set_containing_value( disset,setlen,ind(a) );
    
    if ~any(sets_startind==startind)
        sets_startind = cat( 1, sets_startind, startind );
        sets_len = cat( 1, sets_len, len );
        sets_setno = cat( 1, sets_setno, setno );
        sets_values = cat( 1, sets_values, values );
    end
    
end

%% remove joined sets from disset

sets_ind = (1:length(sets_setno))';

sets_setno_ind_to_rem = [sets_setno sets_ind];

sets_setno_ind_to_rem = sortrows( sets_setno_ind_to_rem, -1 );


for a=1:size(sets_setno_ind_to_rem,1)
    % sets_ index of set to remove
    b = sets_setno_ind_to_rem(a,2);
    
    startind = sets_startind(b);
    len = sets_len(b);
    setno = sets_setno(b);
    
    % remove
    disset( startind:(startind+len-1) ) = [];
    setlen( setno ) = [];
    
end

%% create new set

new_values = [sets_values{:}];
new_len = length(new_values);


%% append new set to disset

disset = cat(2,disset,new_values);
setlen = cat(2,setlen,new_len);



end

