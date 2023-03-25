package com.test.im.crypt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * 请求响应处理类<br>
 *
 * 对加了@Encrypt的方法的数据进行加密操作
 *
 * @author 熊诗言
 *
 */
@ControllerAdvice
public class EncryptResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Value("${crypto.charset}")
    private String charset = "UTF-8";
    @Value("${crypto.key}")
    private String key;


    private static final String AES_ALGORITHM = "AES/ECB/PKCS5Padding";

    @Override
    public boolean supports(MethodParameter parameter, Class<? extends HttpMessageConverter<?>> converterType) {
//        return parameter.getParameterType().isAssignableFrom(User.class) && parameter.hasParameterAnnotation(LoginUser.class);
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        //TODO 实现具体的加密方法
//        System.out.println("_______暂时不需要加密response捏_________");
//        System.out.println(body);

        return body;
    }

    private static Cipher getCipher(byte[] key, int model) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(model, secretKeySpec);
        return cipher;
    }


    public static String encrypt(byte[] data, byte[] key) throws Exception {
        Cipher cipher = getCipher(key, Cipher.ENCRYPT_MODE);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data));
    }
}
