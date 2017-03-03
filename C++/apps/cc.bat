
cl /c /DWIN32 echoserver.cpp
link /out:echoserver.exe echoserver.obj ..\api\api.lib ws2_32.lib