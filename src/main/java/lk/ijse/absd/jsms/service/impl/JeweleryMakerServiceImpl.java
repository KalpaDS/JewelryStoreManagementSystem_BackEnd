package lk.ijse.absd.jsms.service.impl;

import lk.ijse.absd.jsms.dto.JeweleryMakerDTO;
import lk.ijse.absd.jsms.entity.JeweleryMaker;
import lk.ijse.absd.jsms.repository.JeweleryMakerRepo;
import lk.ijse.absd.jsms.service.JeweleryMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class JeweleryMakerServiceImpl implements JeweleryMakerService {
    @Autowired
    private JeweleryMakerRepo jewelryMakerRepository;

    @Override
    public boolean saveJeweleryMaker(JeweleryMakerDTO dto) {
        JeweleryMaker jewelryMaker = new JeweleryMaker();
        jewelryMaker.setJewMName(dto.getJewMName());
        jewelryMaker.setContactNo(dto.getContactNo());
        jewelryMakerRepository.save(jewelryMaker);
        return true;
    }

    @Override
    public ArrayList<JeweleryMakerDTO> getAllJeweleryMaker() {
        List<JeweleryMaker> jewelryMakers = jewelryMakerRepository.findAll();
        ArrayList<JeweleryMakerDTO> jewelryMakerDtos = new ArrayList<>();

        for (JeweleryMaker jewelryMaker : jewelryMakers) {
            jewelryMakerDtos.add(new JeweleryMakerDTO(jewelryMaker.getJewMId(), jewelryMaker.getJewMName(),
                    jewelryMaker.getContactNo()));
        }
        return jewelryMakerDtos;
    }

    @Override
    public boolean deleteJeweleryMaker(int id) {
        jewelryMakerRepository.deleteById(id);
        return true;
    }

    @Override
    public int getJeweleryMakersCount() {
        return jewelryMakerRepository.getMakersCount();
    }
}
