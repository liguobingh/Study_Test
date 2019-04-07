package com.example.broadcast_test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        /**
         * 创建一个动态注册的广播接收器包含3部分，第2部分是：注册想要收听的广播
         */
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");

        networkChangeReceiver = new NetworkChangeReceiver();

        registerReceiver(networkChangeReceiver, intentFilter);
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
//        unregisterReceiver(networkChangeReceiver);
    }

    /**
     * 创建一个动态注册的广播接收器包含3部分，第1部分是收到广播以后的逻辑操作
     *
     * 定义一个继承自 BroadcastReceiver类 的 内部类NetworkChangeReceiver，
     * 并重写BroadcastReceiver类的onReceive()方法
     */
    class NetworkChangeReceiver extends BroadcastReceiver {

        @Override
/*        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "network changes", Toast.LENGTH_SHORT).show();
        }*/

        public void onReceive(Context context, Intent intent) {
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
        }
    }
}
