package br.edu.iftm.petvida.repository;

import br.edu.iftm.petvida.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnimalRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public List<Animal> buscarTodos() {
        String sql = "SELECT * FROM animal";
        return jdbc.query(sql, (rs, rowNum) -> new Animal(
            rs.getInt("id_animal"),
            rs.getString("nome"),
            rs.getString("especie"),
            rs.getString("raca"),
            rs.getInt("idade"),
            rs.getInt("id_tutor")
        ));
    }

    public Animal buscarPorId(int id) {
        String sql = "SELECT * FROM animal WHERE id_animal = ?";
        return jdbc.queryForObject(sql, (rs, rowNum) -> new Animal(
            rs.getInt("id_animal"),
            rs.getString("nome"),
            rs.getString("especie"),
            rs.getString("raca"),
            rs.getInt("idade"),
            rs.getInt("id_tutor")
        ), id);
    }

    public int contarAnimais() {
        String sql = "SELECT COUNT(*) FROM animal";
        return jdbc.queryForObject(sql, Integer.class);
    }
}