package ro.edward.proiect1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    CartSession cartSession;

    @GetMapping("add-to-cart")
    public String addToCart(
            @RequestParam("product_id") Integer productId) {
        List<Integer> ids = cartSession.getProductIds();
        if(ids == null) {
            ids = new ArrayList<>();
        }
        ids.add(productId);
        cartSession.setProductIds(ids);

        return "redirect:/categories";
    }

}
