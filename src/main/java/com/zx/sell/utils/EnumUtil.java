package com.zx.sell.utils;

import com.zx.sell.enums.CodeEnum;

public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code,Class<T> clazz) {
        for(T each : clazz.getEnumConstants()) {
            if(code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }

}
