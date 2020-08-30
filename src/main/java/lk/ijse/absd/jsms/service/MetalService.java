package lk.ijse.absd.jsms.service;

import lk.ijse.absd.jsms.dto.MetalDTO;
import lk.ijse.absd.jsms.dto.UpdateMetalDTO;

import java.util.ArrayList;

public interface MetalService {
    boolean saveMetal(MetalDTO dto);

    ArrayList<MetalDTO> getAllMetals();

    boolean deleteMetal(int id);

    boolean updateMetal(UpdateMetalDTO dto);

    int getMetalsCount();
}
