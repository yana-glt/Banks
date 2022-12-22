package exception_handlers;

public class IncorrectValueException extends Exception {
    private static final long serialVersionUID = 1L;
    private double solvencyAssessment;
    private String clientsName;

    public IncorrectValueException(String mess, String clientsName, double solvencyAssessment) {
        super(mess);
        this.clientsName = clientsName;
        this.solvencyAssessment = solvencyAssessment;
    }

    public double getSolvencyAssessment() {
        return solvencyAssessment;
    }

    public String getClientsName() {
        return clientsName;
    }
}
