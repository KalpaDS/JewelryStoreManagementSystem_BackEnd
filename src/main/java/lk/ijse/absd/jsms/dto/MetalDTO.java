package lk.ijse.absd.jsms.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MetalDTO {
    private int metalId;
    private String metalType;
    private int carat;
    private double weight;
    private Date addedDate;

    public MetalDTO() {
    }

    public MetalDTO(int metalId, String metalType, int carat, double weight, Date addedDate) {
        this.metalId = metalId;
        this.metalType = metalType;
        this.carat = carat;
        this.weight = weight;
        this.addedDate = addedDate;
    }
}
