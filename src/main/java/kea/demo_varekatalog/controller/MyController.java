package kea.demo_varekatalog.controller;

import kea.demo_varekatalog.models.Product;
import kea.demo_varekatalog.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class MyController {

    private ProductService productService = new ProductService();
    private ArrayList<Product> products = new ArrayList<>();
    private HttpSession session;



    @GetMapping("/")
    public String indexPage(){
        return "index";
    }

    @GetMapping("/product_page")
    public String showProductPage(Model model, HttpServletRequest request){
        //session = request.getSession();
        model.addAttribute("product_list", productService.getProducts());
        //session.setAttribute("product_list_session", productHandler.getProducts());


        return "product_page";
    }

    @GetMapping("/create_product")
    public String createProductPage(){

        return "create_product";
    }

    @GetMapping("/update_product_page")
    public String updateProjectPage(Model model){
        model.addAttribute("product", productService.getProducts());

        return "update_product_page";
    }

    @PostMapping("/update_product_info")
    public String updateProductInfo(@RequestParam(name="prod_id") int id,
                                    @RequestParam(name="product_name") String name,
                                    @RequestParam(name="product_price") int price) {


      //  String formerProduct_name = productHandler.getProducts().get(id-1).getProduct_name();

        System.out.println(name);

        if (productService.getProductById(id) != null) {
            productService.updateProduct(
                    new Product(productService.getProductByName(name).getName(),
                            productService.getProductByIdAndPrice(id, price).getPrice()));
        }
        else {
            productService.addNewProduct(name, price);
        }

        return "redirect:/product_page";
    }
}
