package lk.ijse.absd.jsms.controller;

import lk.ijse.absd.jsms.dto.GemDTO;
import lk.ijse.absd.jsms.service.GemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/gems")
public class GemController {

    @Autowired
    private GemService gemService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveGem(@RequestBody GemDTO gemDTO) {
        return gemService.saveGem(gemDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<GemDTO> getAllGem() {
        return gemService.getAllGems();
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteGem(@PathVariable("id") int gemId) {
        return gemService.deleteGem(gemId);
    }

    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public int getGemCount() {
        return gemService.getGemCount();
    }
}
