package com.tbp.crud.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tbp.crud.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setAddress(rs.getString("address"));
            return user;
        }
    }

    public User save(User user) {
        if (user.getId() > 0) {
            // Update existing user
            jdbcTemplate.update("UPDATE user SET name = ?, address = ? WHERE id = ?", 
                user.getName(), user.getAddress(), user.getId());
            return user;
        } else {
            // Insert new user
            jdbcTemplate.update("INSERT INTO user (name, address) VALUES (?, ?)",
                user.getName(), user.getAddress());
            return user;
        }
    }

    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM user", new UserRowMapper());
    }

    public User findById(int id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM user WHERE id = ?", new Object[]{id}, new UserRowMapper());
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteById(int id) {
        jdbcTemplate.update("DELETE FROM user WHERE id = ?", id);
    }
}
