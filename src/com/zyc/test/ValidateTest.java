package com.zyc.test;

import org.junit.Test;

import com.zyc.processor.MyProcessor;

import us.codecraft.webmagic.Spider;

public class ValidateTest {
	@Test
	public void testPro(){
		MyProcessor myProcessor =new MyProcessor();
		Spider.create(myProcessor).addUrl("http://ip.taobao.com/service/getIpInfo.php?ip="+"123.206.8.180").thread(5).run();
		System.out.println(myProcessor.getDiqu());
		System.out.println(myProcessor.getIp());
	}
}
