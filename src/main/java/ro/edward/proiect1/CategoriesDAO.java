package ro.edward.proiect1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriesDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Categories> findAll() {
        return jdbcTemplate.query("select * from categories", new CategoriesMapper());

    }
}

