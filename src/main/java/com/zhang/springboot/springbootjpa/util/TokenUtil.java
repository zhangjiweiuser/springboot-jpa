package com.zhang.springboot.springbootjpa.util;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import net.minidev.json.JSONObject;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {
    private static final byte[] secret = "geiwodiangasfdjsikolkjikolkijswegeiwodiangasfdjsikolkjikolkijswegeiwodiangasfdjsikolkjikolkijswegeiwodiangasfdjsikolkjikolkijswegeiwodiangasfdjsikolkjikolkijswegeiwodiangasfdjsikolkjikolkijswegeiwodiangasfdjsikolkjikolkijswegeiwodiangasfdjsikolkjikolkijswe".getBytes();

    public static String createToken(Map<String, Object> payloadMap) throws JOSEException {
        // 1.先建立一个头部header
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS256);
        // 2.建立一个载荷payload
        Payload payload = new Payload(new JSONObject(payloadMap));
        // 3.将头部和载荷结合在一起
        JWSObject jwsObject = new JWSObject(header, payload);
        // 4.建立一个秘钥
        JWSSigner jwsSigner = new MACSigner(secret);
        // 5.签名
        jwsObject.sign(jwsSigner);
        // 6.生成token
        return jwsObject.serialize();
    }

    public static Map<String, Object> valid(String token) throws ParseException, JOSEException {
        // 1.解析token
        JWSObject jwsObject = JWSObject.parse(token);
        // 2.获取载荷
        Payload payload = jwsObject.getPayload();
        // 3.建立解锁秘钥
        JWSVerifier jwsVerifier = new MACVerifier(secret);
        Map<String, Object> resultMap = new HashMap<>();
        // 4.判断token
        if (jwsObject.verify(jwsVerifier)) {
            // 5.将载荷的数据解析成json对象
            JSONObject jsonObject = payload.toJSONObject();
            resultMap.put("data", jsonObject);
            // 6.判断token是否过期
            if (jsonObject.containsKey("exp")) {
                Long expTime = Long.valueOf(jsonObject.get("exp").toString());
                Long now = System.currentTimeMillis();
                if (now > expTime) {
                    resultMap.clear();
                    resultMap.put("result", "2");
                    resultMap.put("msg", "已过期");
                    return resultMap;
                }
            }
        }
        resultMap.put("result", "1");
        resultMap.put("msg", "正常");
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        return resultMap;
    }

    public static void main(String[] args) throws JOSEException, ParseException {
        Map<String, Object> payloadMap = new HashMap<>();
        payloadMap.put("name", "zhang");
        payloadMap.put("sex", 1);
        payloadMap.put("sta", System.currentTimeMillis());
        payloadMap.put("exp", System.currentTimeMillis() + 2 * 3600 * 1000);
        String token = createToken(payloadMap);
        System.out.println(token);
        Map<String, Object> validToken = valid(token);
        System.out.println(validToken.toString());
    }
}
