package ro.edward.proiect1;

import java.math.BigDecimal;

public interface OrderDAO {

    public Integer createNewOrder(Integer userId);

    public void createNewOrderLine(Integer orderId, Integer productId, BigDecimal price, Integer quantity);
}
