package example.service;

import example.domain.ProductRepository;
import example.domain.entities.object.Products;
import example.exception.ProductApiErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Products> getAll() throws ProductApiErrorException {

        return repository.getAll();
    }
}
