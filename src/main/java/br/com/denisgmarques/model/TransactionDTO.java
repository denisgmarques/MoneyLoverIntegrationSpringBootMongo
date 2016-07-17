package br.com.denisgmarques.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by denis on 26/05/2016.
 */
@Getter
@Setter
public final class TransactionDTO {
    private Integer id;
    private String name;
    private Double amount;
    private Integer type = 2;
    private Date created_time;
    private Date displayed_date;
    private Category category;

    @Override
	public String toString() {
		return "TransactionDTO [id=" + id + ", name=" + name + ", amount=" + amount + ", type=" + type
				+ ", created_time=" + created_time + ", displayed_date=" + displayed_date + ", category=" + category
				+ "]";
	}
}
