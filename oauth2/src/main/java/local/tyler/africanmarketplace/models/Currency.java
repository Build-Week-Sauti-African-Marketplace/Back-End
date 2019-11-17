package local.tyler.africanmarketplace.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "currencies")
@JsonIgnoreProperties("item")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long currencyid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String symbol;

    @ManyToOne
    @JoinColumn(name = "itemid", nullable = false)
    @JsonIgnoreProperties({"currencies", "user"})
    private Item item;

    public Currency(){}

    public Currency(String name, String code, String symbol, Item item) {
        this.name = name;
        this.code = code;
        this.symbol = symbol;
        this.item = item;
    }

    public long getCurrencyid() {
        return currencyid;
    }

    public void setCurrencyid(long currencyid) {
        this.currencyid = currencyid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
