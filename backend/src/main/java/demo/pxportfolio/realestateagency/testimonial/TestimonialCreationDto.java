package demo.pxportfolio.realestateagency.testimonial;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TestimonialCreationDto {

    @Size(max = 500, message = "{app.messages.validation.testimonial.text.size}")
    private String text;

    @NotNull(message = "{app.messages.validation.testimonial.rating.not-null}")
    @Min(value = 0, message = "{app.messages.validation.testimonial.rating.size}")
    @Max(value = 5, message = "{app.messages.validation.testimonial.rating.size}")
    private Integer rating;

    @NotNull(message = "{app.messages.validation.testimonial.author.not-null}")
    private Long authorId;

    private Boolean isApproved;
}