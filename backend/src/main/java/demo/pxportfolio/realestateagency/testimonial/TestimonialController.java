package demo.pxportfolio.realestateagency.testimonial;

import jakarta.validation.Valid;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/v1/testimonials")
@RequiredArgsConstructor
public class TestimonialController {

    private final TestimonialService testimonialService;

    @GetMapping
    public Page<Testimonial> getAllTestimonials(@RequestParam Integer page, @RequestParam Integer size, Pageable pageable) {
        Pageable pagination = PageRequest.of(page, size, pageable.getSort());
        return testimonialService.getAllTestimonials(pagination);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('testimonial:create')")
    public ResponseEntity<Testimonial> createTestimonial(@Valid @RequestBody TestimonialCreationDto dto) {
        Testimonial createdTestimonial = testimonialService.createTestimonial(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdTestimonial.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdTestimonial);
    }
}