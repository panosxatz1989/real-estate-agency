package demo.pxportfolio.realestateagency.misc.attachment;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AttachmentDto {

    private Long id;
    private String contentType;
    private String extension;
    private String path;
    private String originalFilename;
    private String filename;
    private Integer fileSize;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime uploadedAt;
}
