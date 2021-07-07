//package chem.labs.back;
//
//import chem.labs.back.model.ChemCompound;
//import chem.labs.back.model.Equipment;
//import chem.labs.back.model.Lab;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class LabDataProvider {
//
//    public static List<Lab> labs = new ArrayList<>();
//
//    private static long lastLabId = 0;
//    private static long lastChemId = 0;
//    private static long lastEqId = 0;
//
//    static {
//        Lab l1 = new Lab(lastLabId++,"OrgLab","E");
//        l1.addChemical(new ChemCompound(lastChemId++,"Ethane","C2H6","organic",100));
//        l1.addChemical(new ChemCompound(lastChemId++,"Cyclohexane","C6H12","organic",200));
//        l1.addChemical(new ChemCompound(lastChemId++,"Propene(Propylene)","C3H6","organic",100));
//        l1.addEquipment(new Equipment(lastEqId++,"Gas bottle", 30));
//        labs.add(l1);
//
//        Lab l2 = new Lab(lastLabId++,"InOrgLab","A");
//        l2.addChemical(new ChemCompound(lastChemId++, "Phosphorus pentaoxide","P2O5","inorganic",50));
//        l2.addChemical(new ChemCompound(lastChemId++, "Carbon tetrachloride","CCl3","inorganic",250));
//        l2.addChemical(new ChemCompound(lastChemId++, "Ammonium nitrate","NH4NO3","inorganic",300));
//        l2.addEquipment(new Equipment(lastEqId++,"Beaker", 20));
//        labs.add(l2);
//
//        Lab l3 = new Lab(lastLabId++,"MixedLab","V");
//        l3.addChemical(new ChemCompound(lastChemId++, "Aluminium sulphide","Al2S3","inorganic",400));
//        l3.addChemical(new ChemCompound(lastChemId++, "Glucose","C6H12O6","organic",700));
//        l3.addChemical(new ChemCompound(lastChemId++, "Sodium hydrogen phosphate","Na2HPO4","inorganic",100));
//        l3.addEquipment(new Equipment(lastEqId++,"Graduated cylinder", 50));
//        labs.add(l3);
//    }
//
//
//    public static List<Lab> filterOnLocation(String location) {
//        List<Lab> result = new ArrayList<>();
//
//        for (Lab lab : labs) {
//            if(lab.getLocation().equalsIgnoreCase(location))
//                result.add(lab);
//        }
//
//        return result;
//    }
//
//    public static Lab findOneLab(Long id) {
//
//        for (Lab lab : labs) {
//            if(lab.getId().equals(id))
//                return lab;
//        }
//
//        return null;
//    }
//
//    public static Lab addNewLab(Lab lab) {
//        lab.setId(lastLabId++);
//        labs.add(lab);
//
//        return lab;
//    }
//
//    public static ChemCompound addChemicalToLab(Lab lab, ChemCompound chemical) {
//        chemical.setId(lastChemId++);
//        lab.addChemical(chemical);
//
//        return chemical;
//    }
//
//    public static Equipment addEquipmentToLab(Lab lab, Equipment equipment) {
//        equipment.setId(lastEqId++);
//        lab.addEquipment(equipment);
//
//        return equipment;
//    }
//
//    public static Lab updateLab(Lab toUpdate, Lab lab) {
//        toUpdate.setName(lab.getName());
//        toUpdate.setLocation(lab.getLocation());
//
//        return toUpdate;
//    }
//
//    public static List<ChemCompound> findAllChemicals() {
//        List<ChemCompound> result = new ArrayList<>();
//
//        for (Lab lab : labs) {
//            result.addAll(lab.getChemicals());
//        }
//
//        return result;
//    }
//
//    public static List<Equipment> findAllEquipment() {
//        List<Equipment> result = new ArrayList<>();
//
//        for (Lab lab : labs) {
//            result.addAll(lab.getEquipment());
//        }
//
//        return result;
//    }
//
//    public static List<ChemCompound> filterChemicalsOnType(String type) {
//        List<ChemCompound> result = new ArrayList<>();
//
//        for(ChemCompound chemical: findAllChemicals()){
//            if(chemical.getType().equalsIgnoreCase(type))
//                result.add(chemical);
//        }
//
//        return result;
//    }
//
//    public static ChemCompound findOneChemical(Long id) {
//
//        for (ChemCompound chemical : findAllChemicals()) {
//            if(chemical.getId().equals(id))
//                return chemical;
//        }
//
//        return null;
//    }
//
//    public static Equipment findOneEquipment(Long id) {
//
//        for (Equipment equipment : findAllEquipment()) {
//            if(equipment.getId().equals(id))
//                return equipment;
//        }
//
//        return null;
//    }
//
//    public static ChemCompound updateChemical(ChemCompound toUpdate, ChemCompound chemical) {
//        toUpdate.setName(chemical.getName());
//        toUpdate.setFormula(chemical.getFormula());
//        toUpdate.setType(chemical.getType());
//        toUpdate.setQuantity(chemical.getQuantity());
//
//        return toUpdate;
//    }
//
//    public static Equipment updateEquipment(Equipment toUpdate, Equipment equipment) {
//        toUpdate.setName(equipment.getName());
//        toUpdate.setQuantity(equipment.getQuantity());
//
//        return toUpdate;
//    }
//
//    public static void deleteChemical(ChemCompound chemical) {
//        for (Lab lab : labs) {
//            lab.getChemicals().remove(chemical);
//        }
//    }
//
//    public static void deleteEquipment(Equipment equipment) {
//        for (Lab lab : labs) {
//            lab.getEquipment().remove(equipment);
//        }
//    }
//}
