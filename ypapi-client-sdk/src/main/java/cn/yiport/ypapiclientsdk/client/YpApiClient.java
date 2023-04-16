package cn.yiport.ypapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import cn.yiport.ypapiclientsdk.model.User;


import java.util.HashMap;
import java.util.Map;

import static cn.yiport.ypapiclientsdk.utils.SignUtils.genSign;

/**
 * 调用第三方接口的客户端
 *
 * @author yiport
 */
public class YpApiClient {

    private static final String GATEWAY_HOST = "http://localhost:8090";

    private String accessKey;

    private String secretKey;

    public YpApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }



    //调加一个调用方法
    public String getDuJiTang() {


        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/words/motivation")
                .addHeaders(getHeaderMap("1"))
                .body("1")
                .execute();

        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }

    private Map<String, String> getHeaderMap(String body) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", accessKey);
        // 一定不能直接发送
//        hashMap.put("secretKey", secretKey);
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("body", body);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign", genSign(body, secretKey));
        return hashMap;
    }

    public String getUsernameByPost(User user) {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/name/user")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }

    public String getNameByGet(User user) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.get(GATEWAY_HOST + "/api/name/get")
                        .addHeaders(getHeaderMap(json))
                      .body(json)
                     .execute();

        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }

    public String getNameByPost(User user) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/name/post")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }

//    public String getNameByGet(String yiport) {
//    }
}
