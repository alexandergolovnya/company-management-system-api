package ru.alexandergolovnya.domain.entity.sales;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class ProductCategory {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id", nullable = false, unique = true, columnDefinition = "int")
	private int id;

	@Column
	private String name;

	@Column(length = 4096)
	private String description;

	@CreationTimestamp
	private Date createTime;

	@UpdateTimestamp
	private Date updateTime;
}
