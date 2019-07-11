package com.uas.passlock.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

import static com.uas.passlock.util.Constants.SECURITY_BLOWFISH_INSTANCE;

@Component
public class SecurityUtil {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${passvault.security.salt}")
    private  String securitySalt;


    private static final Base64 base64 = new Base64(true);

    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public  String encrypt(String data) {
        byte[] pArray = getByteByMode(data.getBytes(StandardCharsets.UTF_8), Cipher.ENCRYPT_MODE);
        return base64.encodeToString(pArray);
    }

    public  String decrypt(String data) {
        byte[] encryptedData = Base64.decodeBase64(data);
        byte[] decrypted = getByteByMode(encryptedData, Cipher.DECRYPT_MODE);
        return new String(decrypted);

    }

    private  byte[] getByteByMode(byte[] data, int mode) {
        try {
            SecretKeySpec key = new SecretKeySpec(securitySalt.getBytes(StandardCharsets.UTF_8), SECURITY_BLOWFISH_INSTANCE);
            Cipher cipher = Cipher.getInstance(SECURITY_BLOWFISH_INSTANCE);
            cipher.init(mode, key);
            return cipher.doFinal(data);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Exception while initializing Cipher");
        }
    }

}
