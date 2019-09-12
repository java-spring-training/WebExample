package example.domain;

import example.domain.entities.object.Products;
import example.exception.ProductApiErrorException;

import java.util.List;

public interface ProductRepository {

    List<Products> getAll() throws ProductApiErrorException;

    void addProduct() throws ProductApiErrorException;
}
