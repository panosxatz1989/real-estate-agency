package demo.pxportfolio.realestateagency.config.exception;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String clazz, String property, String value) {
        super(clazz + " with " + property + ": " + value + " not found.");
    }

    public EntityNotFoundException(String clazz, String value) {
        this(clazz, "id", value);
    }
}
