%% Author Gokul S Evuri (gokul@evuri.com)
-module(myappmod).

-compile(export_all).

-include("/usr/local/lib/yaws/include/yaws_api.hrl").

out(A) ->
        {ehtml,
     [{p,[],
       box(io_lib:format("A#arg.appmoddata = ~p~n"
                         "A#arg.appmod_prepath = ~p~n"
                         "A#arg.querydata = ~p~n",
                         [A#arg.appmoddata,
                          A#arg.appmod_prepath,
                          A#arg.querydata]))}]}.
