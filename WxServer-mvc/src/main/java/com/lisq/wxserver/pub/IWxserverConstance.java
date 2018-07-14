package com.lisq.wxserver.pub;
/**
 * 常量类
 * 
 * @author lisq
 * @date 2018年7月14日
 */
public interface IWxserverConstance {
	public static String __S_APPID = "appid";//appid
	public static String __S_APPSECRET = "appsecret";//appsecret
	public static String __S_SKEY = "skey";//skey
	
	public static int WX_CLIENT_RESULT_SUCCESS = 0;//成功
	public static int WX_CLIENT_RESULT_FAIL = 1;//失败
	public static String WX_CLIENT_RESULT_SUCCESS_DEFAUTLMSG = "请求成功";
	public static String WX_CLIENT_RESULT_FAIL_DEFAULTMSG = "请求失败";
}
