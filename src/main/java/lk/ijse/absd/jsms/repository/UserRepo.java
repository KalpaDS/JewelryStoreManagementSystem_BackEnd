package lk.ijse.absd.jsms.repository;

import lk.ijse.absd.jsms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
}
