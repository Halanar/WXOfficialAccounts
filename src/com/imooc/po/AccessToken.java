package com.imooc.po;

public class AccessToken {
/*
   access_token	获取到的凭证
   expires_in	凭证有效时间，单位：秒
 
 */
	
	private String token;
	private int expiresIn;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
	
	
}
