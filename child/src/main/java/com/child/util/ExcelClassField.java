package com.child.util;

import lombok.Data;

import java.util.LinkedHashMap;

/**
 * @author wangzhibin
 * @Date 2023/4/7
 */
@Data
public class ExcelClassField {

    /** 字段名称 */

    private String fieldName;

    /** 表头名称 */
    private String name;

    /** 映射关系 */
    private LinkedHashMap<String, String> kvMap;

    /** 示例值 */
    private Object example;

    /** 排序 */
    private int sort;

    /** 是否为注解字段：0-否，1-是 */
    private int hasAnnotation;

}

