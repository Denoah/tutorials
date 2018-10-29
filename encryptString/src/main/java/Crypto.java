import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

public class Crypto {
    private SecretKey secredKey;

    public Crypto(byte[] key) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            this.secredKey = new SecretKeySpec(key, 0, key.length, "AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public byte[] cipherText(String textFoCrypto) {
        return makeAes(textFoCrypto.getBytes(), Cipher.ENCRYPT_MODE);
    }

    public String encryptText(byte[] cipherText) {
        return new String(makeAes(cipherText, Cipher.DECRYPT_MODE));
    }

    private byte[] makeAes(byte[] message, int cipherMode) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(cipherMode, this.secredKey);
            return cipher.doFinal(message);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
