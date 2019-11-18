package local.tyler.africanmarketplace.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "currencies")
@JsonIgnoreProperties("item")
public class Currency {

    @Column(nullable = false)
    private String name;

    @Id
    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String symbol;

    @Column(nullable = false)
    private double valueInUSD;

    @OneToMany(mappedBy = "currency", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("currencies")
    private List<Item> items = new ArrayList<>();

    public Currency(){}

    public Currency(String name, String code, String symbol, List<Item> items) {
        this.name = name;
        this.code = code;
        this.symbol = symbol;
        this.items = items;
    }

    public Currency(String name, String code, String symbol) {
        this.name = name;
        this.code = code;
        this.symbol = symbol;
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getValueInUSD() {
        return valueInUSD;
    }

    public void setValueInUSD(double valueInUSD) {
        this.valueInUSD = valueInUSD;
    }
}
