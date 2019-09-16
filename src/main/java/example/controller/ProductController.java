package example.controller;

import example.configuration.WebPathConfig;
import example.domain.entities.object.Products;
import example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
        // factory từ domain object ra object để add attribute vào model và show lên màn hình
        // hoặc có thể add domain object vào model để show ra màn hình luôn nếu cảm thấy không cần thiết factory

        List<Products> products = service.getAll();
        model.addAttribute("products", products);

        return "products";
    }

    @GetMapping(WebPathConfig.ADD_PRODUCT_PAGE)
    public String addProduct(ProductForm productForm) {

        // hiển thị màn hình add
        return "add";
    }

    @PostMapping(WebPathConfig.CONFIRM_PRODUCT_PAGE)
    public String confirmProduct(ProductForm productForm) {

        // hiển thị màn hình confirm
        return "confirm";
    }

    @PostMapping(WebPathConfig.BACK)
    public String backProduct(ProductForm productForm) {

        // back về màn hình add
        return "add";
    }
}
