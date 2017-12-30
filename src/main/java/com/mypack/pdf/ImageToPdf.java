package com.mypack.pdf;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

public class ImageToPdf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Document document = new Document();
		String input = "e:/toPdf/img.png"; // .gif and .jpg are ok too!
		String output = "e:/toPdf/abc.pdf";
		try
		{
			System.out.println("Processing........");
			FileOutputStream fos = new FileOutputStream(output);
			PdfWriter writer = PdfWriter.getInstance(document, fos);
			writer.open();
			document.open();
			Image img = Image.getInstance(input);
			
			
			float documentWidth = document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin();
			float documentHeight = document.getPageSize().getHeight() - document.topMargin() - document.bottomMargin();
			img.scaleToFit(documentWidth, documentHeight);
	//		img.scalePercent(40);
			//img.scalePercent (55.0f);
			
			//img.setRotationDegrees (30.0f); 
			img.setAlignment(Image.LEFT);
			//img.scaleAbsolute(PageSize.A4);
            //img.setAbsolutePosition(0, 0);
			//document.setPageSize(img);
			document.add(img);
			document.close();
			writer.close();
			System.out.println("Done........");
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		

	}

}
