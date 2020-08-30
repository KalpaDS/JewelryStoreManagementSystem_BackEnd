package lk.ijse.absd.jsms.repository;

import lk.ijse.absd.jsms.entity.Gem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface GemRepo extends JpaRepository<Gem, Integer> {
    List<Gem> getGemByGivenDate(Date givenDate);

    @Query("SELECT count(g.gemId) FROM Gem g where g.givenDate=''")
    int getGemCount();
}
