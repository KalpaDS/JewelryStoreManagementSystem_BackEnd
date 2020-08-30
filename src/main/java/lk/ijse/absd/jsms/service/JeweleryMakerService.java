package lk.ijse.absd.jsms.service;

import lk.ijse.absd.jsms.dto.JeweleryMakerDTO;

import java.util.ArrayList;

public interface JeweleryMakerService {
    boolean saveJeweleryMaker(JeweleryMakerDTO dto);

    ArrayList<JeweleryMakerDTO> getAllJeweleryMaker();

    boolean deleteJeweleryMaker(int id);

    int getJeweleryMakersCount();
}
