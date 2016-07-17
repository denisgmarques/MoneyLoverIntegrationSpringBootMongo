package br.com.denisgmarques.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import br.com.denisgmarques.model.Transaction;

public interface TransactionRepository extends Repository<Transaction, Integer> {
 
    void delete(Transaction deleted);
 
    List<Transaction> findAll();
 
    Optional<Transaction> findOne(Integer id);
 
    Transaction save(Transaction saved);
}

