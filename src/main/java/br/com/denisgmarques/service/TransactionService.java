package br.com.denisgmarques.service;

import java.util.List;

import br.com.denisgmarques.model.TransactionDTO;

public interface TransactionService {

	TransactionDTO create(TransactionDTO transaction);
 
	TransactionDTO delete(Integer id);
 
    List<TransactionDTO> findAll();
 
    TransactionDTO findById(Integer id);
 
    TransactionDTO update(TransactionDTO transaction);
}
