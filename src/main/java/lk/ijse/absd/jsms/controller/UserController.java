package lk.ijse.absd.jsms.controller;

import lk.ijse.absd.jsms.dto.UserDTO;
import lk.ijse.absd.jsms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean logIn(@RequestBody UserDTO userDTO) {
        return userService.canAuthenticate(userDTO);
    }
}
