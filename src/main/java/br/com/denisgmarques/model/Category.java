package br.com.denisgmarques.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by denis on 20/02/2016.
 */
@Getter
@Setter
@Document(collection="categories")
public final class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	public Category(Integer id, String name, String icon, Integer type, Integer groupId, Integer userId) {
		super();
		this.id = id;
		this.name = name;
		this.icon = icon;
		this.type = type;
		this.groupId = groupId;
		this.userId = userId;
	}

	public Category() {}
	
	@Id
    private Integer id;
    private String name;
    private String icon;
    private Integer type = 0;
    private Integer groupId = 0;
    private Integer userId = 0;

    public void update(CategoryDTO category) {
        this.setGroupId(category.getGroupId());
        this.setIcon(category.getIcon());
        this.setName(category.getName());
        this.setType(category.getType());
        this.setUserId(category.getUserId());
    }
    
    public CategoryDTO convertToDTO() {
    	CategoryDTO dto = new CategoryDTO();
    	 
        dto.setId(this.getId());
        
        dto.setId(this.getId());
  		dto.setName(this.getName());
        dto.setIcon(this.getIcon());
        dto.setType(this.getType());
        dto.setGroupId(this.getGroupId());
        dto.setUserId(this.getUserId());
        
        return dto;
    }
    
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", icon=" + icon + ", type=" + type + ", groupId=" + groupId
				+ ", userId=" + userId + "]";
	}
}
