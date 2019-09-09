package example.domain.entities.object;

import example.domain.value.object.CategoryId;
import org.glassfish.jersey.internal.guava.Preconditions;
import org.springframework.util.StringUtils;

public class Category {

    private CategoryId id;
    private String name;

    public Category(CategoryId id, String name) {

        Preconditions.checkArgument(StringUtils.hasText(name), "name must be not null");

        this.id = id;
        this.name = name;
    }
}
