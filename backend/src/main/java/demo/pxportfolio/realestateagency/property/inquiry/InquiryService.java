package demo.pxportfolio.realestateagency.property.inquiry;

import demo.pxportfolio.realestateagency.auth.user.User;
import demo.pxportfolio.realestateagency.auth.user.UserService;
import demo.pxportfolio.realestateagency.config.exception.EntityNotFoundException;
import demo.pxportfolio.realestateagency.config.exception.InquiryDeleteException;
import demo.pxportfolio.realestateagency.property.PropertyService;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InquiryService {

    private final UserService userService;
    private final PropertyService propertyService;
    private final InquiryRepository inquiryRepository;
    private static final String ENTITY_CLASS = Inquiry.class.getSimpleName();

    public Inquiry getInquiryById(Long id) {
        return inquiryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ENTITY_CLASS, id.toString()));
    }

    public Page<Inquiry> getAllInquiries(Pageable pageable) {
        return inquiryRepository.findAll(pageable);
    }

    public Page<Inquiry> getAllInquiriesByUserId(Long userId, Pageable pageable) {
        return inquiryRepository.findAllByUserId(userId, pageable);
    }

    public Inquiry createInquiry(InquiryRequestDto dto) {
        Inquiry inquiry = Inquiry.builder()
                .user(userService.getUserById(dto.getUserId()))
                .property(propertyService.getPropertyById(dto.getPropertyId()))
                .message(dto.getMessage())
                .creationDate(LocalDateTime.now())
                .answer(null)
                .active(true)
                .build();

        return inquiry;
    }

    // We should also check if the user can delete the specific inquiry
    public void deleteInquiryById(Long id, User user) {

        // Fetch the inquiry
        Inquiry existingInquiry = this.getInquiryById(id);

        // If it is the agent that controls the property
        if (user.getId() == existingInquiry.getProperty().getAgent().getUser().getId()) {

        }

        // If it is not the user that submitted the inquiry
        if (!Objects.equals(user.getId(), existingInquiry.getUser().getId())) {
            throw new InquiryDeleteException();
        }

        // Set inquiry as inactive
        existingInquiry.setActive(false);
        inquiryRepository.save(existingInquiry);
    }

}
