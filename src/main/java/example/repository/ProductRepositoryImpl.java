package example.repository;

import example.domain.ProductRepository;
import example.domain.entities.object.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<Products> getAll() {
        return null;
    }
}

