package lk.ijse.absd.jsms.service;

import lk.ijse.absd.jsms.dto.GemDTO;

import java.util.ArrayList;

public interface GemService {
    boolean saveGem(GemDTO dto);

    ArrayList<GemDTO> getAllGems();

    boolean deleteGem(int id);

    int getGemCount();
}
