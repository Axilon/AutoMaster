package ru.bk.rom4ik2103.shoppingCartPuck;


import javax.persistence.*;

@Entity
@Table(name = "shoppingCarts")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    private String userLogin;
    private long productId;


    public ShoppingCart() {
    }

    public ShoppingCart(String userLogin, long productId) {
        this.userLogin = userLogin;
        this.productId = productId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}

