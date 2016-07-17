package br.com.denisgmarques.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import br.com.denisgmarques.model.Category;

public interface CategoryRepository extends Repository<Category, Integer> {
 
    void delete(Category deleted);
 
    List<Category> findAll();
 
    Optional<Category> findOne(Integer id);
 
    Category save(Category saved);
}

