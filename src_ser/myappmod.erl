%% Author Gokul S Evuri (gokul@evuri.com)
-module(myappmod).

-compile(export_all).

-include("/usr/local/lib/yaws/include/yaws_api.hrl").

box(Str) ->
    {'div',[{class,"box"}],
     {pre,[],Str}}.


out(A) ->
        {ehtml,
     [{p,[],"Hello"}]}.
