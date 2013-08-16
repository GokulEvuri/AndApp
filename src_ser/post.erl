-module(post).
-compile(export_all).

-include("/usr/local/lib/yaws/include/yaws_api.hrl").

%% todo Prototype 1
%% Get lat and long, return a parent JSON object with 5 child JSON objects
%% JSON object model
%%     -> Price
%%     -> Distance
%%     -> StoreName
%%     -> Adress
%%     -> Phone Number
    
out(A)->
%%     List = yaws_api:parse_post(A), 
%%     Latitude = proplists:get_value("latitude",List,"undefined"),   
%%     Longitude = proplists:get_value("longitude",List,"undefined"),   
   %% Item = proplists:get_value("item",List,"undefined"),
    AppModData = A#arg.appmoddata,
    PrePath = A#arg.appmod_prepath,
    QueryData = A#arg.querydata,
    {Latitude,Longitude} = get_position(QueryData),
    case is_float(Latitude) of
	true ->
	    io:format("~p~n ~p~n ~p~n",[Latitude,Longitude,QueryData]);
	false-> 
	    io:format("Oh crap")
	end,
    {html, json:encode(construct_JSON())}.

construct_JSON()->
	Address1 = [{<<"StreetAddress">>, <<"21 2nd Street">>}, {<<"City">>, <<"New York">>},{<<"State">>, <<"NY">>},{<<"PostalCode">>, <<"10021">> }],
	
    	Item1 = {struct, [{"price", "23.89"},{<<"Distance">>, <<"6.00">>},{<<"StoreName">>, <<"23.89">>}, {<<"Address">>, {struct, Address1}} ] }, 

   	Address2 = [{<<"StreetAddress">>, <<"21 2nd Street">>}, {<<"City">>, <<"New York">>},{<<"State">>, <<"NY">>},{<<"PostalCode">>, <<"10021">> }],

    	Item2 = {struct, [{<<"Price">>, <<"23.89">>},{<<"Distance">>, <<"6.00">>},{<<"StoreName">>, <<"23.89">>}, {<<"Address">>,{struct, Address2}} ]}, 

 	{struct,[{"items",Item1},{"items",Item2}]}.


get_position(QueryData)->
    {get_latitude(QueryData),get_longitude(QueryData)}.


get_latitude(_)->
    0.0.
get_longitude(_) ->
    0.0.
