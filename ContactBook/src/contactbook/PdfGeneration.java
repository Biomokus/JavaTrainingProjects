package contactbook;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import javafx.collections.ObservableList;

public class PdfGeneration {
    
    public void pdfGeneration(String fileName, ObservableList<Person> data){
        
        Document pdfDocument = new Document();
     
        try {
           
         PdfWriter.getInstance(pdfDocument, new FileOutputStream(fileName + ".pdf"));
         pdfDocument.open();
         
         Image logo = Image.getInstance(getClass().getResource("/logo.jpg"));
         logo.scaleToFit(200,86);
         logo.setAbsolutePosition(240f, 750f);
         pdfDocument.add(logo);
        
         pdfDocument.add(new Paragraph("\n\n\n\n\n\n\n\n\n"));
         
         float[] columnWidths = {2, 3 ,3 , 4 };
         PdfPTable table = new PdfPTable(columnWidths);
         table.setWidthPercentage(100);
         
         PdfPCell cell = new PdfPCell(new Phrase("Kontakt lista"));
         cell.setBackgroundColor(BaseColor.GRAY);
         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
         cell.setColspan(4);
         table.addCell(cell);
         
         table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);
         table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         table.addCell("Sorszám");
         table.addCell("Vezetéknév");
         table.addCell("Keresztnév");
         table.addCell("E-mail cím");
         table.setHeaderRows(1);
         
         table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
         table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         
            for (int i = 1; i <= data.size(); i++) {
                Person actualPerson = data.get(i-1);
                
                table.addCell("" + i);
                table.addCell(actualPerson.getLastName());
                table.addCell(actualPerson.getFirstName()); 
                table.addCell(actualPerson.getEmail()); 
            }
            
        pdfDocument.add(table);     
                  
        Chunk signature = new Chunk("\n\n\n\n\n Generálva a ContactBook alkalmazás segítségével.");
        Paragraph base = new Paragraph(signature);
        pdfDocument.add(base);
         
     } catch (Exception ex) {
         ex.printStackTrace();
     }
        pdfDocument.close();
 }
}
