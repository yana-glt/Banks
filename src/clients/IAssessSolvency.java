package clients;

import exception_handlers.IncorrectValueException;
import exception_handlers.WrongValueTypeException;

public interface IAssessSolvency {

    boolean assessSolvency() throws WrongValueTypeException, IncorrectValueException;

}
