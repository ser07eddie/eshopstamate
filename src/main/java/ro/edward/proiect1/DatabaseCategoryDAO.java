package ro.edward.proiect1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseCategoryDAO implements CategoryDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Category> findAll() {
        return jdbcTemplate.query("select * from category", new CategoryMapper());

    }
}

