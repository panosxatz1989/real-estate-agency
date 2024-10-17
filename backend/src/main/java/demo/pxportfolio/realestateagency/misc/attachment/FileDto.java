package demo.pxportfolio.realestateagency.misc.attachment;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FileDto {

    @NotNull
    private AttachmentDto attachmentDto;

    @NotNull
    private MultipartFile file;
}
