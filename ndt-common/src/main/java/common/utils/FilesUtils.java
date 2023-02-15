package main.java.common.utils;

import com.tdt.cqsta.common.enums.ResourceType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

public final class FilesUtils {

    public static ResourceType getResourceType(String fileType) {
        if (Objects.isNull(fileType))
            return ResourceType.FILES;

        if (fileType.contains("image"))
            return ResourceType.IMAGES;

        if (fileType.contains("video"))
            return ResourceType.VIDEOS;

        return ResourceType.FILES;
    }

    public static boolean checkFileType(String type, MultipartFile file) {
        return StringUtils.containsIgnoreCase(file.getContentType(), type);
    }

}