package com.zyc.processor;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import net.sf.json.JSONObject;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class MyProcessor implements PageProcessor{
	private Site site = Site.me();
	private String ip = null;
	private String diqu = null;
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDiqu() {
		return diqu;
	}

	public void setDiqu(String diqu) {
		this.diqu = diqu;
	}

	@Override
	public Site getSite() {
		return this.site;
	}

	@Override
	public void process(Page page) {
		try{
		Document document = Jsoup.parse(page.getHtml().toString());
		Elements elements = document.getElementsByTag("body");
		System.out.println(elements.first().text());
		JSONObject jsonObject = JSONObject.fromObject(elements.first().text());
		jsonObject = JSONObject.fromObject(jsonObject.get("data"));
		diqu = jsonObject.get("country")+""+jsonObject.get("area")+jsonObject.get("city")+jsonObject.get("isp");
		ip = jsonObject.getString("ip");
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
}
