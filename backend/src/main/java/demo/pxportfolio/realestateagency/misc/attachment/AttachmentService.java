package demo.pxportfolio.realestateagency.misc.attachment;

import demo.pxportfolio.realestateagency.auth.user.User;
import demo.pxportfolio.realestateagency.config.exception.AttachmentCreationException;
import demo.pxportfolio.realestateagency.config.exception.EntityNotFoundException;
import demo.pxportfolio.realestateagency.misc.util.FileUtil;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class AttachmentService {

    private final ModelMapper modelMapper;
    private final FileUtil fileUtil;
    private final AttachmentRepository attachmentRepository;
    private static final String ENTITY_CLASS = Attachment.class.getSimpleName();

    public Attachment getAttachmentById(Long id) {
        return attachmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ENTITY_CLASS, id.toString()));
    }

    public AttachmentDto getAttachmentDtoById(Long id) {
        return modelMapper.map(this.getAttachmentById(id), AttachmentDto.class);
    }

    public AttachmentDto createAttachment(MultipartFile file, User user) {

        // Flag for creation in disk
        boolean created;

        // Current date and time for multiple uses
        LocalDateTime uploadedAt = LocalDateTime.now();

        // Create the file and save it to file system
        String originalFileName = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString();

        // Path here
        String path = fileUtil.createPath(uploadedAt, originalFileName, fileName);
//
//        String path = String.join("/", BASE_PATH, year, month, day, fileName);
//        path += "." + fileUtil.getFileExtension(originalFileName);

        File newFile = new File(path);
        try {
            Files.createDirectories(Paths.get(path));
            file.transferTo(newFile);
            created = newFile.exists();
        } catch (IOException ignored) {
            // newFile.delete();
            throw new AttachmentCreationException(ignored.getMessage());
        }

        // If it is not created we bail
        if (!created) {
            throw new AttachmentCreationException();
        }

        // Get the content type
        String contentType = file.getContentType();

        // And the file size
        long fileSize = file.getSize();

        // Create the attachment
        Attachment attachment = Attachment.builder()
                .path(path)
                .contentType(contentType)
                .filename(fileName)
                .originalFilename(originalFileName)
                .fileSize(fileSize)
                .uploadedAt(uploadedAt)
                .uploadedBy(user)
                .build();

        // Then save it to the database and return it
        return modelMapper.map(attachmentRepository.save(attachment), AttachmentDto.class);
    }

    public void deleteAttachmentById(Long id) {
        attachmentRepository.deleteById(id);
    }
}
