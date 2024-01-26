package pe.sblm.intranet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.sblm.intranet.model.DocumentoRecomendacion;
import pe.sblm.intranet.repository.DocumentoRecomendacionRepositorio;

@RestController
@RequestMapping("/api/documentosRec")
@CrossOrigin(origins = "*")
public class DocumentoRecomendacionController {
	
	@Autowired
    private DocumentoRecomendacionRepositorio documentoRecomendacionRepository;
	
	@GetMapping("/{idRecomendacion}")
    public ResponseEntity<List<DocumentoRecomendacion>> obtenerDocumentosPorIdRecomendacion(@PathVariable Long idRecomendacion) {
        List<DocumentoRecomendacion> documentos = documentoRecomendacionRepository.findAllByIdRecomendacion(idRecomendacion);
        return new ResponseEntity<>(documentos, HttpStatus.OK);
    }
}
