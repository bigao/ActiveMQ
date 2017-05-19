package com.cramc.amq.common;

import java.util.Map;
/**
 * 消息类
 * @author chenwj
 * 
 */
public class MessageEntity {

	private Map<String,Object> headMap;  //消息头
	private Map<String,Object> bodyMap;  //消息内容
	
	public Map<String, Object> getHeadMap() {
		return headMap;
	}
	public void setHeadMap(Map<String, Object> headMap) {
		this.headMap = headMap;
	}
	public Map<String, Object> getBodyMap() {
		return bodyMap;
	}
	public void setBodyMap(Map<String, Object> bodyMap) {
		this.bodyMap = bodyMap;
	}
	
}
