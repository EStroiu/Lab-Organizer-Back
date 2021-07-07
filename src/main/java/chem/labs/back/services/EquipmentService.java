package chem.labs.back.services;

//import chem.labs.back.LabDataProvider;
import chem.labs.back.model.ChemCompound;
import chem.labs.back.model.Equipment;
import chem.labs.back.model.Lab;
import chem.labs.back.repositories.EquipmentRepository;
import chem.labs.back.repositories.LabRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * EquipmentService performs specific actions that are called by the controller.
 * It also access EquipmentRepository and LabRepository.
 * */


@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final LabRepository labRepository;

    public EquipmentService(EquipmentRepository equipmentRepository, LabRepository labRepository) {
        this.equipmentRepository = equipmentRepository;
        this.labRepository = labRepository;
    }

    public boolean equipmentExists(Long id){
        return this.equipmentRepository.existsById(id);
    }

    public Equipment addEquipmentToLab(Lab lab, Equipment equipment) {
        equipment = this.equipmentRepository.save(equipment);
        lab.addEquipment(equipment);
        this.labRepository.save(lab);
        return equipment;
    }

    public List<Equipment> getAllEquipment() {
        return this.equipmentRepository.findAll();
    }

    public Equipment getOneEquipment(Long id) {
        Optional<Equipment> optionalEquipment = this.equipmentRepository.findById(id);

        return optionalEquipment.orElse(null);
    }

    public Equipment updateEquipment(Equipment equipment) {
        return this.equipmentRepository.save(equipment);
    }

    public void deleteEquipment(Equipment equipment) {
        this.equipmentRepository.delete(equipment);
    }

    public void deleteEquipmentById(Long id) {
        this.equipmentRepository.deleteById(id);
    }
}
