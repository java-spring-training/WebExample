package example.domain.value.object;

import org.glassfish.jersey.internal.guava.Preconditions;
import org.springframework.util.StringUtils;

public class ProductCode {

    String value;

    public ProductCode(String value) {

        // business he thong yêu cầu Check productCode Not Null
        Preconditions.checkArgument(StringUtils.hasText(value), "productCode must be not null");

        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
