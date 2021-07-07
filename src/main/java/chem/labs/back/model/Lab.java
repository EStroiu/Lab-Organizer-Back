package chem.labs.back.model;

import javax.persistence.*;
import java.util.List;

/**
 * Lab entity.
 * ID - unique identifier created by the database
 * On-to-many relationships with Chemical and Equipment entities
 * */

@Entity
public class Lab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String labName;

    @Column
    private String labLocation;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
    private List<ChemCompound> chemicals;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
    private List<Equipment> equipment;

    public Long getId() {
        return id;
    }

    public String getLabName() {
        return labName;
    }

    public String getLabLocation() {
        return labLocation;
    }

    public List<ChemCompound> getChemicals() {
        return chemicals;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void addChemical(ChemCompound chem){
        this.chemicals.add(chem);
    }

    public void addEquipment(Equipment eq){
        this.equipment.add(eq);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLabName(String name) {
        this.labName = name;
    }

    public void setLabLocation(String location) {
        this.labLocation = location;
    }
}
