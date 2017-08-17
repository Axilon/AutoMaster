package ru.bk.rom4ik2103.productPuck;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Entity
@Table(name = "product_list")
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")

    private  long id;
    private String name;
    @OneToMany (mappedBy = "productType", cascade = CascadeType.ALL)
    private List<Product> productList =  new ArrayList<>() ;

    private  String picture;

    public ProductType(String name, String picture) {

        this.name = name;
        this.picture = picture;
    }

    public ProductType() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}

