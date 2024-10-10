package com.tns.placementservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlacementController {

    @Autowired
    private PlacementService placementService;

    @GetMapping("/placement")
    public List<Placement> getAllPlacements() {
        return placementService.getAllPlacements();
    }

    @GetMapping("/placement/{id}")
    public ResponseEntity<Placement> getPlacementById(@PathVariable Long id) {
        return placementService.getPlacementById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/placement")
    public Placement createPlacement(@RequestBody Placement placement) {
        return placementService.savePlacement(placement);
    }

    @PutMapping("/placement/{id}")
    public ResponseEntity<Placement> updatePlacement(@PathVariable Long id, @RequestBody Placement updatedPlacement) {
        return placementService.getPlacementById(id)
                .map(placement -> {
                    placement.setCompanyName(updatedPlacement.getCompanyName());
                    placement.setPosition(updatedPlacement.getPosition());
                    placement.setLocation(updatedPlacement.getLocation());
                    placement.setSalaryPackage(updatedPlacement.getSalaryPackage());
                    placement.setDriveDate(updatedPlacement.getDriveDate());
                    return ResponseEntity.ok(placementService.savePlacement(placement));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/placement/{id}")
    public ResponseEntity<Object> deletePlacement(@PathVariable Long id) {
        return placementService.getPlacementById(id)
                .map(placement -> {
                    placementService.deletePlacement(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
