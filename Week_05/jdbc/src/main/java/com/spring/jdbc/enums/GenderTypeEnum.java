package com.spring.jdbc.enums;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jdbc -- chengyan
 * @date 2021/4/19 15:45
 **/
public enum GenderTypeEnum {

    /* 女 */
    FEMALE(0, "女"),
    /* 男 */
    MALE(1, "男"),
    /* 未知 */
    UNKNOWN(2, "未知");

    /**
     * 性别值
     */
    @Getter
    @Setter
    private Integer genderType;

    /**
     * 性别描述
     */
    @Getter
    @Setter
    private String genderTypeName;

    GenderTypeEnum(Integer genderType, String genderTypeName){
        this.genderType = genderType;
        this.genderTypeName = genderTypeName;
    }

    public static List<GenderTypeEnum> getGenderTypeEnumList() {
        return new ArrayList<>(Arrays.asList(GenderTypeEnum.values()));
    }


    /**
     *
     * @param genderTypeName
     * @return
     */
    public static Integer getGenderByGenderTypeName(String genderTypeName){

        return Arrays.stream(GenderTypeEnum.values())
                .filter(s -> genderTypeName.equals(s.getGenderTypeName()))
                .findFirst()
                .map(GenderTypeEnum::getGenderType)
                .orElse(2);

    }

    /**
     *
     * @param genderType
     * @return
     */
    public static String getGenderTypeNameByGender(Integer genderType){

        return Arrays.stream(GenderTypeEnum.values())
                .filter(s -> genderType.equals(s.getGenderType()))
                .findFirst()
                .map(GenderTypeEnum::getGenderTypeName)
                .orElse("未知");

    }
}
