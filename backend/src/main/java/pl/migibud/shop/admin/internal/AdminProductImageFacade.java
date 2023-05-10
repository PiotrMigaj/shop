package pl.migibud.shop.admin.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import pl.migibud.shop.util.ExistingFileRenameUtils;
import pl.migibud.shop.util.UploadedFilesNameUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
class AdminProductImageFacade {

    @Value("${app.uploadDir}")
    private String uploadDir;

    public String uploadImage(final String filename, final InputStream inputStream) {
        String newFileName = UploadedFilesNameUtils.slugifyFileName(filename);
        newFileName = ExistingFileRenameUtils.renameIfExists(Path.of(uploadDir), newFileName);
        Path filePath = Paths.get(uploadDir)
                             .resolve(newFileName);
        try (OutputStream outputStream = Files.newOutputStream(filePath)) {
            inputStream.transferTo(outputStream);
        } catch (IOException e) {
            throw new IllegalStateException("Can not save the file...", e);
        }
        return newFileName;
    }

    public Resource serveFiles(final String filename) {
        FileSystemResourceLoader fileSystemResourceLoader = new FileSystemResourceLoader();
        return fileSystemResourceLoader.getResource(uploadDir + filename);
    }

}
