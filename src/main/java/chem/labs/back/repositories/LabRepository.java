package chem.labs.back.repositories;

import chem.labs.back.model.ChemCompound;
import chem.labs.back.model.Equipment;
import chem.labs.back.model.Lab;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Lab repository.
 * Gets all Lab entities, can be filtered by location
 * */

@Repository
public interface LabRepository extends CrudRepository<Lab, Long> {

    @Override
    List<Lab> findAll();

    List<Lab> findAllByLabLocation(String labLocation);

}
