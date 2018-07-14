package com.lisq.wxserver.pub;

import java.util.UUID;

/**
 * 工具类
 * 
 * @author lisq
 * @date 2018年7月14日
 */
public class WxClientUtils  implements IWxserverConstance{
	public static <T> WxClientResultVO<T> getSuccessObj(String key,T data) {
		WxClientResultVO<T> resultv=new WxClientResultVO<T>();
		resultv.getData().put(key, data);
		return resultv;
	}
	
	public static WxClientResultVO getFailObj(String msg){
		WxClientResultVO resultVO = new WxClientResultVO();
		resultVO.setResult_code(WX_CLIENT_RESULT_FAIL);
		resultVO.setResult_msg(msg);
		return resultVO;
	}
	
	public static WxClientResultVO getFailObj(){
		WxClientResultVO resultVO = new WxClientResultVO();
		resultVO.setResult_code(WX_CLIENT_RESULT_FAIL);
		return resultVO;
	}
	
	public static <T> String getSuccessJson(T data){
		return WxjsonUtils.toJSONString(data);
	}
	public static String getFailjson(String msg) {
		return WxjsonUtils.toJSONString(getFailObj(msg));
	}
	
	public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString(); 
        String uuidStr=str.replace("-", "");
        return uuidStr;
    }
}
