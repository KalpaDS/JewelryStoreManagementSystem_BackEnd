package lk.ijse.absd.jsms.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
public class JeweleryMakingOrder {
    @Id
    @GeneratedValue
    private int jewMDId;
    private Date givenDate;

    @ManyToOne
    private Metal metal;

    @ManyToOne
    private Gem gem;

    @ManyToOne
    private JeweleryMaker jeweleryMaker;

    private double givenMetalWeight;

    public JeweleryMakingOrder() {
    }

    public JeweleryMakingOrder(Date givenDate, Metal metal, Gem gem, JeweleryMaker jeweleryMaker, double givenMetalWeight) {
        this.givenDate = givenDate;
        this.metal = metal;
        this.gem = gem;
        this.jeweleryMaker = jeweleryMaker;
        this.givenMetalWeight = givenMetalWeight;
    }
}
