package lk.ijse.absd.jsms.repository;

import lk.ijse.absd.jsms.entity.JeweleryMaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JeweleryMakerRepo extends JpaRepository<JeweleryMaker, Integer> {
    @Query("SELECT count(j.jewMId) FROM JeweleryMaker j")
    int getMakersCount();
}
