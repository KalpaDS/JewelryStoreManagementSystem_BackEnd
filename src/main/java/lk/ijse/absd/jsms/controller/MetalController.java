package lk.ijse.absd.jsms.controller;

import lk.ijse.absd.jsms.dto.MetalDTO;
import lk.ijse.absd.jsms.dto.UpdateMetalDTO;
import lk.ijse.absd.jsms.service.MetalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/metals")
public class MetalController {
    @Autowired
    private MetalService metalService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveMetal(@RequestBody MetalDTO metal) {
        return metalService.saveMetal(metal);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteMetal(@PathVariable("id") int metalId) {
        return metalService.deleteMetal(metalId);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateMetal(@RequestBody UpdateMetalDTO metal) {
        return metalService.updateMetal(metal);
    }

    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public int getMetalCount() {
        return metalService.getMetalsCount();
    }
}
