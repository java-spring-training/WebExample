package example.configuration;

/**
 * class này để chứa các entry path của web
 */
public class WebPathConfig {

    // ngăn chặn việc khởi tạo
    private WebPathConfig() {}

    public static final String LIST_PRODUCT_PAGE = "/products";
    public static final String ADD_PRODUCT_PAGE = "/add";
    public static final String CONFIRM_PRODUCT_PAGE = "/add/confirm";
    public static final String BACK = "/back";
}
