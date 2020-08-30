package lk.ijse.absd.jsms.service;

import lk.ijse.absd.jsms.dto.JeweleryMakingOrderDTO;

import java.util.ArrayList;

public interface JeweleryMakingOrderService {
    boolean placeOrder(JeweleryMakingOrderDTO jeweleryMakingOrderDTO);

    ArrayList<JeweleryMakingOrderDTO> getAllOrders();

    int getOrdersCount();
}
