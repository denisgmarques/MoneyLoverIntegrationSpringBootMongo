package br.com.denisgmarques.service;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.denisgmarques.model.Category;
import br.com.denisgmarques.model.CategoryDTO;
import br.com.denisgmarques.persistence.CategoryRepository;

@Service
public final class MongoDBCategoryService implements CategoryService {
    private final CategoryRepository repository;
    
    @Autowired
    MongoDBCategoryService(CategoryRepository repository) {
        this.repository = repository;
    }
    
    
    @Override
    public CategoryDTO create(CategoryDTO category) {
        Category persisted = new Category(category.getId(), category.getName(), category.getIcon(), category.getType(), category.getGroupId(), category.getUserId());
        persisted = repository.save(persisted);
        return convertToDTO(persisted);
    }
 
    @Override
    public CategoryDTO delete(Integer id) {
        Category deleted = findCategoryById(id);
        repository.delete(deleted);
        return convertToDTO(deleted);
    }
 
    @Override
    public List<CategoryDTO> findAll() {
        List<Category> CategoryEntries = repository.findAll();
        return convertToDTOs(CategoryEntries);
    }
 
    private List<CategoryDTO> convertToDTOs(List<Category> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }
 
    @Override
    public CategoryDTO findById(Integer id) {
        Category found = findCategoryById(id);
        return convertToDTO(found);
    }
 
    @Override
    public CategoryDTO update(CategoryDTO category) {
        Category updated = findCategoryById(category.getId());
        updated.update(category);
        updated = repository.save(updated);
        return convertToDTO(updated);
    }
 
    private Category findCategoryById(Integer id) {
        Optional<Category> result = repository.findOne(id);
        return result.orElseThrow(() -> new RuntimeException(id.toString()));
 
    }
 
    private CategoryDTO convertToDTO(Category model) {
        return model.convertToDTO();
    }

}
