package lk.ijse.absd.jsms.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Gem {
    @Id
    @GeneratedValue
    private int gemId;
    private String gemType;
    private int carat;
    private double weight;
    private Date addedDate;
    private Date givenDate;

    @OneToMany(mappedBy = "gem", cascade = CascadeType.ALL)
    private List<JeweleryMakingOrder> jeweleryMakingOrders = new ArrayList<>();

    public Gem() {
    }

    public Gem(String gemType, int carat, double weight, Date addedDate, Date givenDate) {
        this.gemType = gemType;
        this.carat = carat;
        this.weight = weight;
        this.addedDate = addedDate;
        this.givenDate = givenDate;
    }
}
