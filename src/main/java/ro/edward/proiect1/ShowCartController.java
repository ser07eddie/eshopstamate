package ro.edward.proiect1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ShowCartController {

    @Autowired
    CartSession cartSession;

    @Autowired
    DatabaseProductDAO databaseProductDAO;

    @Autowired
    DatabaseCategoryDAO databaseCategoryDAO;




    @GetMapping("/show-cart")
    public ModelAndView showCart(@RequestParam("product_id") Integer productId){

        ModelAndView modelAndView = new ModelAndView("show-cart");

        List<Integer>showCart = cartSession.getProductIds();
        modelAndView.addObject("show-cart",showCart);
        return modelAndView;
    }
}
