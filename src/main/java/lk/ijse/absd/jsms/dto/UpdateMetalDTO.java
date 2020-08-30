package lk.ijse.absd.jsms.dto;

import lombok.Data;

@Data
public class UpdateMetalDTO {
    private int metalId;
    private double updatedWeight;

    public UpdateMetalDTO() {
    }

    public UpdateMetalDTO(int metalId, double updatedWeight) {
        this.metalId = metalId;
        this.updatedWeight = updatedWeight;
    }
}
