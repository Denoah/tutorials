package zip_with_password;


import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.ZipOutputStream;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import java.io.*;

public class CreateZipWithPassword {
    public void createZipWithPasswordFile() {
        String test = "Hello world";
        String pass = "123";
        String filename = "testFileName.txt";
        String acrhiveName = "archiveWithPassword"+pass+".zip";

        ByteArrayOutputStream bos = createInMemory(test.getBytes(), pass, filename);
        writeContentToZzipFile(bos, acrhiveName);

        String archiveName = "archive.zip";
        String fileInArchiveName = "fileInArchive.txt";
        create(test.getBytes(), pass, archiveName, fileInArchiveName);
    }

    private void create(byte[] data, String pass, String archiveName, String fileName) {

        try {
            ZipFile zipFile = new ZipFile(archiveName);
            ZipParameters parameters = new ZipParameters();

            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
            parameters.setFileNameInZip(fileName);
            parameters.setSourceExternalStream(true);

            parameters.setEncryptFiles(true);
            parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
            parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
            parameters.setPassword(pass);

            InputStream is = new ByteArrayInputStream(data);
            zipFile.addStream(is, parameters);
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }

    private ByteArrayOutputStream createInMemory(byte[] data, String pass, String filename) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ZipOutputStream zipOutputStream = new ZipOutputStream(bos);

        ZipParameters parameters = new ZipParameters();

        parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
        parameters.setSourceExternalStream(true);

        parameters.setEncryptFiles(true);
        parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
        parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
        parameters.setPassword(pass);
        parameters.setFileNameInZip(filename);

        try {
            zipOutputStream.putNextEntry(null, parameters);
            zipOutputStream.write(data);
            zipOutputStream.closeEntry();
            zipOutputStream.finish();
            zipOutputStream.close();

        } catch (ZipException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bos;
    }

    private void writeContentToZzipFile(ByteArrayOutputStream bos, String achiveName) {
        byte[] out = bos.toByteArray();
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(new File(achiveName));
            os.write(out);
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
