package ru.alexandergolovnya.domain.entity.sales;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Product {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id", nullable = false, unique = true, columnDefinition = "int")
	private int id;

	@Column
	private String name;

	@Column(length = 4096)
	private String description;

	@Column
	private String photo;

    @Column
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;

	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;

	@CreationTimestamp
	private Date createTime;

	@UpdateTimestamp
	private Date updateTime;
}
