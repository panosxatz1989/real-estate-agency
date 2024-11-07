package demo.pxportfolio.realestateagency.testimonial;

import demo.pxportfolio.realestateagency.auth.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestimonialService {

    private final UserService userService;
    private final TestimonialRepository testimonialRepository;

    public Page<Testimonial> getAllTestimonials(Pageable pageable) {
        return testimonialRepository.findByIsApprovedTrue(pageable);
    }

    public Testimonial createTestimonial(TestimonialCreationDto dto) {
        Testimonial createdTestimonial = Testimonial.builder()
                .text(dto.getText())
                .author(userService.getUserById(dto.getAuthorId()))
                .isApproved(dto.getIsApproved())
                .build();
        return testimonialRepository.save(createdTestimonial);
    }
}