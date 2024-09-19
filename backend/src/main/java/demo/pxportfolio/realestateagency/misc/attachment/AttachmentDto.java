package demo.pxportfolio.realestateagency.misc.attachment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AttachmentDto {

    private Long id;
    private String contentType;
    private String path;
    private String filename;
    private Integer fileSize;
}
