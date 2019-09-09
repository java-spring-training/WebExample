package example.domain.value.object;

import org.glassfish.jersey.internal.guava.Preconditions;

public class CategoryId {

    int id;

    public CategoryId(int id) {

        // business he thong yêu cầu Check id phải > 0
        Preconditions.checkArgument(id > 0, "id must be > 0");

        this.id = id;
    }

    public int getId() {
        return id;
    }
}
