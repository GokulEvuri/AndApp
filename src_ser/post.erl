-module(post).
-compile(export_all).

-include("/usr/local/lib/yaws/include/yaws_api.hrl").

%% Query on client browser http://192.168.1.4/req?latitude=2.0&longitude=7.1

%% todo Prototype 1
%% Get lat and long, return a parent JSON object with 5 child JSON objects [Done]
%% JSON object model
%%     -> Price
%%     -> Distance
%%     -> StoreName
%%     -> Adress
%%     -> Phone Number
    
out(A)->

    AppModData = A#arg.appmoddata,
    PrePath = A#arg.appmod_prepath,
    QueryData = A#arg.querydata,
    {Latitude,Longitude} = get_position(QueryData),
    case is_float(Latitude) of
	true ->
	    io:format("~n~p~n ~p~n ~p~n",[Latitude,Longitude,QueryData]);
	false-> 
	    io:format("Oh crap"),
	    io:format("~p~n ~p~n ~p~n",[Latitude,Longitude,QueryData])
	end,
    {html, json2:encode(construct_JSON())}.



get_position(QueryData)->
    {Tail, Latitude} = get_latitude(QueryData),
    {list_to_float(Latitude) , list_to_float(get_longitude(Tail))}.

get_latitude([108,97,116,105,116,117,100,101,61|Tail])->
    {Tail,get_latitude(Tail,[])}.

get_latitude([38|_Tail],List)->
    lists:reverse(List);
get_latitude([Num|Tail],List) ->
    get_latitude(Tail,[Num|List]).

get_longitude([61|Tail]) ->
    get_longitude(Tail,[]);
get_longitude([38|Tail]) ->
    get_longitude(Tail);
get_longitude([_|Tail]) ->
    get_longitude(Tail).

get_longitude([],List)->
    lists:reverse(List);
get_longitude([Num|Tail],List) ->
    get_longitude(Tail,[Num|List]).

construct_JSON()->
    
    Address1 = [{<<"StreetAddress">>, <<"21 2nd Street">>}, {<<"City">>, <<"New York">>},{<<"State">>, <<"NY">>},{<<"PostalCode">>, <<"10021">> }],
    Item1 = {struct, [{"ItemName","Estella Potato Chips"},{"price", "23.89"},{<<"Distance">>, <<"6.00">>},{<<"StoreName">>, <<"23.89">>}, {<<"Address">>, {struct, Address1}} ] },
    Address2 = [{<<"StreetAddress">>, <<"21 2nd Street">>}, {<<"City">>, <<"New York">>},{<<"State">>, <<"NY">>},{<<"PostalCode">>, <<"10021">> }],
    Item2 = {struct, [{"ItemName", "OLW Chips"},{<<"Price">>, <<"23.89">>},{<<"Distance">>, <<"6.00">>},{<<"StoreName">>, <<"23.89">>}, {<<"Address">>,{struct, Address2}} ]},
     
    {array,[Item1,Item2]}.
