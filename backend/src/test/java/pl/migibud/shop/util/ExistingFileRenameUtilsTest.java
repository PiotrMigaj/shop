package pl.migibud.shop.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class ExistingFileRenameUtilsTest {

    @Test
    void shouldNotRenameFile(@TempDir Path tempDir) throws IOException {
        //given
        //when
        String newName = ExistingFileRenameUtils.renameIfExists(tempDir, "test.png");
        //then
        assertThat(newName).isEqualTo("test.png");
    }
    @Test
    void shouldRenameExistingFile(@TempDir Path tempDir) throws IOException {
        //given
        String existingFileName = "test.png";
        Files.createFile(tempDir.resolve(existingFileName));
        //when
        String newName = ExistingFileRenameUtils.renameIfExists(tempDir, existingFileName);
        //then
        assertThat(newName).isEqualTo("test-1.png");
    }
    @Test
    void shouldRenameManyExistingFile(@TempDir Path tempDir) throws IOException {
        //given
        Files.createFile(tempDir.resolve("test.png"));
        Files.createFile(tempDir.resolve("test-1.png"));
        Files.createFile(tempDir.resolve("test-2.png"));
        Files.createFile(tempDir.resolve("test-3.png"));
        //when
        String newName = ExistingFileRenameUtils.renameIfExists(tempDir, "test.png");
        //then
        assertThat(newName).isEqualTo("test-4.png");
    }

}