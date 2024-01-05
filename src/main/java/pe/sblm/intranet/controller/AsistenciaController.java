package pe.sblm.intranet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pe.sblm.intranet.service.AsistenciaServicio;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/asistencias")
@CrossOrigin(origins = "*")
public class AsistenciaController {

    private final AsistenciaServicio asistenciaServicio;

    @Autowired
    public AsistenciaController(AsistenciaServicio asistenciaServicio) {
        this.asistenciaServicio = asistenciaServicio;
    }

    @GetMapping("/{dni}")
    public List<Map<String, Object>> getAllByCodreloj(@PathVariable String dni) {
        return asistenciaServicio.obtenerAsistenciasPorDni(dni);
    }

    @GetMapping("/{dni}/{mes}/{anio}")
    public List<Map<String, Object>> getAllByCodrelojAndMonth(@PathVariable String dni, @PathVariable int mes,  @PathVariable int anio) {
        return asistenciaServicio.obtenerAsistenciasPorDniYMes(dni, mes, anio);
    }

}