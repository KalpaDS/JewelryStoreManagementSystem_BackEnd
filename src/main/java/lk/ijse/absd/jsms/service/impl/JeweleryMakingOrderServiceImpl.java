package lk.ijse.absd.jsms.service.impl;

import lk.ijse.absd.jsms.dto.GemDTO;
import lk.ijse.absd.jsms.dto.JeweleryMakerDTO;
import lk.ijse.absd.jsms.dto.JeweleryMakingOrderDTO;
import lk.ijse.absd.jsms.dto.MetalDTO;
import lk.ijse.absd.jsms.entity.Gem;
import lk.ijse.absd.jsms.entity.JeweleryMaker;
import lk.ijse.absd.jsms.entity.JeweleryMakingOrder;
import lk.ijse.absd.jsms.entity.Metal;
import lk.ijse.absd.jsms.repository.GemRepo;
import lk.ijse.absd.jsms.repository.JeweleryMakerOrderRepo;
import lk.ijse.absd.jsms.repository.JeweleryMakerRepo;
import lk.ijse.absd.jsms.repository.MetalRepo;
import lk.ijse.absd.jsms.service.JeweleryMakingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class JeweleryMakingOrderServiceImpl implements JeweleryMakingOrderService {
    @Autowired
    private JeweleryMakerOrderRepo jewelryMakingOrderRepository;

    @Autowired
    private GemRepo gemRepository;

    @Autowired
    private MetalRepo metalRepository;

    @Autowired
    private JeweleryMakerRepo jewelryMakerRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean placeOrder(JeweleryMakingOrderDTO dto) {
        JeweleryMakingOrder jewelryMakingOrder = new JeweleryMakingOrder();
        jewelryMakingOrder.setGivenDate(dto.getGivenDate());
        jewelryMakingOrder.setGivenMetalWeight(dto.getGivenMetalWeight());

        Gem gem = gemRepository.findById(dto.getGem().getGemId()).get();
        jewelryMakingOrder.setGem(gem);
        gem.setGivenDate(dto.getGivenDate());

        Metal metal = metalRepository.findById(dto.getMetal().getMetalId()).get();
        jewelryMakingOrder.setMetal(metal);
        metal.setWeight((metal.getWeight() - dto.getGivenMetalWeight()));

        JeweleryMaker jewelryMaker = jewelryMakerRepository.findById(dto.getJewelryMaker().getJewMId()).get();
        jewelryMakingOrder.setJeweleryMaker(jewelryMaker);

        jewelryMakingOrderRepository.save(jewelryMakingOrder);
        return true;
    }

    @Override
    public ArrayList<JeweleryMakingOrderDTO> getAllOrders() {
        List<JeweleryMakingOrder> jewelryMakingOrders = jewelryMakingOrderRepository.findAll();
        ArrayList<JeweleryMakingOrderDTO> orderDtos = new ArrayList<>();

        for (JeweleryMakingOrder order : jewelryMakingOrders) {
            orderDtos.add(new JeweleryMakingOrderDTO(
                    order.getJewMDId(),
                    order.getGivenDate(),
                    new MetalDTO(order.getMetal().getMetalId(), order.getMetal().getMetalType(), order.getMetal().getCarat(), order.getMetal().getWeight(), order.getMetal().getAddedDate()),
                    new GemDTO(order.getGem().getGemId(), order.getGem().getGemType(), order.getGem().getCarat(), order.getGem().getWeight(), order.getGem().getAddedDate(), order.getGem().getGivenDate()),
                    new JeweleryMakerDTO(order.getJeweleryMaker().getJewMId(), order.getJeweleryMaker().getJewMName(), order.getJeweleryMaker().getContactNo()),
                    order.getGivenMetalWeight()));
        }
        return orderDtos;
    }

    @Override
    public int getOrdersCount() {
        return jewelryMakingOrderRepository.getOrdersCount();
    }
}
