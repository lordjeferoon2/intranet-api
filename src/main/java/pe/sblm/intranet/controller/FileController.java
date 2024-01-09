package pe.sblm.intranet.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

	@Value("${custom.url}")
    String uploadDir;

    @PostMapping(value="/{tipo}")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable String tipo) {
        String uploadDir2 = "http://192.168.1.6/media";
        try {
            File directory = new File(uploadDir + "/" + tipo);
            if (!directory.exists()) {
                directory.mkdirs(); // Utiliza mkdirs para crear directorios recursivamente si no existen
            }

            String fileName = generateUniqueFileName(file.getOriginalFilename());
            Path targetLocation = Paths.get(uploadDir + "/" + tipo).resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return ResponseEntity.ok(uploadDir2 + "/" + tipo + "/" + fileName);
        } catch (IOException ex) {
            ex.printStackTrace(); // Imprime el stack trace del error para identificar la causa
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
