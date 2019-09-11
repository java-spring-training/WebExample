package example.repository;

import example.configuration.ApiPathConfig;
import example.domain.ProductRepository;
import example.domain.entities.object.Products;
import example.exception.ProductApiErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private ApiPathConfig apiPathConfig;
    private ProductFactory productFactory;

    @Autowired
    public ProductRepositoryImpl(ApiPathConfig apiPathConfig, ProductFactory productFactory) {
        this.apiPathConfig = apiPathConfig;
        this.productFactory = productFactory;
    }

    @Override
    public List<Products> getAll() throws ProductApiErrorException {

        // trong package repository có chứa 2 loai object để gọi resttemplate
        // 1. object response của api
        // 2. object request của api
        // ---> ví dụ này đang làm theo dạng 1

        RestTemplate restTemplate = new RestTemplate();

        String apiUrl = UriComponentsBuilder
                .fromHttpUrl(apiPathConfig.getHost())
                .port(apiPathConfig.getPort())
                .path(apiPathConfig.getName())
                .build().encode().toString();

        try {
            ResponseEntity<ProductResponse> response = restTemplate.getForEntity(apiUrl, ProductResponse.class);

            if (response.getBody() == null || response.getStatusCodeValue() != HttpStatus.OK.value()) {
                throw new ProductApiErrorException("Call API Error");
            }

            // factory thành domain và gửi về service
            return productFactory.toListProduct(response.getBody().getResults());

        } catch (HttpStatusCodeException ex) {
            throw new ProductApiErrorException("Call API Error");
        }

    }

    // Cần tham khảo tài liệu để biêt thêm các gọi restemplate như sau:
    // 1. getForEntity() -> dùng để gọi các api get
    // 2. exchange() -> dùng được cho tất cả các loại api, nhưng tốt nhất nên dùng exchange() cho các api làm thay đổi dữ liệu DB
    // 3. getForObject() -> dùng để call api mà chỉ cần nhận object response mà ko cần các thông tin khác như là http status, ...

    // Ngoài ra đối với các api mà cần truyền param vào header hoặc request body thì phài add vào entity của restemplate
    // tham khảo code mẫu trong ví dụ
}

