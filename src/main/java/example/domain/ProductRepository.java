package example.domain;

import example.domain.entities.object.Products;

import java.util.List;

public interface ProductRepository {

    List<Products> getAll();
}
