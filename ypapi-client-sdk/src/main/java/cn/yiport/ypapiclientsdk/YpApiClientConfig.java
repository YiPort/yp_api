package cn.yiport.ypapiclientsdk;

import cn.yiport.ypapiclientsdk.client.YpApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("ypapi.client")
@Data
@ComponentScan
public class YpApiClientConfig {

    private String accessKey;

    private String secretKey;

    @Bean
    public YpApiClient ypapiClient() {
        return new YpApiClient(accessKey, secretKey);
    }

}
