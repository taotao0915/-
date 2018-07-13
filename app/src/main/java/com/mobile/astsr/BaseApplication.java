package com.mobile.astsr;

import android.app.Application;
import android.util.Log;

import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

public class BaseApplication extends Application {
    PushAgent mPushAgent;
    @Override
    public void onCreate() {
        super.onCreate();
        mPushAgent = PushAgent.getInstance(this);
        //app对外正式发布，建议关闭日志输出
        mPushAgent.setDebugMode(true);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {
            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.i("TAG", "友盟推送的deviceToken:"+deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                Log.i("TAG",s+"--------------------"+s1);
            }
        });
    }
}
