package model;
import java.time.LocalDate;

public class Incident {

    private LocalDate report;
    private String description;
    private boolean solution;
    private int solutionHours;

    public Incident(LocalDate report,String description ){
        this.report = report;
        this.description = description;
    }
    

    

    
}
