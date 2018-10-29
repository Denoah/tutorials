public class Main {
    public static void main(String[] args) {
        String textFoCrypto = "Этот текст нужно зашифровать";
        //Выводим сообщение
        System.out.println(textFoCrypto);

        byte[] key = new CryptoKey().getKey();
        Crypto crypto = new Crypto(key);

        //Шифруем текст
        byte[] cipherText = crypto.cipherText(textFoCrypto);
        System.out.println(new String(cipherText));

        String cleanText = crypto.encryptText(cipherText);
        System.out.println(cleanText);


    }
}
