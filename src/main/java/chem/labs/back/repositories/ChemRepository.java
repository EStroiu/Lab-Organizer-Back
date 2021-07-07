package chem.labs.back.repositories;

import chem.labs.back.model.ChemCompound;
import chem.labs.back.model.Equipment;
import chem.labs.back.model.Lab;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Chemical repository.
 * Gets all Chemical entities, can be filtered by type
 * */

@Repository
public interface ChemRepository extends CrudRepository<ChemCompound, Long> {

    @Override
    List<ChemCompound> findAll();

    List<ChemCompound> findAllByChemicalType(String chemicalType);

}
