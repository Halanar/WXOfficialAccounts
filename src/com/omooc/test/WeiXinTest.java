package com.omooc.test;

import java.io.IOException;

import com.imooc.po.AccessToken;
import com.imooc.util.WeixinUtil;

import net.sf.json.JSONObject;

public class WeiXinTest {
	public static void main(String[] args) {
		//System.out.println("==============================");
		try {
		AccessToken token = WeixinUtil.getAccessToken();
		System.out.println("票据：" + token.getToken());
		System.out.println("有效时间：" + token.getExpiresIn());
		
//		String path = "D:/imooc.jpg";
//		String mediaId = WeixinUtil.upload(path, token.getToken(), "thumb");
		//System.out.println(mediaId);
		
		String menu = JSONObject.fromObject(WeixinUtil.initMenu()).toString();
		int result = WeixinUtil.createMenu(token.getToken(), menu);
		if(result == 0) {
			System.out.println("创建菜单成功");
		} else {
			System.out.println("错误码" + result);
		}
//		JSONObject jsonObject = WeixinUtil.queryMenu(token.getToken());
//		System.out.println(jsonObject);
//		int result = WeixinUtil.deleteMenu(token.getToken());
//		if (result == 0) {
//			System.out.println("菜单删除成功");
//		} else {
//			System.out.println(result);
//		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
