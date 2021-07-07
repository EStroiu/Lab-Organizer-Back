package chem.labs.back.services;

//import chem.labs.back.LabDataProvider;
import chem.labs.back.model.ChemCompound;
import chem.labs.back.model.Lab;
import chem.labs.back.repositories.ChemRepository;
import chem.labs.back.repositories.LabRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * ChemService performs specific actions that are called by the controller.
 * It also access ChemRepository and LabRepository.
 * */

@Service
public class ChemService {
    public final ChemRepository chemRepository;
    public final LabRepository labRepository;

    public ChemService(ChemRepository chemRepository, LabRepository labRepository) {
        this.chemRepository = chemRepository;
        this.labRepository = labRepository;
    }

    public boolean chemicalExists(Long id){
        return this.chemRepository.existsById(id);
    }

    public ChemCompound addChemicalToLab(Lab lab, ChemCompound chemical) {
        chemical = this.chemRepository.save(chemical);
        lab.addChemical(chemical);
        this.labRepository.save(lab);
        return chemical;
    }

    public List<ChemCompound> getAllChemicals(String chemicalType) {
        if(chemicalType == null){
            return this.chemRepository.findAll();
        }

        return this.chemRepository.findAllByChemicalType(chemicalType);
    }

    public ChemCompound getOneChemical(Long id) {
        Optional<ChemCompound> optionalChem = this.chemRepository.findById(id);

        return optionalChem.orElse(null);
    }

    public ChemCompound updateChemical(ChemCompound chemical) {
        return this.chemRepository.save(chemical);
    }

    public void deleteChemical(ChemCompound chemical) {
        this.chemRepository.delete(chemical);
    }

    public void deleteChemicalById(Long id) {
        this.chemRepository.deleteById(id);
    }
}
