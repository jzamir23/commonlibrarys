# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
#指定代码的压缩级别
-optimizationpasses 5
#包明不混合大小写
-dontusemixedcaseclassnames
#不去忽略非公共的库类
-dontskipnonpubliclibraryclasses
# 指定不去忽略非公共的库的类的成员
-dontskipnonpubliclibraryclassmembers
 #优化  不优化输入的类文件
-dontoptimize
 #预校验
-dontpreverify
 #混淆时是否记录日志
-verbose
 # 混淆时所采用的算法
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
#保护注解
-keepattributes *Annotation*
# 避免混淆泛型
# 这在JSON实体映射时非常重要，比如fastJson
-keepattributes Signature
# 抛出异常时保留代码行号
-keepattributes SourceFile,LineNumberTable
-keepattributes *JavascriptInterface*
 #优化时允许访问并修改有修饰符的类和类的成员，这可以提高优化步骤的结果。
# 比如，当内联一个公共的getter方法时，这也可能需要外地公共访问。
# 虽然java二进制规范不需要这个，要不然有的虚拟机处理这些代码会有问题。当有优化和使用-repackageclasses时才适用。
#指示语：不能用这个指令处理库中的代码，因为有的类和类成员没有设计成public ,而在api中可能变成public
-allowaccessmodification
#当有优化和使用-repackageclasses时才适用。
-repackageclasses ''
-keepclassmembers class com.github.lzyzsd.jsbridge.BridgeWebView {
    public *;
}
#不混淆资源类
-keepclassmembers class **.R$* {
    public static <fields>;
}
# 保留R下面的资源
-keep class **.R$* {*;}
#保持所有拥有本地方法的类名及本地方法名
-keepclasseswithmembernames class * {
     native <methods>;
}
#保持自定义View的get和set相关方法
-keepclassmembers public class * extends android.view.View {
void set*(***);
*** get*();
}
#保持Activity中View及其子类入参的方法
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}
# 保留枚举类不被混淆
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
#Parcelable
-keepclassmembers class * implements android.os.Parcelable {
   public static final android.os.Parcelable$Creator *;
}
# 保留Serializable序列化的类不被混淆
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    !private <fields>;
    !private <methods>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# 对于带有回调函数的onXXEvent、**On*Listener的，不能被混淆
-keepclassmembers class * {
    void *(**On*Event);
    void *(**On*Listener);
}

#表示不混淆任何一个View中的setXxx()和getXxx()方法，
#因为属性动画需要有相应的setter和getter的方法实现，混淆了就无法工作了。
-keep public class * extends android.view.View{
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keepclassmembers class fqcn.of.javascript.interface.for.Webview {
   public *;
}
-keepclassmembers class * extends android.webkit.WebViewClient {
    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
    public boolean *(android.webkit.WebView, java.lang.String);
}
-keepclassmembers class * extends android.webkit.WebViewClient {
    public void *(android.webkit.WebView, jav.lang.String);
}
#在app中与HTML5的JavaScript的交互进行特殊处理
#我们需要确保这些js要调用的原生方法不能够被混淆，于是我们需要做如下处理：
-keepclassmembers class com.github.lzyzsd.jsbridge.BridgeHandler {
    <methods>;
}
# 删除代码中Log相关的代码
-assumenosideeffects class android.util.Log {
    public static boolean isLoggable(java.lang.String, int);
    public static int v(...);
    public static int i(...);
    public static int w(...);
    public static int d(...);
    public static int e(...);
}
#AndroidX 和 support v7v4包
-dontwarn android.support.**
-keep class android.support.** { *; }
-keep interface android.support.** { *; }
-keep class com.google.android.material.** {*;}
-keep class androidx.** {*;}
-keep public class * extends androidx.**
-keep interface androidx.** {*;}
-dontwarn com.google.android.material.**
-dontnote com.google.android.material.**
-dontwarn androidx.**
-printconfiguration
-keep,allowobfuscation @interface androidx.annotation.Keep
  # 保持测试相关的代码
  -dontnote junit.framework.**
  -dontnote junit.runner.**
  -dontwarn android.test.**
  -dontwarn org.junit.**
# 保持哪些类不被混淆
-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.webkit.WebView
-keep public class * extends android.view.View
-keep public class * extends android.support.multidex.MultiDexApplication
-keep public class com.google.vending.licensing.ILicensingService
-keep public class com.android.vending.licensing.ILicensingService
-keep public class com.premierq.webinfo.WebViewActivity
-keep public class com.github.lzyzsd.jsbridge.BridgeWebView
-keep public class com.github.lzyzsd.jsbridge.BridgeWebViewClient
#忽略警告
-ignorewarnings
#####################记录生成的日志数据,gradle build时在本项目根目录输出################
#apk 包内所有 class 的内部结构
#-dump class_files.txt
#未混淆的类和成员
#-printseeds seeds.txt
#列出从 apk 中删除的代码
#-printusage unused.txt
#混淆前后的映射
#-printmapping mapping.txt
#####################记录生成的日志数据，gradle build时 在本项目根目录输出-end################
################<span></span>混淆保护自己项目的部分代码以及引用的第三方jar包library#########################
# google gson
-keep class org.json { *; }
-keep class com.google.gson.** { *; }
-keep class sun.misc.Unsafe { *; }
-keep class com.google.** { *;}
# OkHttp3
-dontwarn com.squareup.okhttp3.**
-keep class com.squareup.okhttp3.** { *;}
-keep interface com.squareup.okhttp3.** { *;}
-dontwarn okio.**
-keep class okio.**{*;}
-keep interface okio.**{*;}
# WebView
-dontwarn android.webkit.WebView
-dontwarn android.net.http.SslError
-dontwarn android.webkit.WebViewClient
-keep public class android.webkit.WebView
-keep public class android.net.http.SslError
-keep public class android.webkit.WebViewClient
#####################start-实体类相关-start######################
-keep class com.premierq.entity.** { *; }
-dontwarn android.databinding.**
-keep class android.databinding.** { *; }
#####################end-实体类相关-end######################
-dontwarn cn.jpush.**
-keep class cn.jpush.** { *; }
-dontwarn cn.jiguang.**
-keep class cn.jiguang.** { *; }
-keep class cn.jcore.client.android.** { *; }
-keep class cn.jpush.android.service.** { *; }
-dontwarn cn.com.chinatelecom.**
-keep class cn.com.chinatelecom.** { *; }
-dontwarn com.ct.**
-keep class com.ct.** { *; }
-dontwarn a.a.**
-keep class a.a.** { *; }
-dontwarn com.cmic.**
-keep class com.cmic.** { *; }
-dontwarn com.unicom.**
-keep class com.unicom.** { *; }
-dontwarn com.sdk.**
-keep class com.sdk.** { *; }
-keep class com.cmic.sso.sdk.** { *; }
-keep class com.unicom.xiaowo.login.** { *; }
-keep class cn.asus.push.** { *; }
-keep class cn.jiguang.push.asus.** { *; }
-keep class cn.jpush.android.** { *; }
-keep class cn.verification.client.android.** { *; }
-keep class cn.com.chinatelecom.account.** { *; }
-keep class cn.jiguang.verifysdk.** { *; }
-keep class com.bumptech.glide.annotation.** { *; }
-keep class com.bumptech.glide.gifdecoder.** { *; }
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
-keep class kotlin.** { *; }
-keep class kotlin.Metadata { *; }
-dontwarn kotlin.**
-keep class com.github.fernandodev.androidproperties.lib.** { *; }
-keep class net.lucode.hackware.magicindicator.** { *; }
-keep class com.google.android.material.** { *; }
-keep class com.google.android.play.core.** { *; }
-dontwarn  com.github.lzyzsd.**
-keep class com.github.lzyzsd.** { *; }
-keepclassmembers class * {
    @android.webkit.JavascriptInterface <methods>;
}
#不混淆所有类名中包含了“model”的类及其成员
-keep public class **.*model*.** {*;}
-keep class javax.annotation.** { *; }
-keep class com.gyf.immersionbar.** { *; }
-keep class com.zhy.view.flowlayout.** { *; }
-keep class com.jakewharton.rxbinding2.** { *; }
-keep class com.android.volley.** { *; }
-keep class com.qw.soul.** { *; }
-keep class com.scwang.smart.refresh.layout.** { *; }
-keep class com.sina.** { *; }
-keep class okhttp3.logging.** { *; }
-keep class retrofit2.adapter.rxjava2.** { *; }
-keep class retrofit2.converter.gson.** { *; }
-keep class retrofit2.** { *; }
-keep class com.squareup.javawriter.** { *; }
-keep class com.trello.rxlifecycle2.** { *; }
-keep class com.trello.rxlifecycle3.** { *; }
-keep class com.trello.rxlifecycle3.android.** { *; }
-keep class com.trello.rxlifecycle3.components.** { *; }
-keep class com.youth.banner.** { *; }
-keep class com.zhy.autolayout.** { *; }
-keep class io.reactivex.android.** { *; }
-keep class io.reactivex.** { *; }
-keep class javax.inject.** { *; }
-keep class org.kxml2.** { *; }
-keep class org.xmlpull.v1.** { *; }
-keep class android.net.** { *; }
-keep class com.android.internal.http.multipart.** { *; }
-keep class org.apache.** { *; }
-keep class org.hamcrest.** { *; }
-keep class org.java_websocket.** { *; }
-keep class org.intellij.lang.annotations.** { *; }
-keep class org.jetbrains.annotations.** { *; }
-keep class org.mockito.** { *; }
-keep class org.reactivestreams.** { *; }
-keep class com.github.wyang.klinechartlib.** { *; }
-keep class com.example.mp_kline_lib.** { *; }
-keep class com.github.mikephil.charting.** { *; }
-keep class com.sendtion.xrichtext.** { *; }
-keep class com.tencent.** { *; }
#友盟
-keep class com.umeng.** {*;}
#您如果使用了稳定性模块可以加入该混淆
-keep class com.uc.** {*;}
-keepclassmembers class * {
   public <init> (org.json.JSONObject);
}
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
-keep public class com.premierq.R$*{
public static final int *;
}
#**********start阿里监控依赖库混淆start**********
-keep class com.alibaba.ha.**{*;}
-keep class com.taobao.tlog.**{*;}
-keep class com.ut.device.**{*;}
-keep class com.ta.utdid2.device.**{*;}
-keep public class com.alibaba.mtl.** { *;}
-keep public class com.ut.mini.** { *;}
-keep class com.alibaba.motu.crashreporter.**{ *;}
-keep class com.uc.crashsdk.**{*;}
-keep class com.ali.telescope.**{ *;}
-keep class libcore.io.**{*;}
-keep class android.app.**{*;}
-keep class dalvik.system.**{*;}
-keep class com.taobao.tao.log.**{*;}
-keep class com.taobao.android.tlog.**{*;}
-keep class com.alibaba.motu.**{*;}
-keep class com.uc.crashsdk.**{*;}
-dontwarn com.taobao.orange.**
-dontwarn com.taobao.android.**
-dontwarn com.alibaba.ha.adapter.**
-dontwarn com.taobao.monitor.adapter.**
-dontwarn com.alibaba.fastjson.**
-dontwarn com.ali.alihadeviceevaluator.**
-dontwarn java.nio.file.**
-dontwarn org.codehaus.mojo.**
#**********end阿里监控依赖库混淆end**********

# ARouter
-keep public class com.alibaba.android.arouter.routes.**{*;}
-keep class * implements com.alibaba.android.arouter.facade.template.ISyringe{*;}
-keep interface * implements com.alibaba.android.arouter.facade.template.IProvider

############<span></span>混淆保护自己项目的部分代码以及引用的第三方jar包library-end##################