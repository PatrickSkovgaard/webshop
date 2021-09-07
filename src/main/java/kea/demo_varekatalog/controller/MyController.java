package kea.demo_varekatalog.controller;

import kea.demo_varekatalog.services.ProductHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    private ProductHandler productHandler = new ProductHandler();


    @GetMapping("/")
    public String indexPage(){
        return "index";
    }

    @GetMapping("/product_page")
    public String showProjectPage(Model model){

        model.addAttribute("product_list", productHandler.showProducts());

        return "project_page";
    }

    @GetMapping("/create_product")
    public String createProductPage(){

        return "create_product";
    }

    @GetMapping("/update_product_page")
    public String updateProjectPage(){

        return "update_product_page";
    }
}
