package simple_zip;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("create zip file");
        CreateZipFile zipFile = new CreateZipFile();
        zipFile.createZip();
    }
}
