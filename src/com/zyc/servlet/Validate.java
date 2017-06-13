package com.zyc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zyc.processor.MyProcessor;
import com.zyc.util.HadIP;

import us.codecraft.webmagic.Spider;

/**
 * Servlet implementation class ValidateIP
 */
@WebServlet(value = "/*")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyProcessor myProcessor = new MyProcessor();
		Spider.create(myProcessor).addUrl("http://ip.taobao.com/service/getIpInfo.php?ip="+HadIP.hadAbsoluteIp(request)).thread(5).run();
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		PrintWriter printWriter = new PrintWriter(response.getOutputStream());
		printWriter.print(myProcessor.getDiqu());
		printWriter.print(myProcessor.getIp());
		printWriter.flush();
		System.out.print(myProcessor.getDiqu()+":");
		System.out.println(myProcessor.getIp());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
