package lk.ijse.absd.jsms.repository;

import lk.ijse.absd.jsms.entity.Metal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MetalRepo extends JpaRepository<Metal, Integer> {
    @Query("SELECT count (m.metalId) from Metal m")
    int getMetalCount();
}
