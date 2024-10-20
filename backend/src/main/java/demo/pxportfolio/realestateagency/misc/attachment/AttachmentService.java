package demo.pxportfolio.realestateagency.misc.attachment;

import demo.pxportfolio.realestateagency.config.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttachmentService {

    private final ModelMapper modelMapper;
    private final AttachmentRepository attachmentRepository;
    private static final String ENTITY_CLASS = Attachment.class.getSimpleName();

    public Attachment getAttachmentById(Long id) {
        return attachmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ENTITY_CLASS, id.toString()));
    }

    public AttachmentDto createAttachment(AttachmentDto dto) {
        Attachment newAttachment = modelMapper.map(dto, Attachment.class);
        return modelMapper.map(attachmentRepository.save(newAttachment), AttachmentDto.class);
    }

    public void deleteAttachmentById(Long id) {
        attachmentRepository.deleteById(id);
    }
}
