package com.ra2.users.com_ra2_users.repository;


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
            user.setData_actualitzat(rs.getDate("data_actualitzat"));
            user.setData_creacio(rs.getDate("data_creacio"));
            user.setDescripcio(rs.getString("descripcio"));
            user.setEmail(rs.getString("email"));
            user.setId(rs.getLong("id"));
            user.setNom(rs.getString("nom"));
            user.setUltimAcces(rs.getDate("ultim_acces"));
            return user;
        }

    }

    public void createUser(User user){
        jdbcTemplate.update("INSERT IGNORE INTO users VALUES (?,?,?,?,?,?,?,?)",
        user.getId(),user.getNom(),user.getDescripcio(),user.getEmail(),user.getContrasenya(),
        user.getUltimAcces(),user.getData_creacio(),user.getData_actualitzat());
    }

    public User readUser(long id){
        return jdbcTemplate.query("SELECT * FROM users WHERE ID = (?)",id, new UserRowMapper());
        
    }

    public void updateUser(User user){
        jdbcTemplate.update("UPDATE", null)
    }
    public void deleteUser(long id){
        jdbcTemplate.update("DELETE FROM users WHERE id = (?)",id);
    }
    
    public List<User> findAll(){
        return jdbcTemplate.query("SELECT * FROM users",new UserRowMapper());


    }



}
