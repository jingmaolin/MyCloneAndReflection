package mao.com.mycloneandreflection.reflect;

import android.text.TextUtils;

import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Description:反射
 * author:jingmaolin
 * email:1271799407@qq.com.
 * phone:13342446520.
 * date: 2018/5/13.
 */

public class ReflectionTest {
    private static PrintStream stream = System.out;

    public void getClassInformation(Class myClass) {
        Class superClass = myClass.getSuperclass();
        String modifies = Modifier.toString(myClass.getModifiers());
        if (!TextUtils.isEmpty(modifies)) {
            stream.print(modifies);
        }
        stream.print("  " + myClass.getName());
        if (superClass != null && superClass != Object.class) {
            stream.print("extends " + superClass.getName());
        }
        stream.print("\n{\n");

        printField(myClass);
        stream.print("\n");
        printConstructor(myClass);
        stream.print("\n");
        printMethod(myClass);
        stream.print("\n");
        stream.print("}");
    }

    /**
     * 获取域（成员变量）
     */
    private void printField(Class myClass) {
        Field[] fields = myClass.getDeclaredFields();
        if (fields == null) {
            return;
        }
        for (Field f : fields) {
            String modifies = Modifier.toString(f.getModifiers());
            if (!TextUtils.isEmpty(modifies)) {
                stream.print(modifies);
            }

            Class type = f.getType();
            stream.print(type.getName() + "  " + f.getName() + ";\n");
        }
    }

    /**
     * 获取构造方法
     */
    private void printConstructor(Class myClass) {
        Constructor[] constructors = myClass.getDeclaredConstructors();
        if (constructors == null) {
            return;
        }
        for (Constructor constructor : constructors) {
            String modifier = Modifier.toString(constructor.getModifiers());
            if (!TextUtils.isEmpty(modifier)) {
                stream.print(modifier + " ");
            }
            stream.print(myClass.getName() + "(");

            Class[] params = constructor.getParameterTypes();
            for (int i = 0; i < params.length; i++) {
                if (i > 0) {
                    stream.print(",");
                }
                stream.print(params[i].getName());
            }
            stream.print(")" + "\n");
        }

    }

    /**
     * 获取方法
     */
    private void printMethod(Class myClass) {
        Method[] methods = myClass.getDeclaredMethods();
        if (methods == null) {
            return;
        }
        for (Method method : methods) {
            String modify = Modifier.toString(method.getModifiers());
            Class returnType = method.getReturnType();
            if (!TextUtils.isEmpty(modify)) {
                stream.print(modify + " ");
            }
            stream.print(returnType.getName() + " " + method.getName() + "(");
            Class[] types = method.getParameterTypes();
            for (int i = 0; i < types.length; i++) {
                stream.print(types[i].getName());
                if (i > 0) {
                    stream.print(",");
                }
            }
            stream.print(")" + "\n");
        }
    }
}
