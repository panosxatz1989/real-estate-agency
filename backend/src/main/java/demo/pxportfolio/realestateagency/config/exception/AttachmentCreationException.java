package demo.pxportfolio.realestateagency.config.exception;

public class AttachmentCreationException extends RuntimeException {

    public AttachmentCreationException(String message) {
        super(message);
    }

    public AttachmentCreationException() {
        super("Attachment creation failed.");
    }
}
