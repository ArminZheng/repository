package com.arminzheng.infrastructure.util;

import java.util.UUID;

/**
 * UUID Utils
 *
 * @author armin
 * @version 2022.1.26
 */
public abstract class UUIDUtils {
    public static String generatedUUID16() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
    }
}
