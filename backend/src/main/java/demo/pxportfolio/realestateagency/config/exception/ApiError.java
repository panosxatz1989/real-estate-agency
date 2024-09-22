package demo.pxportfolio.realestateagency.config.exception;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiError {

    private Integer status;
    private LocalDateTime timestamp;
    private ErrorType errorType;
    private String message;
    private List<String> fieldErrors;
}
