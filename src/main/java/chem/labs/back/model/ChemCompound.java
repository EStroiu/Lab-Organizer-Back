package chem.labs.back.model;

import javax.persistence.*;

/**
 * Chemical entity.
 * ID - unique identifier created by the database
 * */

@Entity
public class ChemCompound {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String chemicalName;

    @Column
    private String chemicalFormula;

    @Column
    private String chemicalType;

    @Column
    private int chemicalQuantity;

    public Long getId() {
        return id;
    }

    public String getChemicalName() {
        return chemicalName;
    }

    public String getChemicalFormula() {
        return chemicalFormula;
    }

    public String getChemicalType() {
        return chemicalType;
    }

    public int getChemicalQuantity() {
        return chemicalQuantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setChemicalName(String name) {
        this.chemicalName = name;
    }

    public void setChemicalFormula(String formula) {
        this.chemicalFormula = formula;
    }

    public void setChemicalType(String type) {
        this.chemicalType = type;
    }

    public void setChemicalQuantity(int quantity) {
        this.chemicalQuantity = quantity;
    }
}
