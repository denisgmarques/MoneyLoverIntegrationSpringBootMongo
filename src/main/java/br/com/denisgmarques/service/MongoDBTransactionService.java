package br.com.denisgmarques.service;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.denisgmarques.model.Transaction;
import br.com.denisgmarques.model.TransactionDTO;
import br.com.denisgmarques.persistence.TransactionRepository;

@Service
public final class MongoDBTransactionService implements TransactionService {
    private final TransactionRepository repository;
    
    @Autowired
    MongoDBTransactionService(TransactionRepository repository) {
        this.repository = repository;
    }
    
    
    @Override
    public TransactionDTO create(TransactionDTO transaction) {
        Transaction persisted = new Transaction(transaction.getId(), transaction.getName(), transaction.getAmount(), transaction.getType(),
        										transaction.getCreated_time(), transaction.getDisplayed_date(), transaction.getCategory());
        persisted = repository.save(persisted);
        return convertToDTO(persisted);
    }
 
    @Override
    public TransactionDTO delete(Integer id) {
        Transaction deleted = findTransactionById(id);
        repository.delete(deleted);
        return convertToDTO(deleted);
    }
 
    @Override
    public List<TransactionDTO> findAll() {
        List<Transaction> TransactionEntries = repository.findAll();
        return convertToDTOs(TransactionEntries);
    }
 
    private List<TransactionDTO> convertToDTOs(List<Transaction> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }
 
    @Override
    public TransactionDTO findById(Integer id) {
        Transaction found = findTransactionById(id);
        return convertToDTO(found);
    }
 
    @Override
    public TransactionDTO update(TransactionDTO transaction) {
        Transaction updated = findTransactionById(transaction.getId());

        updated.update(transaction);
        updated = repository.save(updated);
        return convertToDTO(updated);
    }
 
    private Transaction findTransactionById(Integer id) {
        Optional<Transaction> result = repository.findOne(id);
        return result.orElseThrow(() -> new RuntimeException(id.toString()));
 
    }
 
    private TransactionDTO convertToDTO(Transaction model) {
        return model.convertToDTO();
    }

}
