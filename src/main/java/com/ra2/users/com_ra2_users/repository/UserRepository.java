package com.ra2.users.com_ra2_users.repository;


import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.ra2.users.com_ra2_users.model.User;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final class UserRowMapper implements RowMapper<User>{
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setContrasenya(rs.getString("contrasenya"));
            user.setDataUpdated(rs.getTimestamp("data_actualitzat"));
            user.setDataCreated(rs.getTimestamp("data_creacio"));
            user.setDescripcio(rs.getString("descripcio"));
            user.setEmail(rs.getString("email"));
            user.setId(rs.getLong("id"));
            user.setNom(rs.getString("nom"));
            user.setUltimAcces(rs.getTimestamp("ultim_acces"));
            return user;
        }

    }

    public void createUser(User user){
        jdbcTemplate.update("INSERT IGNORE INTO users VALUES (?,?,?,?,?,?,?,?)",
            user.getId(),user.getNom(),user.getDescripcio(),user.getEmail(),user.getContrasenya(),
            user.getUltimAcces(),user.getDataCreated(),user.getDataUpdated());
    }

    public User readUser(long id){
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE ID = (?)", new UserRowMapper(),id);
        
    }

    public void updateUser(long id, User user){
        String query = "UPDATE users set nom = ?, descripcio = ?, email = ?, contrasenya = ?, ultim_acces = ?, data_creacio = ?, data_actualitzat = ? where id = ?";
        jdbcTemplate.update(query, user.getNom(), user.getDescripcio(), user.getEmail(), user.getContrasenya(), user.getUltimAcces(), user.getDataCreated(), user.getDataUpdated(), id);
    }

    public void updateUser(long id, String name, Timestamp time){
        String query = "UPDATE users set nom = ?, data_actualitzat = ? where id = ?";
        jdbcTemplate.update(query, name, time, id);
     
    }
    public void deleteUser(long id){
        jdbcTemplate.update("DELETE FROM users WHERE id = ?",id);
    }
    
    public List<User> findAll(){
        return jdbcTemplate.query("SELECT * FROM users",new UserRowMapper());


    }



}
