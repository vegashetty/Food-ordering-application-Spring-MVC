package com.foodapp.pdfview;

import java.awt.Color;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.foodapp.spring.dao.CustomerDAO;
import com.foodapp.spring.dao.OrderDAO;
import com.foodapp.spring.dao.RecipeDAO;
import com.foodapp.spring.pojo.Order;
import com.foodapp.spring.pojo.OrderDetails;
import com.foodapp.spring.pojo.Recipe;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfReportView extends AbstractPdfView
{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document pdfdoc, PdfWriter pdfwriter, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Font font_helvetica_16_normal_blue = new Font(Font.HELVETICA, 16, Font.NORMAL, Color.BLUE); 
		Font font_courier_16_italic_red = new Font(Font.COURIER, 16, Font.ITALIC, Color.RED);
		Font font_times_16_bold_green = new Font(Font.TIMES_ROMAN, 18, Font.BOLD, Color.GREEN);
		HttpSession session = request.getSession();
		  long customerID = (Long) session.getAttribute("customerId");
		  System.out.println(customerID);
		  OrderDAO od = new OrderDAO();
		 //Order o =  (Order) od.list(customerID);
	        List orderList = null;

	            orderList = od.list(customerID);



	            Iterator orderIterator = orderList.iterator();
	           
	    		Chunk c2 = new Chunk("View Order History", font_courier_16_italic_red);
	    		 Chunk c1 = new Chunk("\n");
	    			
	        	pdfdoc.add(c2);
	        	pdfdoc.add(c1);
	            while (orderIterator.hasNext())

	            {

	               Order o = (Order) orderIterator.next();

	              

		
	            
	            String orderDate = o.getOrderDate();
	            long oid = o.getOrderid();
	        
	            List orderDetailsList = null;

	            orderDetailsList = od.detailslist(oid);



	            Iterator orderDIterator = orderDetailsList.iterator();



	            while (orderDIterator.hasNext())

	            {

	               OrderDetails ods = (OrderDetails) orderDIterator.next();

	               float price = ods.getPrice();
	               System.out.println(price);
	               String str = Float.toString(price);
	               long rid = ods.getRecipeid();
	               System.out.println(rid);
	            RecipeDAO rd = new RecipeDAO();
	          
	               Recipe r = rd.get(rid);
	               System.out.println(r);
	         String recipeName = r.getRecipeName();
	         System.out.println(recipeName);
//
//		//Chunk c1 = new Chunk(price);
////		
		Phrase phr1 = new Phrase(recipeName, font_helvetica_16_normal_blue);
	Phrase phr2 = new Phrase(price);
//		
//		Paragraph prg1 = new Paragraph(orderDate, font_times_16_bold_green);
//		//Paragraph prg2 = new Paragraph(price);
//		
//		//pdfdoc.add(c1);
	
////		
//	pdfdoc.add(phr1);
//	pdfdoc.add(phr2);
//	
	
	
	

        

	PdfPTable table = new PdfPTable(3); // 3 columns.

    PdfPCell cell1 = new PdfPCell(new Paragraph(recipeName));
    PdfPCell cell2 = new PdfPCell(new Paragraph(str));
    PdfPCell cell3 = new PdfPCell(new Paragraph(orderDate));

    table.addCell(cell1);
    table.addCell(cell2);
    table.addCell(cell3);
    pdfdoc.add(table);

	
	
	
	
//		
//		pdfdoc.add(prg1);
//		//pdfdoc.add(prg2);
		
	
	            }
	            }
	            
	}

}
