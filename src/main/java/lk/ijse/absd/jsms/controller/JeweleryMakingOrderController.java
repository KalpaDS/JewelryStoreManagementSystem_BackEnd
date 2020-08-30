package lk.ijse.absd.jsms.controller;

import lk.ijse.absd.jsms.dto.JeweleryMakingOrderDTO;
import lk.ijse.absd.jsms.service.JeweleryMakingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/orders")
public class JeweleryMakingOrderController {
    @Autowired
    private JeweleryMakingOrderService jewelryMakingOrderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveJewelryMakingOrder(@RequestBody JeweleryMakingOrderDTO jewelryMakingOrderDto) {
        return jewelryMakingOrderService.placeOrder(jewelryMakingOrderDto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<JeweleryMakingOrderDTO> getAllJewelryMakingOrders() {
        return jewelryMakingOrderService.getAllOrders();
    }

    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public int getJewelryMakingOrdersCount() {
        return jewelryMakingOrderService.getOrdersCount();
    }
}
