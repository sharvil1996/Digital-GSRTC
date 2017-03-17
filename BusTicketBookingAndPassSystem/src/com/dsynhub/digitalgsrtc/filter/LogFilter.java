package com.dsynhub.digitalgsrtc.filter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsynhub.digitalgsrtc.bean.AdminBean;
import com.dsynhub.digitalgsrtc.bean.UserBean;

public class LogFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		HttpSession session = request.getSession();

		UserBean userBean = (UserBean) session.getAttribute("userBean");
		AdminBean adminBean = (AdminBean) session.getAttribute("adminBean");

		if (userBean != null && adminBean == null) {
			BufferedWriter file = null;
			file = new BufferedWriter(
					new FileWriter(
							"E:\\BusTicketBookingAndPassSystem\\WebContent\\Logging.txt",
							true));
			InetAddress ip;
			ip = InetAddress.getLocalHost();
			String log, str = request.getRequestURL().toString(),temp="";

			String s[] = str.split("/");
			int len = s.length;
			for(int i=4;i<len;i++)
				temp+=s[i]+"/";
				
			log = "At " + new Date() + " (Time) " + temp
					+ "(URL) Is Hitted From User " + userBean.getFirstName()
					+ " " + userBean.getLastName() + "\n";
			file.write(log);
			file.close();
		} else if (userBean == null && adminBean != null) {
			BufferedWriter file = null;
			file = new BufferedWriter(
					new FileWriter(
							"E:\\BusTicketBookingAndPassSystem\\WebContent\\Logging.txt",
							true));
			InetAddress ip;
			ip = InetAddress.getLocalHost();
			String log, str = request.getRequestURL().toString(),temp="";

			String s[] = str.split("/");
			int len = s.length;
			for(int i=4;i<len;i++)
				temp+=s[i]+"/";
			log = "At " + new Date() + " (Time) " + temp
					+ "(URL) Is Hitted From Admin " + adminBean.getFirstName()
					+ " " + adminBean.getLastName() + "\n";
			file.write(log);
			file.close();
		}

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}