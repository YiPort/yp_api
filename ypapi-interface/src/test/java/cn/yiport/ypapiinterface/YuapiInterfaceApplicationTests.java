package cn.yiport.ypapiinterface;

import cn.yiport.ypapiclientsdk.client.YpApiClient;
import cn.yiport.ypapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ypapiInterfaceApplicationTests {

    @Resource
    private YpApiClient ypapiClient;

    @Test
    void contextLoads() {
        User user = new User();
        user.setUsername("iamyiport");
        String nameByGet = ypapiClient.getNameByGet(user);
        String usernameByPost = ypapiClient.getUsernameByPost(user);
        System.out.println(nameByGet);
        System.out.println(usernameByPost);
    }

}
