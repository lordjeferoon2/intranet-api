package pe.sblm.intranet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.sblm.intranet.model.Documento;
import pe.sblm.intranet.repository.DocumentoRepositorio;

@RestController
@RequestMapping("/api/documentos")
@CrossOrigin(origins = "*")
public class DocumentoController {
	
	@Autowired
    private DocumentoRepositorio documentoRepository;
	
	@GetMapping("/{idPublicacion}")
    public ResponseEntity<List<Documento>> obtenerDocumentosPorIdPublicacion(@PathVariable Long idPublicacion) {
        List<Documento> documentos = documentoRepository.findAllByIdPublicacion(idPublicacion);
        return new ResponseEntity<>(documentos, HttpStatus.OK);
    }
}
