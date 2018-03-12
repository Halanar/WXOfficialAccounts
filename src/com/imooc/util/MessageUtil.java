package com.imooc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.imooc.po.TextMessage;
import com.thoughtworks.xstream.XStream;

public class MessageUtil {
	
	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_IMAGE = "image";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_LINK = "link";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_EVNET = "event";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
	public static final String MESSAGE_CLICK = "CLICK";
	public static final String MESSAGE_VIEW = "VIEW";
	/**
	 * xml转为map集合
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static Map<String, String> xmpToMap(HttpServletRequest request) throws IOException, DocumentException {
		Map<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		
		InputStream ins = request.getInputStream();
		Document doc = reader.read(ins);
		
		Element root = doc.getRootElement();
		
		List<Element> list = root.elements();
		
		for(Element e : list) {
			map.put(e.getName(), e.getText());
		}
		ins.close();
		return map;
	}
	
	/**
	 * 将文本消息对象转为xml
	 * @param textMessage
	 * @return
	 */
	public static String textMessageToXml(TextMessage textMessage) {
		XStream xstream = new XStream();
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}
	
	public static String initText(String toUserName, String fromUserName, String content) {
		TextMessage text = new TextMessage();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(MessageUtil.MESSAGE_TEXT);
		text.setCreateTime(new Date().getTime());
		text.setContent(content);
		return textMessageToXml(text);
	}
	
	/**
	 * 主菜单
	 * @return
	 */
	public static String menuText() {
		StringBuffer sb = new StringBuffer();
		sb.append("欢迎您关注皇家马德里足球俱乐部:\n\n");
		sb.append("1、球队介绍\n");
		sb.append("2、球队荣誉\n\n");
		sb.append("回复?调出此菜单。");
		return sb.toString();
	}
	
	public static String firstMenu() {
		StringBuffer sb = new StringBuffer();
		sb.append("皇家马德里足球俱乐部（Real Madrid Club de Fútbol ，中文简称为皇马）是一家位于西班牙首都马德里的足球俱乐部，球队成立于1902年3月6日，前称马德里足球队。"
				+ "1920年6月29日，时任西班牙国王阿方索十三世把\"Real\"（西语，皇家之意）一词加于俱乐部名前，徽章上加上了皇冠，以此来推动足球运动在西班牙首都马德里市的发展。"
				+ "从此，俱乐部正式更名为皇家马德里足球俱乐部。");
		return sb.toString();
	}
	
	public static String secondMenu() {
		StringBuffer sb = new StringBuffer();
		sb.append("皇马保持着欧冠夺冠次数（12次）  、参赛次数、出场次数、胜利次数、进球数等一系列纪录（包括改制前）。而在西班牙国内皇马一共夺得33次西班牙甲级联赛冠军及19次西班牙国王杯冠军。"
				+ "皇马还有预备队皇马卡斯蒂利亚（Real Madrid Castilla，即皇马B队）在西班牙足球乙级联赛比赛。另外皇马在1932年成立篮球队——皇家马德里Baloncesto，"
				+ "而且篮球队（详细见：皇家马德里篮球俱乐部）成就与足球队同样显赫，9次成为欧洲冠军，33次成为本土职业篮球联赛冠军");
		return sb.toString();
	}
}