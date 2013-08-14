%% Author Gokul S Evuri (gokul@evuri.com)
%% Module to support user services

%% ToDo (Priority level 1)
%% Function to chek data format
%% Handle user query function

-module(user_service).

-compile(export_all).

%% returns true boolean when data format is right otherwise else
check_dataFormat({{Latitude,Longitude},ItemName})->
    true;

check_dataFormat({Location,ItemName})->
    true;

check_dataFormat(_) ->
    false.

handle_userQuery({_Pid,Data})->
    case check_dataFormat(Data) of
	true ->
	    ok;
	false ->
	    ok
    end.
