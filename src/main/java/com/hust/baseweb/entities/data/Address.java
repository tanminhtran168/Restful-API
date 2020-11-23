package com.hust.baseweb.entities.data;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "address")
@Data
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "street")
    private String street;

    @Column(name = "district")
    private String district;

    @Column(name = "province")
    private String province;

    @Column(name = "deleted")
    private Boolean deleted;

    @OneToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
