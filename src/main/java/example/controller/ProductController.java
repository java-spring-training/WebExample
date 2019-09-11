package example.controller;

import example.configuration.WebPathConfig;
import example.domain.entities.object.Products;
import example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping(WebPathConfig.LIST_PRODUCT_PAGE)
    public String listAllProduct(Model model) throws Exception {

        // gọi service nhận về domain
        // factory ra object show ra màn hình
        // hoặc có thể push domain ra màn hình luôn nếu không cần thiết factory


        //return "products";
        throw new Exception("FD");
    }
}
