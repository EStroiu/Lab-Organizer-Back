package chem.labs.back.controllers;

import chem.labs.back.model.ChemCompound;
import chem.labs.back.model.Equipment;
import chem.labs.back.services.EquipmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Equipment controller.
 * The methods are categorized by RESTful API requests.
 * */

@RestController
@RequestMapping("/equipment")
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    /**
     * GET
     * */

    @GetMapping
    public List<Equipment> getAllEquipment(){
        return this.equipmentService.getAllEquipment();
    }

    @GetMapping("/{id}")
    public Equipment getOneEquipment(@PathVariable Long id){
        Equipment foundEquipment = this.equipmentService.getOneEquipment(id);

        if(foundEquipment == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The piece of equipment with id " + id + " was not found!");
        }

        return foundEquipment;
    }

    /**
     * PUT
     * */

    @PutMapping(path = "/{id}", consumes = {"application/json"})
    public Equipment updateEquipment(@PathVariable Long id, @RequestBody Equipment equipment){

        if(!id.equals(equipment.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You should not change IDs!");
        }

        return this.equipmentService.updateEquipment(equipment);

    }

    /**
     * DELETE
     * */

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEquipment(@PathVariable Long id){
        Equipment equipment = getOneEquipment(id);

        this.equipmentService.deleteEquipment(equipment);
    }
}
