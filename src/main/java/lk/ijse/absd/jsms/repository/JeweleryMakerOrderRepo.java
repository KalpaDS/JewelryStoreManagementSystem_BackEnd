package lk.ijse.absd.jsms.repository;

import lk.ijse.absd.jsms.entity.JeweleryMakingOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JeweleryMakerOrderRepo extends JpaRepository<JeweleryMakingOrder, Integer> {
    @Query("SELECT count(o.jewMDId) FROM JeweleryMakingOrder o")
    int getOrdersCount();
}
