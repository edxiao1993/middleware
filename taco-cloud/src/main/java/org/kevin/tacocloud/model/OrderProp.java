package org.kevin.tacocloud.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Kevin.Zng
 * @date 2022/4/1 01:22
 */
@Data
@Component
@ConfigurationProperties(prefix = "taco.oirders")
public class OrderProp {
    private int pageSize = 20;
}
