package com.example.broadcast_test.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.broadcast_test.BootCompleteReceiver;
import com.example.broadcast_test.R;
import com.example.broadcast_test.config.BroadcastAction;
import com.example.broadcast_test.util.NetworkUtil;

public class MainActivity extends AppCompatActivity {
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;

    private Button button;

    private IntentFilter localIntentFilter;
    private LocalReceiver localReceiver;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initListener();
    }

    public void init() {
        /**
         * 创建一个动态注册的广播接收器包含3部分，第2部分是：注册想要收听的广播
         */
        // 两种初始化方式都可以，但是注释掉的这种存在 API级别 问题
//        intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        intentFilter = new IntentFilter();
        intentFilter.addAction(BroadcastAction.CONNECTIVITY_CHANGE);
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);

        button = findViewById(R.id.button);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);// 获取 LocalBroadcastManager类 的实例
        localIntentFilter = new IntentFilter();
        localIntentFilter.addAction(BroadcastAction.LOCAL_BROADCAST);
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver, localIntentFilter);// 注册本地广播接收器
    }

    public void initListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
//            public void onClick(View v) {
                /**
                 * 发送自定义广播（标准广播）
                 */
//                // 构建一个Intent对象，把要发送的广播值传入（还可以在Intent中携带一些数据传递给广播接收器）
//                Intent intent = new Intent(BroadcastAction.MY_BROADCAST);
//                // 调用Context类的 sendBroadcast(Intent intent) 方法将广播发送出去
//                sendBroadcast(intent);
//            }

//==================================================================================================

//            public void onClick(View v) {
                /**
                 * 发送自定义广播（有序广播）
                 */
//                Intent intent = new Intent(BroadcastAction.MY_BROADCAST);
//                sendOrderedBroadcast(intent, null);
//            }

//==================================================================================================

            public void onClick(View v) {
                /**
                 * 发送自定义广播（本地广播）
                 */
                Intent intent = new Intent(BroadcastAction.LOCAL_BROADCAST);
                localBroadcastManager.sendBroadcast(intent);// 发送本地广播
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * 创建一个动态注册的广播接收器包含3部分，第3部分是注销
         *
         * ！！！注意
         * 动态注册的广播接收器一定都要取消注册才行，
         * 这里通过在onDestroy()方法中调用unregisterReceiver(BroadcastReceiver receiver)方法来实现
         */
        unregisterReceiver(networkChangeReceiver);

        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    /**
     * 创建一个动态注册的广播接收器包含3部分，第1部分是收到广播以后的逻辑操作
     * <p>
     * 定义一个继承自 BroadcastReceiver类 的 内部类NetworkChangeReceiver，
     * 并重写BroadcastReceiver类的onReceive()方法
     */
    class NetworkChangeReceiver extends BroadcastReceiver {

        @Override
/*        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "network changes", Toast.LENGTH_SHORT).show();
        }*/

//==================================================================================================

/*        public void onReceive(Context context, Intent intent) {
            // 通过getSystemService()方法得到ConnectivityManager类（这是一个专门管理网络连接的系统服务类）的实例
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            // 然后再调用ConnectivityManager类中的getActiveNetworkInfo()方法得到NetworkInfo类的实例
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            // 调用NetworkInfo类中的isAvailable()方法判断当前是否有网络
            if (networkInfo != null && networkInfo.isAvailable()) {
                Toast.makeText(context, "network is available", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
            }
        }*/

//==================================================================================================

        /*        public void onReceive(Context context, Intent intent) {
         *//**
         * 使用State
         *//*
            NetworkInfo.State wifiState = null;
            NetworkInfo.State mobileState = null;

            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            wifiState = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
            mobileState = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
            if (wifiState != null && mobileState != null && NetworkInfo.State.CONNECTED != wifiState && NetworkInfo.State.CONNECTED == mobileState) {
                Toast.makeText(context, "流量连接成功", Toast.LENGTH_SHORT).show();
            } else if (wifiState != null && mobileState != null && NetworkInfo.State.CONNECTED == wifiState && NetworkInfo.State.CONNECTED != mobileState) {
                Toast.makeText(context, "wifi连接成功", Toast.LENGTH_SHORT).show();
            } else if (wifiState != null && mobileState != null && NetworkInfo.State.CONNECTED != wifiState && NetworkInfo.State.CONNECTED != mobileState) {
                Toast.makeText(context, "设备断网", Toast.LENGTH_SHORT).show();
            }
        }*/

//==================================================================================================

        public void onReceive(Context context, Intent intent) {
            /**
             * 使用NetworkUtil，需要import相关的工具包NetworkUtil
             */
            int networkStates = NetworkUtil.getNetworkStates(context);
            switch (networkStates) {
                case NetworkUtil.TYPE_NONE:
                    Toast.makeText(context, "设备断网", Toast.LENGTH_SHORT).show();
                    break;
                case NetworkUtil.TYPE_MOBILE:
                    Toast.makeText(context, "流量连接成功", Toast.LENGTH_SHORT).show();
                    break;
                case NetworkUtil.TYPE_WIFI:
                    Toast.makeText(context, "wifi连接成功", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 创建一个动态注册的本地广播接收器
     */
    class LocalReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "received local broadcast", Toast.LENGTH_SHORT).show();
        }
    }
}

