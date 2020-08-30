package lk.ijse.absd.jsms.service.impl;

import lk.ijse.absd.jsms.dto.MetalDTO;
import lk.ijse.absd.jsms.dto.UpdateMetalDTO;
import lk.ijse.absd.jsms.entity.Metal;
import lk.ijse.absd.jsms.repository.MetalRepo;
import lk.ijse.absd.jsms.service.MetalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MetalServiceImpl implements MetalService {
    @Autowired
    private MetalRepo metalRepo;

    @Override
    public boolean saveMetal(MetalDTO dto) {
        Metal metal = new Metal();
        metal.setMetalType(dto.getMetalType());
        metal.setCarat(dto.getCarat());
        metal.setWeight(dto.getWeight());
        metal.setAddedDate(dto.getAddedDate());
        metalRepo.save(metal);
        return true;
    }

    @Override
    public ArrayList<MetalDTO> getAllMetals() {
        List<Metal> metals = metalRepo.findAll();
        ArrayList<MetalDTO> metalDtos = new ArrayList<>();

        for (Metal metal : metals) {
            metalDtos.add(new MetalDTO(metal.getMetalId(), metal.getMetalType(), metal.getCarat(), metal.getWeight(),
                    metal.getAddedDate()));
        }
        return metalDtos;
    }

    @Override
    public boolean deleteMetal(int id) {
        metalRepo.deleteById(id);
        return true;
    }

    @Override
    public boolean updateMetal(UpdateMetalDTO dto) {
        Metal metal = metalRepo.findById(dto.getMetalId()).get();
        metal.setWeight((metal.getWeight() + dto.getUpdatedWeight()));
        metalRepo.save(metal);
        return true;
    }

    @Override
    public int getMetalsCount() {
        return metalRepo.getMetalCount();
    }
}
