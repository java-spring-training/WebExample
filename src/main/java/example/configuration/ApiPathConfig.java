package example.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Class này để đọc thông tin của các API cần gọi
 * Các thông tin này được set ở applicaiton.yml
 */

@Configuration
@ConfigurationProperties("api.product")
public class ApiPathConfig {

    private String host;
    private String port;
    private String name;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
