package com.examples.pdf.convert;

import com.jmupdf.enums.ImageType;
import com.jmupdf.exceptions.DocException;
import com.jmupdf.exceptions.DocSecurityException;
import com.jmupdf.exceptions.PageException;
import com.jmupdf.page.Page;
import com.jmupdf.pdf.PdfDocument;

/**
 * Create a PNG file
 *
 */
public class RenderTestB {

	public static void main(String[] args) {
		PdfDocument doc = null;
		Page page = null;
		
		try {

			/* Open document */
			doc = new PdfDocument("d:\\tmp\\iTextinAction.pdf");

			/* Get page */
			page = new Page(doc, 1);
			
			/* Set parameter values */
			String file = "d:\\tmp\\test1.png";
			int rotate = Page.PAGE_ROTATE_NONE;
			float zoom = 1f;
			ImageType type = ImageType.IMAGE_TYPE_RGB;
			float gamma = 1f;
			
			/* Create png file */
			page.saveAsPng(file, rotate, zoom, type, gamma);
		} catch (DocException e) {
			e.printStackTrace();
		} catch (DocSecurityException e) {
			e.printStackTrace();
		} catch (PageException e) {
			e.printStackTrace();
		} finally {
			if (page != null)
				page.dispose();
			if (doc != null)
				doc.dispose();
		}
		
	}

    /**
     * Print test messages
     * @param text
     */
    protected static void log(String text) {
    	System.out.println(text);
    }
    
}