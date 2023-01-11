package main.java.com.solvd.banks.exception_handlers;

public class FileIsEmptyException extends Exception {
    private String fileOrDirectoryName;
    public FileIsEmptyException(String mess, String fileOrDirectoryName) {
        super(mess);
        this.fileOrDirectoryName = fileOrDirectoryName;
    }

    public String getFileOrDirectoryName() {
        return fileOrDirectoryName;
    }
}
