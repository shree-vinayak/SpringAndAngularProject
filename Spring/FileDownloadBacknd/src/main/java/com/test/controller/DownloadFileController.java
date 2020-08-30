//package com.test.controller;
//
//import java.io.ByteArrayOutputStream;
//import java.io.OutputStream;
//import java.net.URLEncoder;
//import java.util.List;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.test.model.EmployeeVo;
//import com.test.service.EmployeeService;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
////@Scope("prototype")
//public class DownloadFileController {
//
//	@Autowired
//	private EmployeeService employeeService;
//
////	@Autowired
////	private TestController testController;
//
//	@GetMapping("/employees/download")
//
//	public ResponseEntity<byte[]> downloadFile(HttpServletResponse response) throws Exception {
//		List<EmployeeVo> employeesList = employeeService.getEmployeeList();
//		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//
//		Document document = new Document(PageSize.A4.rotate());
//		PdfWriter.getInstance(document, outputStream);
//
//		PdfPTable table = new PdfPTable(3); // 3 columns.
//		table.setWidthPercentage(100); // Width 100%
//		table.setSpacingBefore(10f); // Space before table
//		table.setSpacingAfter(10f); // Space after table
//
//		// Set Column widths
//		float[] columnWidths = { 1f, 1f, 1f };
//		table.setWidths(columnWidths);
//
//		PdfPCell cell1 = new PdfPCell(new Paragraph("id"));
//		cell1.setBorderColor(BaseColor.BLUE);
//		cell1.setPaddingLeft(10);
//		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
//		cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//		PdfPCell cell2 = new PdfPCell(new Paragraph("name"));
//		cell2.setBorderColor(BaseColor.GREEN);
//		cell2.setPaddingLeft(10);
//		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
//		cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//		PdfPCell cell3 = new PdfPCell(new Paragraph("email"));
//		cell3.setBorderColor(BaseColor.RED);
//		cell3.setPaddingLeft(10);
//		cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
//		cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//		for (EmployeeVo emp : employeesList) {
//			PdfPCell idCell = new PdfPCell(new Paragraph(emp.getId().toString()));
//			idCell.setBorderColor(BaseColor.RED);
//			idCell.setPaddingLeft(10);
//			idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//			PdfPCell nameCell = new PdfPCell(new Paragraph(emp.getName()));
//			nameCell.setBorderColor(BaseColor.RED);
//			nameCell.setPaddingLeft(10);
//			nameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			nameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//			PdfPCell emailCell = new PdfPCell(new Paragraph(emp.getEmail()));
//			emailCell.setBorderColor(BaseColor.RED);
//			emailCell.setPaddingLeft(10);
//			emailCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			emailCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//			table.addCell(idCell);
//			table.addCell(nameCell);
//			table.addCell(emailCell);
//		}
//
//		table.addCell(cell1);
//		table.addCell(cell2);
//		table.addCell(cell3);
//
//		document.open();
//		document.add(table);
//		document.close();
//
//		byte[] isr = outputStream.toByteArray();
//		String fileName = "dailyLogSheet.pdf";
//		HttpHeaders respHeaders = new HttpHeaders();
//		respHeaders.setContentLength(isr.length);
//		respHeaders.setContentType(MediaType.APPLICATION_PDF);
//		respHeaders.setCacheControl("must-revalidate, post-check=0, pre-check=0");
//		respHeaders.set("Pragma", fileName);
//		return new ResponseEntity<byte[]>(isr, respHeaders, HttpStatus.OK);
//
////		response.setHeader("Expires", "0");
////		response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
////		response.setHeader("Pragma", "dailyLogsheet.pdf");
////		response.setHeader("fileName", "dailyLogsheet.pdf");
////		response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".pdf");
////		response.setContentType("application/pdf");
////		response.setContentLength(outputStream.size());
////		OutputStream os = response.getOutputStream();
////		outputStream.writeTo(os);
////		os.flush();
////		os.close();
////		System.out.println("successfully exported the document");
//
//		
//		
//		employeesList.forEach(emp -> {
//			System.out.println(emp);
//			
//		});
//
//	}
//
//	@GetMapping("status")
//	public ResponseEntity<String> checkscopes() throws Exception {
//
//		System.out.println("check the hashcode" + employeeService);
//
//		return new ResponseEntity<String>("Hello check the console", HttpStatus.OK);
//
//	}
//}
