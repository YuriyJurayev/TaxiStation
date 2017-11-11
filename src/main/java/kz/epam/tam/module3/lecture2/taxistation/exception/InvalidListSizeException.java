package kz.epam.tam.module3.lecture2.taxistation.exception;

public class InvalidListSizeException extends Exception {

    private Integer cause = 0;

    public InvalidListSizeException(String message){
        super(message);
    }
    public InvalidListSizeException(String message,Integer cause){
        super(message);
        this.cause = cause;
    }

    public Integer getExceptionCause() {
        return cause;
    }
}
