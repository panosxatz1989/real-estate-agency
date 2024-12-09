package demo.pxportfolio.realestateagency.misc.util;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileUtil {

    @Value("${spring.servlet.multipart.location}")
    private String basePath;

    public String getFileExtension(String originalFileName) {
        if (originalFileName != null && originalFileName.contains(".")) {
            return originalFileName.substring(originalFileName.lastIndexOf('.') + 1);
        }

        return "";
    }

    public String createPath(LocalDateTime uploadedAt, String originalFileName, String fileName) {

        String year = String.format("%04d", uploadedAt.getYear());
        String month = String.format("%02d", uploadedAt.getMonthValue());
        String day = String.format("%02d", uploadedAt.getDayOfMonth());

        String path = String.join("/", basePath, year, month, day, fileName);
        path += "." + this.getFileExtension(originalFileName);

        return path;
    }
}