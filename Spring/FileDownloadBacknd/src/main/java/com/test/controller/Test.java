package com.test.controller;

import java.io.FileNotFoundException;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		String dest = "sample.pdf";
		/*
		 * PdfWriter writer = new PdfWriter(dest); PdfDocument pdfDoc = new
		 * PdfDocument(writer);
		 * 
		 * pdfDoc.addNewPage(); Document document = new Document(pdfDoc);
		 * document.close();
		 */

		// ============================================================
		/*
		 * PdfWriter writer = new PdfWriter(dest);
		 * 
		 * // Creating a PdfDocument PdfDocument pdf = new PdfDocument(writer);
		 * 
		 * // Creating a Document by passing PdfDocument object to its constructor
		 * Document document = new Document(pdf);
		 * 
		 * // Creating an Area Break AreaBreak aB = new AreaBreak();
		 * 
		 * // Adding area break to the PDF document.add(aB); document.add(aB);
		 * 
		 * // Closing the document document.close(); System.out.println("Pdf created");
		 */

		// ===========================================================
		/*
		 * PdfWriter writer = new PdfWriter(dest);
		 * 
		 * // Creating a PdfDocument PdfDocument pdf = new PdfDocument(writer);
		 * 
		 * // Creating a Document Document document = new Document(pdf); String para1 =
		 * "Tutorials Point originated from the idea that there exists a class of readers who respond better to online content and prefer to learn  new skills at their own pace from the comforts of their drawing rooms."
		 * ;
		 * 
		 * String para2 =
		 * "The journey commenced with a single tutorial on HTML in 2006 and elated by the response it generated, we worked our way to adding fresh   tutorials to our repository which now proudly flaunts a wealth of tutorials  and allied articles on topics ranging from programming languages to web designing  to academics and much more."
		 * ;
		 * 
		 * // Creating Paragraphs Paragraph paragraph1 = new Paragraph(para1); Paragraph
		 * paragraph2 = new Paragraph(para2);
		 * 
		 * // Adding paragraphs to document document.add(paragraph1);
		 * document.add(paragraph2);
		 * 
		 * // Closing the document document.close();
		 * System.out.println("Paragraph added");
		 */

		// ==================================================================
		/*
		 * PdfWriter writer = new PdfWriter(dest);
		 * 
		 * // Creating a PdfDocument PdfDocument pdf = new PdfDocument(writer);
		 * 
		 * // Creating a Document Document document = new Document(pdf);
		 * 
		 * // Creating a Paragraph Paragraph paragraph = new
		 * Paragraph("Tutorials Point provides the following tutorials");
		 * 
		 * // Creating a list List list = new List();
		 * 
		 * // Add elements to the list list.add("Java"); list.add("JavaFX");
		 * list.add("Apache Tika"); list.add("OpenCV"); list.add("WebGL");
		 * list.add("Coffee Script"); list.add("Java RMI"); list.add("Apache Pig");
		 * 
		 * // Adding paragraph to the document document.add(paragraph);
		 * 
		 * // Adding list to the document document.add(list);
		 * 
		 * // Closing the document document.close(); System.out.println("List added");
		 */

		// ==========================================================================

		PdfWriter writer = new PdfWriter(dest);

		// Creating a PdfDocument object
		PdfDocument pdf = new PdfDocument(writer);

		// Creating a Document object
		Document doc = new Document(pdf, PageSize.A4.rotate());

		// Creating a table
		float[] pointColumnWidths = { 150F, 150F, 150F };
		Table table = new Table(pointColumnWidths);

		// Adding cells to the table
		table.addCell(new Cell().add("Name"));
		table.addCell(new Cell().add("Id"));
		table.addCell(new Cell().add("Designation"));
		table.addCell(new Cell().add("ankit"));
		table.addCell(new Cell().add("1001"));
		table.addCell(new Cell().add("Programmer").addStyle(
				new Style().setBackgroundColor(Color.BLACK).setBorder(Border.NO_BORDER).setFontColor(Color.WHITE)));
		table.setWidthPercent(100f);

		// Adding Table to document
		doc.add(table);

		// Closing the document
		doc.close();
		System.out.println("Table created successfully..");

	}
}
