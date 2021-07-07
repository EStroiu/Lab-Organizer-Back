package chem.labs.back.controllers;

import chem.labs.back.model.ChemCompound;
import chem.labs.back.services.ChemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Chemical controller.
 * The methods are categorized by RESTful API requests.
 * */

@RestController
@RequestMapping("/chemicals")
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class ChemController {

    private final ChemService chemService;

    public ChemController(ChemService chemService) {
        this.chemService = chemService;
    }

    /**
     * GET
     * */

    @GetMapping
    public List<ChemCompound> getAllChemicals(@RequestParam(required = false) String chemicalType){
        return this.chemService.getAllChemicals(chemicalType);
    }

    @GetMapping("/{id}")
    public ChemCompound getOneChemical(@PathVariable Long id){
        ChemCompound foundChemical = this.chemService.getOneChemical(id);

        if(foundChemical == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Chemical with id " + id + " was not found!");
        }

        return foundChemical;
    }

    /**
     * PUT
     * */

    @PutMapping(path = "/{id}", consumes = {"application/json"})
    public ChemCompound updateChemical(@PathVariable Long id, @RequestBody ChemCompound chemical){

        if(!id.equals(chemical.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You should not change IDs!");
        }

        return this.chemService.updateChemical(chemical);
    }

    /**
     * DELETE
     * */

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteChemical(@PathVariable Long id){
        ChemCompound chemical = getOneChemical(id);

        this.chemService.deleteChemical(chemical);
    }

}
