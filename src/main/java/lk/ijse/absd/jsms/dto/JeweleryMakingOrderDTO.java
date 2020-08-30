package lk.ijse.absd.jsms.dto;

import lombok.Data;

import java.util.Date;

@Data
public class JeweleryMakingOrderDTO {
    private int jewMDId;
    private Date givenDate;
    private MetalDTO metal;
    private GemDTO gem;
    private JeweleryMakerDTO jewelryMaker;
    private double givenMetalWeight;

    public JeweleryMakingOrderDTO() {
    }

    public JeweleryMakingOrderDTO(int jewMDId, Date givenDate, MetalDTO metal, GemDTO gem, JeweleryMakerDTO jewelryMaker, double givenMetalWeight) {
        this.jewMDId = jewMDId;
        this.givenDate = givenDate;
        this.metal = metal;
        this.gem = gem;
        this.jewelryMaker = jewelryMaker;
        this.givenMetalWeight = givenMetalWeight;
    }
}
