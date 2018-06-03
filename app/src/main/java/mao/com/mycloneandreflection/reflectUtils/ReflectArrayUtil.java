package mao.com.mycloneandreflection.reflectUtils;

import android.util.Log;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Description:拷贝数组
 * author:jingmaolin
 * email:1271799407@qq.com.
 * phone:13342446520.
 * date: 2018/6/3.
 */

public class ReflectArrayUtil {
    private static final String TAG = "ReflectArrayUtil";

    /**
     * 拷贝数组,对基础类型也适用
     */
    public static Object goodCopy(Object object, int newLength) {
        Class c = object.getClass();
        if (!c.isArray()) {
            Log.d(TAG, "goodCopy: " + "传入的对象不是数组");
            return null;
        }
        int length = Array.getLength(object);
        Object newArray = Array.newInstance(c.getComponentType(), newLength);       //某个类型的数组
        System.arraycopy(object, 0, newArray, 0, Math.min(newLength, length));
        return newArray;
    }
}
