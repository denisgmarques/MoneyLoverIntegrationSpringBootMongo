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

import br.com.denisgmarques.model.TransactionDTO;
import br.com.denisgmarques.service.TransactionService;
 
@RestController
@RequestMapping("/api/transaction")
final class TransactionController {
 
    private final TransactionService service;
 
    @Autowired
    TransactionController(TransactionService service) {
        this.service = service;
    }
 
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    TransactionDTO create(@RequestBody @Valid TransactionDTO TransactionEntry) {
        return service.create(TransactionEntry);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    TransactionDTO delete(@PathVariable("id") Integer id) {
        return service.delete(id);
    }
 
    @RequestMapping(method = RequestMethod.GET)
    List<TransactionDTO> findAll() {
        return service.findAll();
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    TransactionDTO findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    TransactionDTO update(@RequestBody @Valid TransactionDTO TransactionEntry) {
        return service.update(TransactionEntry);
    }
 
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTransactionNotFound(RuntimeException ex) {
    }
}
