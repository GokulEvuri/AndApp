%% Author Gokul S Evuri (gokul@evuri.com)
%% Server to handle database requests.
%% ToDo(Priority level 1):
%%  Basic servel loop structure [Done]
%%  Create methods to handel the protocols [in progress]
%% 
%% ToDo(Priority level 2)
%%  Adapt OTP behaviour 

-module(db_server).

-compile(export_all).

start()->
    init(),
    register(db_server,spawn(?MODULE,loop,[])).

stop()->
    db_server ! {stop,user}.

init()->
    ok.

loop()->
    receive
	{stop,user} ->
	    ok;
	_ ->
	    loop()
    end.
