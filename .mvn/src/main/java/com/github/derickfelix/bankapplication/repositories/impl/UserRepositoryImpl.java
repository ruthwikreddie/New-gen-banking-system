package com.github.derickfelix.bankapplication.repositories.impl;

import com.github.derickfelix.bankapplication.database.BankAppTemplate;
import com.github.derickfelix.bankapplication.database.RowMapper;
import com.github.derickfelix.bankapplication.models.User;
import com.github.derickfelix.bankapplication.repositories.UserRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.h2.util.StringUtils;

public class UserRepositoryImpl implements UserRepository {

    private final BankAppTemplate template;

    public UserRepositoryImpl()
    {
        this.template = new BankAppTemplate();
    }

    @Override
    public List<User> findAll()
    {
        String sql = "select * from users";

        return template.queryForList(sql, null, new UserMapper());
    }

    @Override
    public Optional<User> find(Long id)
    {
        String sql = "select * from users where id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        return template.queryForObject(sql, params, new UserMapper());
    }

    @Override
    public void save(User model)
    {
        String sql;
        Map<String, Object> params = new HashMap<>();

        if (model.getId() == null) {
            sql = "insert into users (name, username, password, role) "
                    + "values (:name, :username, HASH('SHA256', :password), :role)";

            params.put("password", model.getPassword());
        } else {
            sql = "update users set name = :name, username = :username, role = :role where id = :id";

            params.put("id", model.getId());
        }

        params.put("username", model.getUsername());
        params.put("name", model.getName());
        params.put("role", model.getRole());

        template.update(sql, params);
    }

    @Override
    public Optional<User> deleteById(Long id)
    {
        Optional<User> optional = find(id);

        optional.ifPresent(user -> {
            String sql = "delete from users where id = :id";
            Map<String, Object> params = new HashMap<>();
            params.put("id", user.getId());

            template.update(sql, params);
        });

        return optional;
    }
    
    @Override
    public Optional<User> findByUsername(String username)
    {
        String sql = "select * from users where username = :username";
        Map<String, Object> params = new HashMap<>();
        params.put("username", username);

        return template.queryForObject(sql, params, new UserMapper());
    }

    @Override
    public Optional<User> findByUsernameAndPassword(String username, String password)
    {
        String sql = "select * from users where username = :username and password = HASH('SHA256', :password)";
        Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);

        return template.queryForObject(sql, params, new UserMapper());
    }

    @Override
    public List<User> search(String term)
    {
        String sql = "select * from users where id = :code or (upper(name) like :term or upper(username) like :term or upper(role) like :term)";
        Map<String, Object> params = new HashMap<>();
        params.put("code", StringUtils.isNumber(term) ? term : -1);
        params.put("term", "%" + term.toUpperCase() + "%");

        return template.queryForList(sql, params, new UserMapper());
    }

    public static class UserMapper implements RowMapper {

        @Override
        public Object mapRow(ResultSet rs) throws SQLException
        {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));

            return user;
        }

    }
}
