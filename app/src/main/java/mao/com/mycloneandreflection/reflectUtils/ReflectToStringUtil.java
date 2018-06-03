package mao.com.mycloneandreflection.reflectUtils;

import android.util.Log;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * Description:反射通用方法
 * author:jingmaolin
 * email:1271799407@qq.com.
 * phone:13342446520.
 * date: 2018/6/3.
 */

public class ReflectToStringUtil {
    private static final String TAG = "ReflectToStringUtil";
    public static ArrayList<Object> visited = new ArrayList<>();

    public static String toString(Object object) {
        if (object == null) {
            return null;
        }
        if (visited.contains(object)) {
            return "";
        }
        visited.add(object);
        Class c = object.getClass();
        if (c.isArray()) {
            String string = c.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(object); i++) {
                if (i > 0) {
                    string += ",";
                }
                Object child = Array.get(object, i);
                if (child != null) {
                    if (child.getClass().isPrimitive()) {
                        string += child;
                    } else {
                        string += toString(child);
                    }
                }
            }
            return string + "}";
        }

        String str = c.getName();
        str += "[";

        do {
            Field[] fields = c.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            for (Field f : fields) {
                if (f != null) {
                    if (!Modifier.isStatic(f.getModifiers())) {
                        if (str.endsWith("[")) {
                            str += ",";
                        }
                        Class type = f.getType();
                        try {
                            Object value = f.get(object);
                            if (type.isPrimitive()) {
                                str += value;
                            } else {
                                str += toString(value);
                            }
                        } catch (IllegalAccessException e) {
                            Log.d(TAG, "找不到该field值");
                        }
                    }
                }
            }
            str += "]";
            c = c.getSuperclass();
        } while (c != null);
        return str;
    }
}
