package com.liyang.orchard.utils;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RsaUtils {
    /** PrivateKey * 生成秘钥 > openssl genrsa -out rsa_private_key.pem 2048
     * 转换成PKCS8格式 > openssl pkcs8 -topk8 -inform PEM -in rsa_private_key.pem -outform PEM -out rsa_private_key_01.pem -nocrypt
     * 在终端输出结果，去掉“-----BEGIN PRIVATE KEY-----” * “-----END PRIVATE KEY-----”
     * @return PrivateKey
     */
    public static PrivateKey getPrivateKey() {
        PrivateKey privateKey = null;
        try {
            String privateKeyStr = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQC8jNa8vg695xQL" +
                    "4LzhECfNsW10T9fUk5qdVPab8O3FMDFhCUzH7P0WF7pUqHyOgu5eOufgFITR3+Nw" +
                    "r6fHFF4m749FGp6xfNj8FELv4Vji3ZIWj91IKP7pZUzsJkFJr2xsf14Th+IWjfXf" +
                    "NqlcvLP3L4dCSo+BnzeFx//656x6AXnWrLx5ZH33OIyVM4a+mSo2vQkI0WaMhB+i" +
                    "YEceuJZgomDC0jj+RyCrfENmO8U/FPfrlONF8fd6h6xk91AZNqTWJHIsYSHaS64h" +
                    "TIQJz/+2X5gqguWymMhgUGBQVcmTVGt3d2rr8JAqp2P6vqw1ZJlEbNHTSycv7PZM" +
                    "5RfdUJ1jAgMBAAECggEBAJJMaXZLth6NhRVuTMAJDAljKT19kkdEPEzllvAKskM1" +
                    "kKrtT2E1Nm8E/DQiA3uEhjYhWLea1DAQm2ZdNT6YRDHL4YvKCuZGrAp0IjgEzzZA" +
                    "m9Db0ePiw2APlO8LA8+LyQIqlbFr1vaPMf7/Z8woMy+R9k5ukgkOpEMumyVwy3hi" +
                    "BdIhIOSs36/tyldpk/y7EH6lTVjqvoJx3hDczhz7FVcSXkDzBfA7Vr5ALyRmzRVn" +
                    "ndSwGpLlSIxZE9IhjYClbK7fl4Nbt6U9vseZeBqaoQxmE3oDtAKmke+BqIawqTe/" +
                    "Im5gYpR7RxXImH3fK+8e+/iZKD0ZUR120QdvAQlW3NkCgYEA3nat155KroiIqct7" +
                    "dP6n9EmXW/tBZ6/EUiWgrOIeK2zQVY6HQ+M2xItPcoQuRxCblCi/Eq6d2NN1VP5p" +
                    "6MODJR2NA1fLg5R/k7x2dDADkOBkJay/WufGdUM7bYWYGrp6iT2rtr1DCXOZkNtV" +
                    "cO9KZnrd82mwiVWkEpKHFQ7//t0CgYEA2PlfFFnAEl/p+bpzSdsNQCrowC/zkTBT" +
                    "uTIBLfrZWFmPeS6tmv18ZDFWYJWpi09cHnZRqFymOil3pBzJpWgpkSsizQ2L7BFx" +
                    "hoylc7noUybrFM/wJWTzA7oiZ6wCsurz5m/Zn7qESYw9HubjMFZ8AnhWvKvWcX8V" +
                    "Wc00mfHFqT8CgYEAk0JQNSitGvd6L5tor7tahlSogtTBKNeqxw3tXEOZ4Pj4t4nP" +
                    "dFrViCkHgDCLSbNuqRaH1OAN0Ne5FXgLt26kQ09aZtoY95K3GJ5qcuLNmXtQD7hY" +
                    "Ot6t+jV1AzypwRerwWk3X5HM7Fa/Uqo91rIvt8KhZV2S5HXyU/D2xjPVtWkCgYEA" +
                    "yHNJ1cE84zzdKiuIyximWzvJH5StTtr43kVGNbZkCW1kUS5AkMnSm7XA+SYLJnrA" +
                    "vhvNQN+namBY+bLmz/s1O7pAQnRbalKLMSTKzelYq0lvMSER2Voz8KOLmX+eVrEd" +
                    "dyyqPxjPkisPZHcmOMgNdTK73z5ZtS0VCou8JuToGX0CgYBV0KA39IXd0499pChT" +
                    "Yqc7aOxSjmLVwNwnZMnLQSt6jzp9Dd0mmLFS7CKxs/1k7Z5SSfBM6HdJ33ODZ94i" +
                    "6EIZmpGLrSuqI1fmduhJ0xRXkT+K262BUtYyMypWyWzDiLUxoPlhtuMMYkpFxfdv" +
                    "V+bFLoxpHZ3gNiVLIJjSv4BApw==";
            // PKCS8格式的密钥
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKeyStr));
            // RSA 算法
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return privateKey;
    }

    /** PublicKey 根据 秘钥 生成public key > openssl rsa -in rsa_private_key.pem -out rsa_public_key.pem -pubout
     * @return PublicKey
     */
    public static PublicKey getPublicKey() {
        PublicKey publicKey = null;
        try {
            String publicKeyStr = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvIzWvL4OvecUC+C84RAn" +
                    "zbFtdE/X1JOanVT2m/DtxTAxYQlMx+z9Fhe6VKh8joLuXjrn4BSE0d/jcK+nxxRe" +
                    "Ju+PRRqesXzY/BRC7+FY4t2SFo/dSCj+6WVM7CZBSa9sbH9eE4fiFo313zapXLyz" +
                    "9y+HQkqPgZ83hcf/+uesegF51qy8eWR99ziMlTOGvpkqNr0JCNFmjIQfomBHHriW" +
                    "YKJgwtI4/kcgq3xDZjvFPxT365TjRfH3eoesZPdQGTak1iRyLGEh2kuuIUyECc//" +
                    "tl+YKoLlspjIYFBgUFXJk1Rrd3dq6/CQKqdj+r6sNWSZRGzR00snL+z2TOUX3VCd" +
                    "YwIDAQAB";
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKeyStr));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            return null;
        }
    }
}
