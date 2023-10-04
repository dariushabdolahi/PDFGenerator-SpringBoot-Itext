package ir.dalit.pdfgen.service;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.source.ByteArrayOutputStream;
import org.springframework.stereotype.Service;

@Service
public class PdfGeneratorServiceImpl implements PdfGeneratorService {

    @Override
    public byte[] convertHtmlToPdf(String html) {
        ByteArrayOutputStream target = new ByteArrayOutputStream();
        ConverterProperties converterProperties = new ConverterProperties();
        HtmlConverter.convertToPdf(html, target, converterProperties);
        return target.toByteArray();
    }
}
