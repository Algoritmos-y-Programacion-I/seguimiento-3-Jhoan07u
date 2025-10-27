package model;
import java.util.ArrayList;

public class Computer {
    private String serialnumber;
    private Boolean nextWindow;
    private int floor;
    private int column;
    private ArrayList<Incident> incidents;

    public Computer (String serialnumber, int floor, int column){
        this.serialnumber = serialnumber;
        this.floor = floor;
        this.column = column;
        this.incidents = new ArrayList<Incident>();
        
    }
    public String getSerialnumber() {
        return serialnumber;
    } 
    public int getFloor() {
        return floor;
    }
    public int getColumn() {
        return column;
    }



    
    /**
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * El siguiente metodo esta incompleto.
     * Agregue los parametros y retorno que sean pertinentes.
     * Agregue la logica necesaria.
     */
    public void addIncident(Incident i) {
        incidents.add(i);

    }
    public int getIncidentCount() {
        return incidents.size();
    }

}
