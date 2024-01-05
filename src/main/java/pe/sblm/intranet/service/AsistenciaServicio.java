package pe.sblm.intranet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AsistenciaServicio {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AsistenciaServicio(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> obtenerAsistenciasPorDni(String dni) {
        String sql = "SELECT * FROM personal_sblm.rrhh.tb_asistencia WHERE codreloj = ? ORDER BY dhoraingre DESC";
        return jdbcTemplate.queryForList(sql, dni);
    }

//    public List<Map<String, Object>> obtenerAsistenciasPorDniYMes(String dni, int mes, int anio) {
//        String sql = "SELECT * FROM personal_sblm.rrhh.tb_asistencia WHERE codreloj = ? " +
//                "AND MONTH(dfechaingre) = ? AND YEAR(dfechaingre) = ? ORDER BY dhoraingre DESC";
//        return jdbcTemplate.queryForList(sql, dni, mes, anio);
//    }
    
    public List<Map<String, Object>> obtenerAsistenciasPorDniYMes(String dni, int mes, int anio) {
        String sql = "WITH ranked_asistencias AS (" +
                     "    SELECT *, ROW_NUMBER() OVER (PARTITION BY CONVERT(DATE, dfechaingre) ORDER BY dhoraingre) AS rn_asc, " +
                     "           ROW_NUMBER() OVER (PARTITION BY CONVERT(DATE, dfechaingre) ORDER BY dhoraingre DESC) AS rn_desc " +
                     "    FROM personal_sblm.rrhh.tb_asistencia " +
                     "    WHERE codreloj = ? AND MONTH(dfechaingre) = ? AND YEAR(dfechaingre) = ?" +
                     ")" +
                     "SELECT " +
                     "    fecha, " +
                     "    MAX(CASE WHEN rn_asc = 1 THEN CONVERT(DATETIMEOFFSET, dhoraingre) AT TIME ZONE 'UTC' END) AS dhoraingre_entrada, " +
                     "    MAX(CASE WHEN rn_desc = 1 THEN CONVERT(DATETIMEOFFSET, dhoraingre) AT TIME ZONE 'UTC' END) AS dhoraingre_salida " +
                     "FROM (" +
                     "    SELECT CONVERT(DATE, dfechaingre) AS fecha, dhoraingre, rn_asc, rn_desc " +
                     "    FROM ranked_asistencias" +
                     ") AS subquery " +
                     "GROUP BY fecha";

        return jdbcTemplate.queryForList(sql, dni, mes, anio);
    }

   



}