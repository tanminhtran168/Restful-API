package com.hust.baseweb.entities.data;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bill")
public class Bill implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "id", nullable = false)
private Integer id;

@Column(name = "created")
@Temporal(TemporalType.DATE)
private Date created;

@Column(name = "customer")
private String customer;

@Column(name = "phone")
private Integer phone;

@Column(name = "email")
private String email;

@Column(name = "address")
private String address;

@Column(name = "total_money")
private Double totalMoney;

@Column(name = "deleted")
private Boolean deleted;

}
