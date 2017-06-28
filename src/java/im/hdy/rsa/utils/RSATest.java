package im.hdy.rsa.utils;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.crypto.digests.MD5Digest;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.UUID;

/**
 * Created by hdy on 2017/6/23.
 */
public class RSATest {

    public static void main(String args[]) throws UnsupportedEncodingException, NoSuchAlgorithmException {
//        String name = "hdy";
//        System.out.println(encryptData);

//        String[] pairs = RsaUtil.createKeyPairs();
//        System.out.println(pairs[0]);
//        System.out.println(pairs[1]);
//        String s = RsaUtil.decryptData("g3R9GnR+feQ99AFhpRwW/xiXN3AV97Ky9+ZCDqySlljTPPufjpAgw14PXZYdgFRo1ttquGfXBp2/FoHf7XJdTg==", "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAhC9sVLZQBnARSo1O3/WpFkMD7zK1FxrTAn117DfVGX+5jT5X6sMwWXZyn4JAhBM1JjQxk+iBDSjS+XH8yK+7cwIDAQABAkB1VJLX7qvByx/OCPgGG0xnEj0fyOatB4ZdI3fUoQpqgopjXXk+RqibxsCEpUNDNXEtqJDZCeotl/lgIZZCQDghAiEAuChVcAKVqk87YZblwykoL+Xjq0kCKm2GCB33OxuHLNUCIQC3wKg2WM1UCWx+j91bZZ4YBRurX/5aLnl7lzhCdd/LJwIga2UCJjcrps1b+NZyGXUH/Z7YPYxvGeUTM+qdwjeUhh0CIQCRZBf0wHjeiIJW9eAQ5CueF9SX2eF4W5N1zeYO+BN2OwIgXj02rav/aCi/sLKm7rZHxoNnK/KKjRQ6cp5LaFgfoWY=");
//
// System.out.println(s);
        String encode = URLEncoder.encode("O+YjaRUFpcXpvxRbA//WFg==", "utf-8");
        System.out.println(encode);
        //O%2BYjaRUFpcXpvxRbA%2F%2FWFg%3D%3D
    }
}
