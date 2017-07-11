package com.foodapp.spring.controller;



	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.servlet.ModelAndView;
	import org.springframework.web.servlet.View;

	import com.foodapp.pdfview.PdfReportView;

	@Controller
	@RequestMapping("/report.pdf")
	public class PdfReportController {
		
		@RequestMapping(method = RequestMethod.GET)
		public ModelAndView createReport()
		{
			View view = new PdfReportView();
			
			return new ModelAndView(view);
		}
	}


