/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenlaboratorio2_joedsosa;

import java.util.ArrayList;
import java.util.List;

public class Granja {
    private List<Conejo> conejoList;
    private List<Vaca> vacaList;
    private List<Vegetal> vegetalList; 
    private int monets;

    public Granja(int monets) {
        this.monets = monets;
        this.conejoList = new ArrayList<Conejo>();
        this.vacaList = new ArrayList<Vaca>();
        this.vegetalList = new ArrayList<Vegetal>();
    }
    
    

    public List<Conejo> getConejoList() {
        return conejoList;
    }

    public void setConejoList(List<Conejo> conejoList) {
        this.conejoList = conejoList;
    }

    public List<Vaca> getVacaList() {
        return vacaList;
    }

    public void setVacaList(List<Vaca> vacaList) {
        this.vacaList = vacaList;
    }

    public List<Vegetal> getVegetalList() {
        return vegetalList;
    }

    public void setVegetalList(List<Vegetal> vegetalList) {
        this.vegetalList = vegetalList;
    }

    public int getMonets() {
        return monets;
    }

    public void setMonets(int monets) {
        this.monets = monets;
    }
    
    public int getSizeListConejos() {
        return conejoList.size();
    }
    
    public int getSizeListVacas() {
        return vacaList.size();
    }
    
    public int getSizeListVegetales() {
        return vegetalList.size();
    }
    
    public String printGranja() {
        return "Tiene "+getSizeListVegetales()+" Vegetales\n"+
               "Tiene "+getSizeListVacas()+" Vacas\n"+
               "Tiene "+getSizeListConejos()+" Conejos\n"+
               "Tiene "+this.monets+" Monets\n";
    }
    
    public String printNombreConejos() {
        String listConejosString="";
        for (Conejo conejo : conejoList) {
            listConejosString+=conejo.getNombre()+"\n";
        }
        return listConejosString;
    }
    
    public String printNombreVacas() {
        String listVacasString="";
        for (Vaca vaca : vacaList) {
            listVacasString+=vaca.getNombre()+"\n";
        }
        return listVacasString;
    }
}
