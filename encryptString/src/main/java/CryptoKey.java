public class CryptoKey {
    private byte[] key;

    public CryptoKey() {
        String KEY = "asdfbdaiskbfiasdkjnslajsdnfolkjd";
        this.key = KEY.getBytes();
    }

    public byte[] getKey() {
        return key;
    }
}
