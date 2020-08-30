package lk.ijse.absd.jsms.service.impl;

import lk.ijse.absd.jsms.dto.GemDTO;
import lk.ijse.absd.jsms.entity.Gem;
import lk.ijse.absd.jsms.repository.GemRepo;
import lk.ijse.absd.jsms.service.GemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class GemServiceImpl implements GemService {
    @Autowired
    private GemRepo gemRepo;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveGem(GemDTO dto) {
        Gem gem = new Gem();
        gem.setCarat(dto.getCarat());
        gem.setWeight(dto.getWeight());
        gem.setGemType(dto.getGemType());
        gem.setAddedDate(dto.getAddedDate());
        gemRepo.save(gem);
        return true;
    }

    @Override
    public ArrayList<GemDTO> getAllGems() {
        List<Gem> gems = gemRepo.getGemByGivenDate(null);
        ArrayList<GemDTO> gemDtos = new ArrayList<>();

        for (Gem gem : gems) {
            gemDtos.add(new GemDTO(gem.getGemId(), gem.getGemType(), gem.getCarat(), gem.getWeight(), gem.getAddedDate(), gem.getGivenDate()));
        }
        return gemDtos;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteGem(int id) {
        gemRepo.deleteById(id);
        return true;
    }

    @Override
    public int getGemCount() {
        return gemRepo.getGemCount();
    }
}
