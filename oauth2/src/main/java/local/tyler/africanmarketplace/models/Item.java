package local.tyler.africanmarketplace.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long itemid;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnoreProperties("items")
    private User user;

    public Item(){}

    public Item(String location, String name, String description, double price, User user) {
        this.location = location;
        this.name = name;
        this.description = description;
        this.price = price;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getItemid() {
        return itemid;
    }

    public void setItemid(long itemid) {
        this.itemid = itemid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}