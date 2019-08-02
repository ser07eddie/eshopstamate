package ro.edward.proiect1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    CartSession cartSession;

    @Autowired
    SecuritySession securitySession;

    @Autowired
    DatabaseProductDAO databaseProductDAO;

    @Autowired
    DatabaseOrderDAO databaseOrderDAO;

    @GetMapping("add-to-cart")
    public String addToCart(
            @RequestParam("product_id") Integer productId) {
        List<Integer> ids = cartSession.getProductIds();

        Integer catId = databaseProductDAO.findById(productId).getCatId();

        ids.add(productId);
        cartSession.setProductIds(ids);

        return "redirect:/products?category_id=" + catId;
    }

    @GetMapping("/show-cart")
    public ModelAndView showCart(){

        ModelAndView modelAndView = new ModelAndView("show-cart");

        List<Integer> productIdsFromCart = cartSession.getProductIds();
        List<Product> productList = new ArrayList<>();
        for(Integer pId: productIdsFromCart){
            Product p = databaseProductDAO.findById(pId);
            productList.add(p);
        }
        modelAndView.addObject("products",productList);
        return modelAndView;
    }

    @GetMapping("send-order")
    public String sendOrder() {
        List<Integer> ids = cartSession.getProductIds();
        Integer orderId = databaseOrderDAO.createNewOrder(securitySession.getUserId());
        for(Integer id: ids){
            databaseOrderDAO.createNewOrderLine(orderId,id,databaseProductDAO.findById(id).price,1);
        }
        cartSession.setProductIds(new ArrayList<>());



        return "redirect:/categories";
    }

}
