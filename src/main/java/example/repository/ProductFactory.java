package example.repository;

import example.domain.entities.object.Products;
import example.domain.value.object.ProductCode;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductFactory {

    /**
     *
     * Factory ra domain object
     */
    public List<Products> toListProduct (List<ProductResult> productResultList) {

        return productResultList.stream().map(this::toProduct).collect(Collectors.toList());
    }

    private Products toProduct(ProductResult productResult) {

        ProductCode productCode = new ProductCode(productResult.getProductCode());

        return new Products(productCode, productResult.getProductName());
    }

}
