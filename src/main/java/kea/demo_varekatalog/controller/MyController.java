package kea.demo_varekatalog.controller;

import kea.demo_varekatalog.models.Product;
import kea.demo_varekatalog.services.ProductHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class MyController {

    private ProductHandler productHandler = new ProductHandler();
    private HttpSession session;



    @GetMapping("/")
    public String indexPage(){
        return "index";
    }

    @GetMapping("/product_page")
    public String showProductPage(Model model, HttpServletRequest request){
        //session = request.getSession();
        model.addAttribute("product_list", productHandler.getProducts());
        //session.setAttribute("product_list_session", productHandler.getProducts());

        return "product_page";
    }

    @GetMapping("/create_product")
    public String createProductPage(){

        return "create_product";
    }

    @GetMapping("/update_product_page")
    public String updateProjectPage(Model model){
        return "update_product_page";
    }

    @PostMapping("/update_product_info")
    public String updateProductInfo(
                                    @RequestParam(name="product_name") String name,
                                    @RequestParam(name="product_price") int price) {




        productHandler.updateProduct(, formerProduct_name, name, price);



        return "redirect:/product_page";
    }
}
