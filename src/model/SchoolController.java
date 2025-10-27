package model;

public class SchoolController {
    private String name;
    private int hourSpentSupport;
    final private int floors = 5;
    private final int col = 10;
    private final int HOURMAXSUPPORT = 100;
    private Computer[][] edificio;
    




    public SchoolController(){
        edificio = new Computer[5][10];
        hourSpentSupport = 0;
        


    }
    public boolean agregarComputador(String serialNumber,int floor){
        if (floor < 0 || floor >= floors) {
            System.out.println("Piso inválido.");
            return false;
        }
        for (int i = 0; i<floors; i++){
            for (int j = 0; j<col; j++){
                if (edificio[i][j] != null && edificio[i][j].getSerialnumber().equals(serialNumber)){
                    System.out.println("Ya existe un computador con ese serial.");
                    return false;
                }
            }
        }
        for (int j =0 ; j<col; j++){
            if (edificio[floor][j]==null){
                edificio[floor][j] = new Computer (serialNumber, floor, j);
                System.out.println("Computador agregado en piso " + floor + ", columna " + j);
                return true;
            }
        }
        System.out.println("No hay espacio disponible en el piso " + floor);
        return false;
    }
    



    public boolean agregarIncidenteEnComputador(String serial, Incident inc) {
        for (int i=0; i<floors ; i ++){
            for (int j=0; j<col; j++){
                if (edificio[i][j]!=null && edificio[i][j].getSerialnumber().equals(serial)){
                    edificio[i][j].addIncident(inc);
                    return true;
                }

            }
        }
        return false;

    }
    public Computer consultarComputadorConMasIncidentes() {
        Computer topComputer = null;
        int maxIncidents = -1;
        for (int i =0; i<floors; i++){
            for (int j=0;j<col; j++){
                if (edificio[i][j]!=null){
                    int count = edificio[i][j].getIncidentCount();
                    if (count > maxIncidents){
                        maxIncidents = count;
                        topComputer = edificio[i][j];
                    }
                }
            }
        }

       

        return topComputer;
    }

    public void getComputerList() {

    }

}
