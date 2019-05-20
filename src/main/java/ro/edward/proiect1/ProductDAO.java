package ro.edward.proiect1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface ProductDAO {

    public List<Product> findAll();
    public List<Product> findAllByCatId(Integer catId);
}
