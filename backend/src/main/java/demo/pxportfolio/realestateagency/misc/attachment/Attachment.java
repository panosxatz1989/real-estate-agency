package demo.pxportfolio.realestateagency.misc.attachment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(
        name = "attachments",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "attachment_path_uq",
                        columnNames = "path"
                )
        }
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Attachment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content_type", length = 50, nullable = false)
    private String contentType;

    @Column(name = "path", length = 500, nullable = false)
    private String path;

    @Column(name = "filename", length = 500, nullable = false)
    private String filename;

    @Column(name = "file_size", nullable = false)
    private Integer fileSize;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Attachment that = (Attachment) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
