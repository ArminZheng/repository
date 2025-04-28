package com.arminzheng.infrastructure.util;

import com.arminzheng.infrastructure.annotation.Dict;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bean Help
 *
 * @author armin
 * @version 2021.12.15
 */
public abstract class BeanHelpUtils {

    private static final Logger log = LoggerFactory.getLogger(BeanHelpUtils.class);

    public static <T> void translation(List<T> collect) {
        for (T t : collect) {
            try {
                translation(t);
            } catch (IntrospectionException | InvocationTargetException |
                     IllegalAccessException e) {
              if (log.isInfoEnabled()) {
                log.info(e.getMessage());
              }
                e.printStackTrace();
            }
        }
    }

    public static <T> void translation(T t)
            throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Dict.class)) {
                String target = field.getAnnotation(Dict.class).target();
                String service = field.getAnnotation(Dict.class).service();
                DictService dictService = SpringContextUtils.getBean(service, DictService.class);
                if (dictService != null) {
                    PropertyDescriptor source = new PropertyDescriptor(field.getName(),
                            t.getClass());
                    Object invoke = source.getReadMethod().invoke(t);
                    if (invoke instanceof String) {
                        Object result = dictService.getValue((String) invoke);
                        PropertyDescriptor targetResult = new PropertyDescriptor(target,
                                t.getClass());
                        targetResult.getWriteMethod().invoke(t, result);
                    }
                }
            }
        }
    }
}
