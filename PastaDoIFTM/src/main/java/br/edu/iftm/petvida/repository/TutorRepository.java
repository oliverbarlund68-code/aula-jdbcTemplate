public class TutorRepository {
    
}
package br.edu.iftm.petvida.repository;

import br.edu.iftm.petvida.model.Tutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TutorRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public List<Tutor> buscarTodos() {
        String sql = "SELECT * FROM tutor";
        return jdbc.query(sql, (rs, rowNum) -> new Tutor(
            rs.getInt("id_tutor"),
            rs.getString("nome"),
            rs.getString("telefone")
        ));
    }

    public Tutor buscarPorId(int id) {
        String sql = "SELECT * FROM tutor WHERE id_tutor = ?";
        return jdbc.queryForObject(sql, (rs, rowNum) -> new Tutor(
            rs.getInt("id_tutor"),
            rs.getString("nome"),
            rs.getString("telefone")
        ), id);
    }
}