package pe.sblm.intranet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TrabajadorService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TrabajadorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> obtenerTrabajadorPorDni(String dni) {
        String sql = "SELECT vnombres, vapepat, vapemat, iddocu, vnumdocu, " +
                "vcelular, idarea, dfecnac, idsexo, idestacivil, numhijos, " +
                "dfechaingreso, idregimen FROM PERSONAL_SBLM.dbo.tb_mtrabajador " +
                "WHERE vnumdocu=?";
        return jdbcTemplate.queryForList(sql, dni);
    }

}
