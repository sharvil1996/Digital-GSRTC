package com.dsynhub.digitalgsrtc.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import com.dsynhub.digitalgsrtc.bean.PassBean;
import com.dsynhub.digitalgsrtc.dao.PassDAO;

public class PassConformServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String passId=request.getParameter("passId");

		PassBean passBean = new PassDAO().getByPK(passId);
		
		try {
			ByteArrayOutputStream out = QRCode
					.from("Name: "+passBean.getFirstName()
							+" "+passBean.getLastName()+"\nRoute:" + passBean.getSource()+"-"
							+ passBean.getDestination()+"\nStartDate: "+passBean.getStartTermDate()+"\nEndDate: "+passBean.getEndTermDate()+"\nOrganization: "+passBean.getOrganizationName()+"At "+passBean.getOrganizationAddress()).to(ImageType.GIF)
					.stream();

			FileOutputStream fout = new FileOutputStream(
					new File("E:\\BusTicketBookingAndPassSystem\\WebContent\\upload\\QRCode\\"+passBean.getFirstName()+" "+passBean.getMiddleName()+" "+passBean.getLastName()+".gif"));
			fout.write(out.toByteArray());
			fout.flush();
			fout.close();
			System.out.println(passBean.getFirstName());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		session.setAttribute("passBean", passBean);
		response.sendRedirect("passPrint.jsp");

	}

}
