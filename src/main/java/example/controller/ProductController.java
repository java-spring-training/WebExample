package example.controller;

import example.config.ApiPathConfig;
import example.domain.entities.object.Products;
import example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    private ProductService service;
    private ApiPathConfig apiPathConfig;

    @Autowired
    public ProductController(ProductService service, ApiPathConfig apiPathConfig) {
        this.service = service;
        this.apiPathConfig = apiPathConfig;
    }

    @GetMapping("/products")
    public Products listAllProduct() {

        String name = apiPathConfig.getName();

        return null;
    }
}
