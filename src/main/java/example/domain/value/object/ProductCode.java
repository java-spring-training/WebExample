package example.domain.value.object;

import org.glassfish.jersey.internal.guava.Preconditions;
import org.springframework.util.StringUtils;

public class ProductCode {

    String productCode;

    public ProductCode(String productCode) {

        // business he thong yêu cầu Check productCode Not Null
        Preconditions.checkArgument(StringUtils.hasText(productCode), "productCode must be not null");

        this.productCode = productCode;
    }

    public String getProductCode() {
        return productCode;
    }
}
