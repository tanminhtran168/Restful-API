package com.hust.baseweb.entities.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Double price;

    private Integer quantity;

    private String image;

    private String introduction;

    private Boolean deleted;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "brand_id")
    private BrandEntity brand;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
}
