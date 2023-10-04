package ir.dalit.pdfgen.api;

import ir.dalit.pdfgen.domain.Note;
import ir.dalit.pdfgen.service.PdfGeneratorService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pdf")
public class PdfGeneratorAPI {

    private final PdfGeneratorService pdfGeneratorService;

    public PdfGeneratorAPI(PdfGeneratorService pdfGeneratorService) {
        this.pdfGeneratorService = pdfGeneratorService;
    }

    @PostMapping
    public Object generate(@RequestBody Note note) {
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,String.format("attachment; filename=%s.pdf",note.getName()))
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfGeneratorService.convertHtmlToPdf(note.getContent()));
    }

}
