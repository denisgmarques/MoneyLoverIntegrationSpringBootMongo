package br.com.denisgmarques.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by denis on 20/02/2016.
 */
@Getter
@Setter
@Document(collection="transactions")
public final class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Transaction(Integer id, String name, Double amount, Integer type, Date created_time, Date displayed_date,
			Category category) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.type = type;
		this.created_time = created_time;
		this.displayed_date = displayed_date;
		this.category = category;
	}

	public void update(TransactionDTO transaction) {
        this.setName(transaction.getName());
        this.setAmount(transaction.getAmount());
        this.setType(transaction.getType());
        this.setCreated_time(transaction.getCreated_time());
        this.setDisplayed_date(transaction.getDisplayed_date());
        this.setCategory(transaction.getCategory());
	}
	
	public TransactionDTO convertToDTO() {
        TransactionDTO dto = new TransactionDTO();
        
        dto.setId(this.getId());
        dto.setName(this.getName());
        dto.setAmount(this.getAmount());
        dto.setType(this.getType());
        dto.setCreated_time(this.getCreated_time());
        dto.setDisplayed_date(this.getDisplayed_date());
        dto.setCategory(this.getCategory());	
        
        return dto;
	}
	
	public Transaction() {}

	@Id
    private Integer id;
    private String name;
    private Double amount;
    private Integer type = 2;
    private Date created_time;
    private Date displayed_date;
    
    @DBRef
    private Category category;

}
