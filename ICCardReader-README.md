##TestJavaUSBCardReader.jar
是Java读卡器的驱动调用接口

##function.dll JNative.jar JNativeCpp.dll USB.dll
是 TestJavaUSBCardReader.jar 所依赖的动态函数库 
需要放置在主程序同一目录
tomcat的话就放在tomcat的bin
图片的java项目就放置在src下面
否则在加载function.dll的时候会报nullPointerException,因为加载不到动态函数库
