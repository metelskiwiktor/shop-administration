package pl.wiktor.shop.shopadministration.exception;

public class InvalidTagException extends RuntimeException {
    public InvalidTagException() {
        super("Invalid tag name");
    }
}
