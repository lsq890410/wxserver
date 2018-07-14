package com.lisq.wxserver.pub;

import com.alibaba.fastjson.JSON;

/**
 * Json序列化、反序列化工具
 * @author chenwh
 * @data 2014-11-10
 *
 */
public class WxjsonUtils implements IWxserverConstance{
	/**
	 * 将obj对象转换为json串
	 * 
	 * @param obj
	 * @return
	 */
	public static String toJSONString(Object obj) {
		return JSON.toJSONString(obj);
	}
	
	/**
	 * json数组转对象
	 * 
	 * @param <T>
	 * @param jn
	 * @param valueType
	 * @return
	 */
	public static <T> T toJavaObject(Object jObject, Class<T> valueType) {
		return toJavaObject(toJSONString(jObject), valueType);
	}
	
	public static <T> T toJavaObject(String json, Class<T> valueType) {
		T parseObject = JSON.parseObject(json, valueType);
		return parseObject;
	}
}
