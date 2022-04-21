package exceptions;

public class InexchangeableSpacesException extends RuntimeException {
    public InexchangeableSpacesException() {
        String message = "Spaces are inexchahgeable";
        throw new Error(message);
    }

}
