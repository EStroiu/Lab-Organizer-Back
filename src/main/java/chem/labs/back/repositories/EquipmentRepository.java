package chem.labs.back.repositories;

import chem.labs.back.model.ChemCompound;
import chem.labs.back.model.Equipment;
import chem.labs.back.model.Lab;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Equipment repository.
 * Gets all Equipment entities
 * */

@Repository
public interface EquipmentRepository extends CrudRepository<Equipment, Long> {

    @Override
    List<Equipment> findAll();

}
