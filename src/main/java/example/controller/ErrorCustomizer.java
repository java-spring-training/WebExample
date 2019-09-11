package example.controller;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


/**
 * Class này để customize lại các lỗi mà chưa có trong WebExceptionHandler.java
 * Nếu WebExceptionHandler.java đã có xử lý cho các lỗi này rồi thì nó sẽ ko vào ErrorCustomizer nữa
 *
 * VD: lỗi INTERNAL_SERVER_ERROR 500, vì bên WebExceptionHandler.java đã có định nghĩa rồi nên nó sẽ không vào ErrorCustomizer
 * mà mặc định nó sẽ xử lý ở WebExceptionHandler.java trước
 *
 * Nếu ví dụ lỗi INTERNAL_SERVER_ERROR chưa có trong WebExceptionHandler.java thì nó sẽ vào ErrorCustomizer và nhận được path là /500
 * sau đó nó tìm controller có request là /500 để vào xử lý tiếp
 * theo code hiện tại thì nó output ra message "Customizer SYSTEM ERROR"
 */

/**
 * Ý nghĩa thứ 2 của class này còn có tác dụng check việc submit sai url (khi sai url thì hệ thống quăng ra status 404)
 * khi nhập sai url thì sẽ chưa vào được controller -> khi đó ErrorCustomizer sẽ bắt status 404 (HttpStatus.NOT_FOUND)
 * và đá về path là /404
 * sau đó tương tự như trên nó sẽ vào controller có request mapping là "/404" để xử lý tiếp
 * -> đây là cách giải quyết vấn đề nhập sai url cua màn hình
 *
 * VD code hiện tại để access vào màn hình list thì nhập url: "http://localhost:9090/products"
 * nếu nhập sai sẽ ko vào được controller : http://localhost:9090/wrongurl -> vào ErrorCustomizer để xử lý theo HttpStatus.NOT_FOUND
 */
@Component
public class ErrorCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
        factory.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500"));
    }
}
