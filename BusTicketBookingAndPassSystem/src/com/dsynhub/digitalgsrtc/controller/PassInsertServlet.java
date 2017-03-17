package com.dsynhub.digitalgsrtc.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dsynhub.digitalgsrtc.bean.PassBean;
import com.dsynhub.digitalgsrtc.dao.PassDAO;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;

@SuppressWarnings("serial")
public class PassInsertServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
@SuppressWarnings("unchecked")
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PassBean passBean=new PassBean();
	boolean isError=false;
	FileItemFactory factory=new DiskFileItemFactory();
	ServletFileUpload upload=new ServletFileUpload(factory);
	List<FileItem> items=null;
	String fieldName=null;
	String fieldValue=null;
	File file=null;
	
	String userId="",sourceId="",destinationId="",passTypeId="",validity="",orgnizationId="",fileName = null;
	ServletContext context = getServletContext();
	
	try {
		System.out.println("Hiii");
		items=upload.parseRequest(request);
		System.out.println("ddd   "+items.size());
	
	for(int i=0;i<items.size();i++)
	{	
		FileItem item=items.get(i);
		if(item.isFormField())
		{
			fieldName=item.getFieldName();
			fieldValue=item.getString();
			
				if(fieldName.equals("selUserName"))
				{
					userId=fieldValue;
					System.out.println("ssssss      "+userId);
				}
				
				else if(fieldName.equals("selSourceName"))
				{
					sourceId=fieldValue;
				}
				else if(fieldName.equals("selDestinationName"))
				{	
						destinationId=fieldValue;
				}
				else if(fieldName.equals("rdoPassType"))
				{
					passTypeId=fieldValue;
				}
				else if(fieldName.equals("rdoValidity"))
				{
						validity=fieldValue;
				}
				else if(fieldName.equals("selOrganization"))
				{
					orgnizationId=fieldValue;
				}
			}
		else
		{
			fieldName=item.getFieldName();
			fileName=item.getName();
			System.out.println("file name"+fieldName);
			String path="E:\\BusTicketBookingAndPassSystem\\WebContent\\upload\\pass\\";
			file=new File(path+File.separator+fileName);
			if(fileName.isEmpty())
			{
				isError=true;
				request.setAttribute("file","<font color=red>* Photo is Required........</font>");
			}
			else
			{
				if (context.getMimeType(fileName).equals("image/gif")
						|| context.getMimeType(fileName)
								.equals("image/jpeg")
						|| context.getMimeType(fileName)
								.equals("image/png"))
					try {
						item.write(file);
						passBean.setPhoto(fileName);
					} catch (Exception e) {
						e.printStackTrace();
					}
				else
						request.setAttribute("file","<font color=red>*Please upload files that end in types .png,.jpeg only.</font>");

			}
		}
	}
	if(ValidationUtils.isEmpty(validity))
	{
		isError=true;
		request.setAttribute("validity", "<font color=red>* Validity is Required.......</font>");
	}
	else
		passBean.setValidity(validity);

	if(ValidationUtils.isEmpty(passTypeId))
	{
		isError=true;
		request.setAttribute("validity", "<font color=red>* PassType is Required.......</font>");
	}
	else
		passBean.setPassTypeId(passTypeId);
	
	if(sourceId.equals("0"))
	{
		isError=true;
		request.setAttribute("sourceName", "<font color=red>* SourceName is Required.......</font>");
	}
	else
		passBean.setSourceId(sourceId);
	
	if(orgnizationId.equals("0"))
	{
		isError=true;
		request.setAttribute("organization", "<font color=red>* Organization is Required.......</font>");
	}
	else
		passBean.setOrgId(orgnizationId);
	
	if(destinationId.equals("0"))
	{
		isError=true;
		request.setAttribute("destinationId", "<font color=red>* DestinationName is Required.......</font>");
	}
	else
		passBean.setDestinationId(destinationId);
	
	if(userId.equals("0"))
	{
		request.setAttribute("userName", "<font color=red>* User is Required.......</font>");
		isError=true;
	}
	else
	passBean.setUserId(userId);
	
	if(isError)
	{
		
		request.setAttribute("passBean", passBean);
		request.getRequestDispatcher("passInsert.jsp").forward(request, response);
	}
	else
	{
		
	
			passBean.setStart("date_add(curdate(),interval 1 day)");
			passBean.setPhoto(fileName);
		
		if(new PassDAO().insert(passBean) )
		{
			request.setAttribute("msgpass", "pass successfully added");
			request.getRequestDispatcher("PassListServlet").forward(request, response);
		}
		
		else
		{
			request.setAttribute("msgpass"," failed to add pass");
			request.getRequestDispatcher("passInsert.jsp").forward(request, response);
		}
	}
	} catch (FileUploadException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

}
