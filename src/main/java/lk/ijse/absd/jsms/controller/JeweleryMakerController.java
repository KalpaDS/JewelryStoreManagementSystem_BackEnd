package lk.ijse.absd.jsms.controller;

import lk.ijse.absd.jsms.dto.JeweleryMakerDTO;
import lk.ijse.absd.jsms.service.JeweleryMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/makers")
public class JeweleryMakerController {
    @Autowired
    private JeweleryMakerService jewelryMakerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveJewelryMaker(@RequestBody JeweleryMakerDTO jewelryMaker) {
        return jewelryMakerService.saveJeweleryMaker(jewelryMaker);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<JeweleryMakerDTO> getAllJewelryMaker() {
        return jewelryMakerService.getAllJeweleryMaker();
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteJewelryMaker(@PathVariable("id") int jewelryMakerId) {
        return jewelryMakerService.deleteJeweleryMaker(jewelryMakerId);
    }

    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public int getJewelryMakersCount() {
        return jewelryMakerService.getJeweleryMakersCount();
    }
}
