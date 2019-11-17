package local.tyler.africanmarketplace.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "categories")
@JsonIgnoreProperties("item")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoryid;

    @Column(nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn(name = "itemid", nullable = false)
    @JsonIgnoreProperties({"currencies", "user"})
    private Item item;

    public Category(){}

    public Category(String type, Item item) {
        this.type = type;
        this.item = item;
    }

    public long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(long categoryid) {
        this.categoryid = categoryid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
