package chem.labs.back.model;
import javax.persistence.*;

/**
 * Equipment entity.
 * ID - unique identifier created by the database
 * */

@Entity
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String equipmentName;

    @Column
    private int equipmentQuantity;

    public Long getId() {
        return id;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public int getEquipmentQuantity() {
        return equipmentQuantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEquipmentName(String name) {
        this.equipmentName = name;
    }

    public void setEquipmentQuantity(int quantity) {
        this.equipmentQuantity = quantity;
    }
}
