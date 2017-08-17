package ru.bk.rom4ik2103.productPuck;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * описать как Entity class
 * и добавить зависимости между
 * товаром и пользователями как
 * many-to-many
 */
@Entity
@Table (name = " product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    private String name;
    private String discription;
    private Double price;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "product_type_id")
    private ProductType productType;

    private  String picture;

    public Product(String name, String discription, Double price) {
        this.name = name;
        this.discription = discription;
        this.price = price;

    }

    public Product(String name, String discription, Double price, ProductType productType, String picture) {
        this.name = name;
        this.discription = discription;
        this.price = price;
        this.productType = productType;
        this.picture = picture;
    }

    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name : " + name+
        "\ndiscription : " + discription+
        "\nprice : " + price +"\n");
        return sb.toString();
    }
}
