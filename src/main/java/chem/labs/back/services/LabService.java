package chem.labs.back.services;

import chem.labs.back.model.Lab;
import chem.labs.back.repositories.LabRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * LabService performs specific actions that are called by the controller.
 * It also access labRepository.
 * */


@Service
public class LabService {

    public final LabRepository labRepository;

    public LabService(LabRepository labRepository) {
        this.labRepository = labRepository;
    }

    public boolean labExists(Long id){
        return this.labRepository.existsById(id);
    }

    public List<Lab> getAllLabs(String labLocation) {
        if(labLocation == null){
            return this.labRepository.findAll();
        }

        return this.labRepository.findAllByLabLocation(labLocation);
    }

    public Lab getOneLab(Long id) {
        Optional<Lab> optionalLab = this.labRepository.findById(id);

        return optionalLab.orElse(null);
    }

    public Lab addNewLab(Lab lab) {
        return this.labRepository.save(lab);
    }

    public Lab updateLab(Lab lab) {
        return this.labRepository.save(lab);
    }

    public void deleteLab(Lab lab) {
        this.labRepository.delete(lab);
    }
}
