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
                    return false;
                }
            }
        }
        for (int j =0 ; j<col; j++){
            if (edificio[floor][j]==null){
                edificio[floor][j] = new Computer (serialNumber, floor, j);
                return true;
            }
        }
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

    public void getComputerList() {

    }

}
