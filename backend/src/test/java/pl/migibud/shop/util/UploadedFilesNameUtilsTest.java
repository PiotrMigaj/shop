package pl.migibud.shop.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class UploadedFilesNameUtilsTest {

    @ParameterizedTest
    @CsvSource({
            "test test.png, test-test.png",
            "hello world.png, hello-world.png",
            "ąęśćó.png, aesco.png",
            "Produkt - 1.png, produkt-1.png",
            "Produkt 1.png, produkt-1.png",
            "Produkt__1.png, produkt-1.png"
    })
    void shouldSlugifyFileName(String input,String expected){
        //given
        //when
        String result = UploadedFilesNameUtils.slugifyFileName(input);
        //then
        assertThat(result).isEqualTo(expected);
    }

}