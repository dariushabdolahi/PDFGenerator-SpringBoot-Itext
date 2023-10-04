package ir.dalit.pdfgen.service;

public interface PdfGeneratorService {
    byte[] convertHtmlToPdf(String html);
}
