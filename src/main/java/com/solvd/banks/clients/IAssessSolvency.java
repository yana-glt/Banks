package main.java.com.solvd.banks.clients;

import main.java.com.solvd.banks.exception_handlers.IncorrectValueException;
import main.java.com.solvd.banks.exception_handlers.WrongValueTypeException;

public interface IAssessSolvency {

	boolean assessSolvency() throws WrongValueTypeException, IncorrectValueException;

}
