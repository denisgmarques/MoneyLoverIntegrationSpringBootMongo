package br.com.denisgmarques.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.denisgmarques.model.CategoryDTO;
import br.com.denisgmarques.service.CategoryService;
 
@RestController
@RequestMapping("/api/category")
final class CategoryController {
 
    private final CategoryService service;
 
    @Autowired
    CategoryController(CategoryService service) {
        this.service = service;
    }
 
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    CategoryDTO create(@RequestBody @Valid CategoryDTO CategoryEntry) {
        return service.create(CategoryEntry);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    CategoryDTO delete(@PathVariable("id") Integer id) {
        return service.delete(id);
    }
 
    @RequestMapping(method = RequestMethod.GET)
    List<CategoryDTO> findAll() {
        return service.findAll();
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    CategoryDTO findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    CategoryDTO update(@RequestBody @Valid CategoryDTO CategoryEntry) {
        return service.update(CategoryEntry);
    }
 
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleCategoryNotFound(RuntimeException ex) {
    }
}
