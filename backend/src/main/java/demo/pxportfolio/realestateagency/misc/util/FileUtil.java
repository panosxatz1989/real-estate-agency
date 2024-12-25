package demo.pxportfolio.realestateagency.misc.util;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class FileUtil {

    @Value("${spring.servlet.multipart.location}")
    private String basePath;

    public static final List<String> ALLOWED_EXTENSIONS = List.of(
            "png",
            "jpg",
            "jpeg"
    );

    public String getFileExtension(String originalFileName) {
        if (originalFileName != null && originalFileName.contains(".")) {
            return originalFileName.substring(originalFileName.lastIndexOf('.') + 1);
        }

        return "";
    }

    public String createPath(LocalDateTime uploadedAt, String originalFileName, String fileName, String extension) {

        String year = String.format("%04d", uploadedAt.getYear());
        String month = String.format("%02d", uploadedAt.getMonthValue());
        String day = String.format("%02d", uploadedAt.getDayOfMonth());

        String path = String.join("/", basePath, year, month, day, fileName);
        path += "." + extension;

        return path;
    }
}