package demo.pxportfolio.realestateagency.property.inquiry;

import demo.pxportfolio.realestateagency.auth.user.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/v1/inquiries")
@RequiredArgsConstructor
public class InquiryController {

    private final InquiryService inquiryService;

    @GetMapping("/{id}")
    public Inquiry getInquiryById(@PathVariable Long id) {
        return inquiryService.getInquiryById(id);
    }

    @GetMapping
    public Page<Inquiry> getAllInquiries(Pageable pageable) {
        return inquiryService.getAllInquiries(pageable);
    }

    @GetMapping("/user/{userId}")
    public Page<Inquiry> getAllInquiriesByUserId(@PathVariable Long userId, Pageable pageable) {
        return inquiryService.getAllInquiriesByUserId(userId, pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Inquiry> createInquiry(@Valid @RequestBody InquiryRequestDto dto, HttpServletRequest request) {
        Inquiry createdInquiry = inquiryService.createInquiry(dto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdInquiry.getId())
                .toUri();

        return ResponseEntity.created(location).body(createdInquiry);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('listing_inquiry_delete')")
    public ResponseEntity<Void> deleteInquiryById(@PathVariable Long id, @AuthenticationPrincipal User user) {
        inquiryService.deleteInquiryById(id, user);
        return ResponseEntity.noContent().build();
    }
}
