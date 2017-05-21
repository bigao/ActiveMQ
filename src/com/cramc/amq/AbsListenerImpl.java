package com.cramc.amq;

import java.util.Map;
/**
 * 消息处理类，处理监听到的消息
 * @author chenwj
 *
 */

public class AbsListenerImpl extends AbsListener{

	/**
	 * 处理Map消息
	 */
	@Override
	public void dealWithMsgMapValue(Map<String, Object> dicMap) {
		System.out.println("监听到的消息为：" + dicMap.toString());
	}

	/**
	 * 处理Text消息
	 */
	@Override
	public void dealWithMsgTextValue(String text) {
		System.out.println("监听到的消息为：" + text);
	}

}
