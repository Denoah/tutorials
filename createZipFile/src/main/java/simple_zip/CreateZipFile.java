package simple_zip;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipFile {
    private final String FILE_NAME = "test.txt";
    private final String ZIP_FILE_NAME = "test1.zip";

    public void createZip() throws Exception {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(ZIP_FILE_NAME));
        out.setLevel(1);

        String text = "Hello World 1";
        byte[] bytes = text.getBytes();

        ZipEntry zipEntry = new ZipEntry("test.txt");
        out.putNextEntry(zipEntry);

        out.write(bytes);
        out.close();
    }



}
