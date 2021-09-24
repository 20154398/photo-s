package com.tangyuan.photo;

import net.coobird.thumbnailator.Thumbnails;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

@SpringBootTest
public class ThumbnailatorTest {

    @Test
    public void copy() {
        String inPath = "";

    }

    @Test
    public void t() throws IOException {
        Thumbnails.of(new File("E:/摄影/相片/NI2A2112.JPG"))
                .scale(0.2)
                .toFile("E:/摄影/相片/1.JPG");
    }
}
