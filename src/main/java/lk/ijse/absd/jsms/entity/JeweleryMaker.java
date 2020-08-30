package lk.ijse.absd.jsms.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class JeweleryMaker {
    @Id
    @GeneratedValue
    private int jewMId;
    private String jewMName;
    private int contactNo;

    @OneToMany(mappedBy = "jeweleryMaker", cascade = CascadeType.ALL)
    private List<JeweleryMakingOrder> makingOrders = new ArrayList<>();

    public JeweleryMaker() {
    }

    public JeweleryMaker(String jewMName, int contactNo) {
        this.jewMName = jewMName;
        this.contactNo = contactNo;
    }

    public JeweleryMaker(int jewMId, String jewMName, int contactNo) {
        this.jewMId = jewMId;
        this.jewMName = jewMName;
        this.contactNo = contactNo;
    }
}
