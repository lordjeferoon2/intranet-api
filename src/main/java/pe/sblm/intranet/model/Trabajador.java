package pe.sblm.intranet.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 5)
    private String nombre;

    @Column(length = 15)
    private String apePaterno;

    @Column(length = 100)
    private String apeMaterno;

    @Column(length = 1000)
    private String dni;

    @Column(length = 1)
    private String sexo;

    @Column(length = 9)
    private String celular;

    @Column(length = 30)
    private LocalDateTime fecNaci;

    @Column(length = 200)
    private LocalDateTime fecIngreso;
}
