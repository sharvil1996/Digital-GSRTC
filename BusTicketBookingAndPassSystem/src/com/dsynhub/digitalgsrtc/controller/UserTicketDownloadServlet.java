package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cete.dynamicpdf.Document;
import com.cete.dynamicpdf.Font;
import com.cete.dynamicpdf.Page;
import com.cete.dynamicpdf.PageOrientation;
import com.cete.dynamicpdf.PageSize;
import com.cete.dynamicpdf.TextAlign;
import com.cete.dynamicpdf.pageelements.Label;
import com.dsynhub.digitalgsrtc.bean.ReservationBean;
import com.dsynhub.digitalgsrtc.bean.ReservationDetailBean;
import com.dsynhub.digitalgsrtc.bean.UserBean;
import com.dsynhub.digitalgsrtc.dao.StationDAO;

public class UserTicketDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServletOutputStream sOut;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		System.out.println("Hi");

		ReservationBean reservationBean = (ReservationBean) session
				.getAttribute("reservationBean");
		ReservationDetailBean reservationDetailBean = (ReservationDetailBean) session
				.getAttribute("reservationDetailBean");

		sOut = response.getOutputStream();

		Document objDocument = new Document();
		objDocument.setCreator("UserTicketDownloadServlet.java");
		objDocument.setAuthor("DIGITAL GSRTC");
		objDocument.setTitle("Download E-Ticket");

		// Create a page to add to the document
		Page objPage = new Page(PageSize.LETTER, PageOrientation.PORTRAIT,
				54.0f);

		/*
		 * String strText = "Hello World...\nFrom DynamicPDF Generator " +
		 * "for Java\nDynamicPDF.com";
		 */

		UserBean userBean = (UserBean) session.getAttribute("userBean");
		
		System.out.println("Name" + userBean.getFirstName());
		
		String strText = " E - Ticket " + " \n "
					   + " Name :: " + userBean.getFirstName() + " " + userBean.getLastName() + " \n "
         			   + " Source :: "+ new StationDAO().getByPK(reservationBean.getSourceId()).getStationName() + " \n "
				       + " Destination :: " + new StationDAO().getByPK(reservationBean.getDestinationId()).getStationName() + " \n ";
				

		StringBuffer strTextTemp = new StringBuffer("Journey Date :: " +  reservationBean.getJourneyDate() + " \n "+ " Total Amount :: "
				+ reservationBean.getTotalAmount() + " \n " + " No Of Seat :: "
				+ reservationBean.getNoOfSeat() + " \n " + " Seat No :: ");

		String seat[] = reservationDetailBean.getSeatNo();
		for (String i : seat) {
			strTextTemp.append(i + " ");
		}

		Label objLabel = new Label(strText, 0, 0, 504, 100,
				Font.getHelvetica(), 18, TextAlign.CENTER);

		// Add label to page
		objPage.getElements().add(objLabel);

		String temp = new String(strTextTemp);

		Label objLabel1 = new Label(temp, 0, 82, 504, 100, Font.getHelvetica(),
				18, TextAlign.CENTER);

		// Add label to page
		objPage.getElements().add(objLabel1);

		// Add page to document
		objDocument.getPages().add(objPage);

		// Outputs the document to current web page.
		objDocument.drawToWeb(request, response, sOut, "E-Ticket.pdf");
		sOut.close();

		/*session.removeAttribute("reservationBean");
		session.removeAttribute("reservationDetailBean");*/
		
	}
}