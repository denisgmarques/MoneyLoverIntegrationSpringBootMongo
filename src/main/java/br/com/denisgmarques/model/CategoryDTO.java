package br.com.denisgmarques.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by denis on 26/05/2016.
 */
@Getter
@Setter
public final class CategoryDTO {
	private Integer id;
    private String name;
    private String icon;
    private Integer type = 0;
    private Integer groupId = 0;
    private Integer userId = 0;

    public CategoryDTO() {}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", icon=" + icon + ", type=" + type + ", groupId=" + groupId
				+ ", userId=" + userId + "]";
	}
}
