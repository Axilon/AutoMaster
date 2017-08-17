package ru.bk.rom4ik2103.ordersPuck;

import ru.bk.rom4ik2103.productPuck.Product;

import javax.persistence.*;



@Entity
@Table(name = "orders")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    private String name;
    private Double price;
    private String customerName;
    private String customerAddress;
    private String orderStatus;
    private String deliveryType;
    private String customerPhone;

    public Order(Product product, String customerName, String customerAddress, String orderStatus, String customerPhone, String deliveryType) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.orderStatus = orderStatus;
        this.customerPhone = customerPhone;
        this.deliveryType = deliveryType;
    }

    public Order() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String orderType) {
        this.deliveryType = orderType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name : " + name+
                "\nprice : " + price +
                "\nCustomer name : " + customerName+
                "\nCustomer address : "+ customerAddress +
                "\nStatus : "+ orderStatus+"\n");
        return sb.toString();
    }
}
