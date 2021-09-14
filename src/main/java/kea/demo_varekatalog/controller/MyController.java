package kea.demo_varekatalog.controller;

import kea.demo_varekatalog.models.Product;
import kea.demo_varekatalog.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class MyController {

    private ProductService productService = new ProductService();
    private ArrayList<Product> products = new ArrayList<>();
    private HttpSession session;





    @GetMapping("/")
    public String showProductPage(Model model){
        model.addAttribute("product_list", productService.getProducts());
        return "product_page";
    }

    @PostMapping("/direct_to_update_product_page")
    public String directToProductPage(@RequestParam(name="product_id") int id){

        return "redirect:/update_product_page/" + id;
    }

    @PostMapping("/direct_to_delete_product")
    public String deleteProduct(@RequestParam(name="delete_product") int id){
        productService.deleteProduct(id);

        return "redirect:/";
    }

    @GetMapping("/create_product")
    public String createProductPage(Model model){
        model.addAttribute("id", productService.calculateNextId());

        return "create_product";
    }

    @GetMapping("/update_product_page/{id}")
    public String updateProjectPage(@PathVariable("id") int id,
                                                  Model model){
        model.addAttribute("product", productService.getProductById(id));
       // model.addAttribute("product_id", id);

        return "update_product_page";
    }

    @PostMapping("/update_product_info")
    public String updateProductInfo(@RequestParam(name="prod_id") int id,
                                    @RequestParam(name="product_name") String name,
                                    @RequestParam(name="product_price") int price) {

        if (productService.getProductById(id) != null) {
            productService.updateProduct(new Product(id, name, price));
        }
        else {
            productService.addNewProduct(id, name, price);
        }

        return "redirect:/";
    }
}
