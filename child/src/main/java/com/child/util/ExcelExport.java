package com.child.util;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author
 * @Date 2023/4/7
 */
@Target(ElementType.FIELD)//指定该注解只能用于字段上。
@Retention(RetentionPolicy.RUNTIME)//该注解可以保留到运行时,可以通过反射读取该注解。
public @interface ExcelExport {

    /** 字段名称 */
    String value();

    /** 导出排序先后: 数字越小越靠前（默认按Java类字段顺序导出） */
    int sort() default 0;

    /** 导出映射，格式如：0-未知;1-男;2-女 */
    String kv() default "";

    /** 导出模板示例值（有值的话，直接取该值，不做映射） */
    String example() default "";

}