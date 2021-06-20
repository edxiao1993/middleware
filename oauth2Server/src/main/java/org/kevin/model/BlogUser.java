package org.kevin.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Kevin.Z
 * @version 2021/6/20
 */
@Data
public class BlogUser {
    private String id;

    private String username;

    private String password;

    private LocalDateTime createTime;

    private Boolean status;

}
