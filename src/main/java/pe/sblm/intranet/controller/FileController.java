package pe.sblm.intranet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import pe.sblm.intranet.model.Documento;
import pe.sblm.intranet.model.DocumentoRecomendacion;
import pe.sblm.intranet.repository.DocumentoRecomendacionRepositorio;
import pe.sblm.intranet.repository.DocumentoRepositorio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@RestController
@RequestMapping("/api/files")
@CrossOrigin(origins = "*")
public class FileController {
	@Autowired
    private DocumentoRepositorio documentoRepository;
	
	@Autowired
    private DocumentoRecomendacionRepositorio documentoRecomendacionRepository;

	@Value("${custom.urlFolder}")
    String uploadDir;
	
	@Value("${custom.urlServer}")
    String urlDoc;

    @PostMapping(value="/publication/{tipo}/{idPublicacion}")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable String tipo,  @PathVariable Long idPublicacion) {
        try {
            File directory = new File(uploadDir + "/" + tipo);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String fileName = generateUniqueFileName(file.getOriginalFilename());
            Path targetLocation = Paths.get(uploadDir + "/" + tipo).resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            
            Documento documento = new Documento(idPublicacion, urlDoc + "/" + tipo + "/" + fileName);
            this.documentoRepository.save(documento);

            return ResponseEntity.ok(urlDoc + "/" + tipo + "/" + fileName);
        } catch (IOException ex) {
            ex.printStackTrace(); 
            return ResponseEntity.badRequest().body("Error uploading the file: " + ex.getMessage());
        }
    }
    
    @PostMapping(value="/recomendation/{tipo}/{idRecomendacion}/{fecha}")
    public ResponseEntity<String> uploadFileRecomendacion(@RequestParam("file") MultipartFile file, @PathVariable String tipo,  @PathVariable Long idRecomendacion, @PathVariable String fecha) {
        try {
            File directory = new File(uploadDir + "/" + tipo);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String fileName = generateUniqueFileName(file.getOriginalFilename());
            Path targetLocation = Paths.get(uploadDir + "/" + tipo).resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            
            DocumentoRecomendacion documentoRec = new DocumentoRecomendacion(idRecomendacion, urlDoc + "/" + tipo + "/" + fileName, file.getOriginalFilename(), fecha);
            this.documentoRecomendacionRepository.save(documentoRec);

            return ResponseEntity.ok(urlDoc + "/" + tipo + "/" + fileName);
        } catch (IOException ex) {
            ex.printStackTrace(); 
            return ResponseEntity.badRequest().body("Error uploading the file: " + ex.getMessage());
        }
    }



    private String generateUniqueFileName(String originalFileName) {
        String extension = "";
        int lastDotIndex = originalFileName.lastIndexOf(".");
        if (lastDotIndex != -1) {
            extension = originalFileName.substring(lastDotIndex);
        }

        String uniqueID = UUID.randomUUID().toString();
        return uniqueID + "-" + originalFileName;
    }
}
