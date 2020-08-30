package lk.ijse.absd.jsms.dto;

import lombok.Data;

import java.util.Date;

@Data
public class GemDTO {
    private int gemId;
    private String gemType;
    private int carat;
    private double weight;
    private Date addedDate;
    private Date givenDate;

    public GemDTO() {
    }

    public GemDTO(int gemId, String gemType, int carat, double weight, Date addedDate, Date givenDate) {
        this.gemId = gemId;
        this.gemType = gemType;
        this.carat = carat;
        this.weight = weight;
        this.addedDate = addedDate;
        this.givenDate = givenDate;
    }
}

