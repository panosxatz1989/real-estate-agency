package demo.pxportfolio.realestateagency.misc.attachment;

import demo.pxportfolio.realestateagency.auth.user.User;
import jakarta.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/v1/attachments")
@RequiredArgsConstructor
public class AttachmentController {

    private final AttachmentService attachmentService;

    @GetMapping("/{id}")
    public AttachmentDto getAttachmentById(@PathVariable Long id) {
        return attachmentService.getAttachmentDtoById(id);
    }

    @GetMapping(value = "/{id}/download", produces = APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity downloadAttachment(@PathVariable Long id) throws FileNotFoundException {
        AttachmentDto attachmentDto = attachmentService.getAttachmentDtoById(id);

        InputStreamResource resource = new InputStreamResource(new FileInputStream(attachmentDto.getPath()));
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("content-disposition", "inline;filename=" + attachmentDto.getOriginalFilename());
        httpHeaders.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        return ResponseEntity.ok()
                .headers(httpHeaders)
                .contentLength(attachmentDto.getFileSize())
                .contentType(MediaType.valueOf(attachmentDto.getContentType()))
                .body(resource);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AttachmentDto> upload(@Valid @RequestBody MultipartFile file, @AuthenticationPrincipal User user) {
        AttachmentDto createdFile = attachmentService.createAttachment(file, user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdFile.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdFile);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteAttachmentById(@PathVariable Long id) {
        attachmentService.deleteAttachmentById(id);
        return ResponseEntity.noContent().build();
    }
}