package lk.ijse.absd.jsms.service.impl;

import lk.ijse.absd.jsms.dto.UserDTO;
import lk.ijse.absd.jsms.entity.User;
import lk.ijse.absd.jsms.repository.UserRepo;
import lk.ijse.absd.jsms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public boolean canAuthenticate(UserDTO userDTO) {
        if (!userRepo.existsById(userDTO.getUserName())) {
            return false;
        } else {
            User user = userRepo.findById(userDTO.getUserName()).get();
            return user.getPassword().equals(userDTO.getPassword());
        }
    }
}
