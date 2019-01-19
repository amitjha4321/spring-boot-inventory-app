package com.product.productmodel;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Data
@Entity
@Table(name = "productmodel")
public class ProductModel {
    @Id
    private int pid;
    private String name;
    private String type;
    private String brand;
    private Date date;
}
