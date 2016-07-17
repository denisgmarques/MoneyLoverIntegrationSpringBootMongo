package br.com.denisgmarques.service;

import java.util.List;

import br.com.denisgmarques.model.CategoryDTO;

public interface CategoryService {

    CategoryDTO create(CategoryDTO category);
 
    CategoryDTO delete(Integer id);
 
    List<CategoryDTO> findAll();
 
    CategoryDTO findById(Integer id);
 
    CategoryDTO update(CategoryDTO category);
}
