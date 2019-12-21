package pl.wiktor.shop.shopadministration.exception;

public class InvalidCategoryNameException extends AbstractCategoryException {
    public InvalidCategoryNameException() {
        super("Invalid category name");
    }
}
