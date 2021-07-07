package chem.labs.back.controllers;

import chem.labs.back.model.ChemCompound;
import chem.labs.back.model.Equipment;
import chem.labs.back.model.Lab;
import chem.labs.back.services.ChemService;
import chem.labs.back.services.EquipmentService;
import chem.labs.back.services.LabService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Lab controller.
 * The methods are categorized by RESTful API requests.
 * */

@RestController
@RequestMapping("/labs")
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class LabController {

    private final LabService labService;
    private final ChemService chemService;
    private final EquipmentService equipmentService;

    public LabController(LabService labService, ChemService chemService, EquipmentService equipmentService) {
        this.labService = labService;
        this.chemService = chemService;
        this.equipmentService = equipmentService;
    }

    /**
     * GET
     */
    @GetMapping
    public List<Lab> getAllLabs(@RequestParam(required = false) String labLocation) {
        return this.labService.getAllLabs(labLocation);
    }

    @GetMapping("/{id}")
    public Lab getOneLab(@PathVariable Long id) {
        Lab foundLab = this.labService.getOneLab(id);

        if (foundLab == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lab with id " + id + " was not found!");
        }

        return foundLab;
    }

    @GetMapping("/{id}/chemicals")
    public List<ChemCompound> getChemicalsByLab(@PathVariable Long id) {
        Lab foundLab = getOneLab(id);

        return foundLab.getChemicals();
    }

    @GetMapping("{id}/equipment")
    public List<Equipment> getEquipmentByLab(@PathVariable Long id) {
        Lab foundLab = getOneLab(id);

        return foundLab.getEquipment();
    }

    /**
     * POST
     * */

    @PostMapping(consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public Lab addNewLab(@RequestBody Lab lab){
        return this.labService.addNewLab(lab);
    }


    @PostMapping(path = "/{id}/chemicals", consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public ChemCompound addNewChemicalToLab(@PathVariable Long id, @RequestBody ChemCompound chemical){
        Lab lab = getOneLab(id);

        return this.chemService.addChemicalToLab(lab,chemical);
    }

    @PostMapping(path = "/{id}/equipment", consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public Equipment addNewEquipmentToLab(@PathVariable Long id, @RequestBody Equipment equipment){
        Lab lab = getOneLab(id);

        return this.equipmentService.addEquipmentToLab(lab,equipment);
    }

    /**
     * PUT
     * */

    @PutMapping(path = "/{id}", consumes = {"application/json"})
    public Lab updateLab(@PathVariable Long id, @RequestBody Lab lab){
        if(!id.equals(lab.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You should not change IDs!");
        }

        Lab foundLab = getOneLab(id);

        return this.labService.updateLab(lab);
    }

    /**
     * DELETE
     * */

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLab(@PathVariable Long id){
        Lab lab = getOneLab(id);

        this.labService.deleteLab(lab);
    }
}
