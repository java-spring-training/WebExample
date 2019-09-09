package example.domain.entities.object;

import example.domain.value.object.ProductCode;
import org.glassfish.jersey.internal.guava.Preconditions;
import org.springframework.util.StringUtils;

public class Products {

    private ProductCode productCode;
    private String productName;

    private Category category;

    public Products(ProductCode productCode, String productName) {

        Preconditions.checkArgument(StringUtils.hasText(productName), "productName must be not null");

        this.productCode = productCode;
        this.productName = productName;
    }

    public Products(ProductCode productCode, String productName, Category category) {
        this.productCode = productCode;
        this.productName = productName;
        this.category = category;
    }

    public ProductCode getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public Category getCategory() {
        return category;
    }
}
