package ro.edward.proiect1;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriesMapper implements RowMapper<Categories> {
    @Override
    public Categories mapRow(ResultSet resultSet, int i) throws SQLException {

        Categories categories = new Categories();
        categories.setIdcategories(resultSet.getInt("idcategories"));
        categories.setName(resultSet.getString("name"));
        categories.setDescription(resultSet.getString("description"));
        categories.setPhoto("photo");

        return categories;
    }
}
