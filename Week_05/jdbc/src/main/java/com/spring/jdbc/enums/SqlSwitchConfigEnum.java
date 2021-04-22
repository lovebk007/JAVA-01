package com.spring.jdbc.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jdbc -- chengyan
 * @date 2021/4/21 15:47
 **/
public enum SqlSwitchConfigEnum {

    /* Hikari */
    Hikari(0, "Hikari"),
    /* Jdbc */
    Jdbc(1, "Jdbc"),
    /* PreparedStatement */
    PreparedStatement(2, "PreparedStatement"),
    /* Statement */
    Statement(3, "Statement");

    /**
     * 数据源
     */
    @Getter
    @Setter
    private Integer value;

    /**
     * 数据源描述
     */
    @Getter
    @Setter
    private String description;


    SqlSwitchConfigEnum(Integer value, String description){
        this.value = value;
        this.description = description;
    }
}
