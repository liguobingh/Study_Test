package com.example.broadcast_test.config;

/**
 * 配置应用中所有的广播（系统广播以及自定义广播）
 */
public class BroadcastAction {

    // 系统广播
    public static final String CONNECTIVITY_CHANGE = "android.net.conn.CONNECTIVITY_CHANGE";// 网络状态改变
    public static final String BOOT_COMPLETED = "    android.intent.action.BOOT_COMPLETED";// 开机启动完成后

    // 自定义广播
    public static final String LOCAL_BROADCAST = "com.example.broadcasttest.LOCAL_BROADCAST";// 强制下线
    public static final String MY_BROADCAST = "com.example.broadcasttest.MY_BROADCAST";// 做测试用

}
