package lk.ijse.absd.jsms.dto;

import lombok.Data;

@Data
public class JeweleryMakerDTO {
    private int jewMId;
    private String jewMName;
    private int contactNo;

    public JeweleryMakerDTO() {
    }

    public JeweleryMakerDTO(int jewMId, String jewMName, int contactNo) {
        this.jewMId = jewMId;
        this.jewMName = jewMName;
        this.contactNo = contactNo;
    }
}
