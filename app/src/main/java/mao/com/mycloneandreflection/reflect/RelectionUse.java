package mao.com.mycloneandreflection.reflect;

import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import mao.com.mycloneandreflection.clone.Employee;
import mao.com.mycloneandreflection.clone.Other;

/**
 * Description:通过反射来实例化某类、获取/设置对象中某域的值、调用对象方法
 * author:jingmaolin
 * email:1271799407@qq.com.
 * phone:13342446520.
 * date: 2018/6/3.
 */

public class RelectionUse {
    private static final String TAG = "RelectionUse";

    /**
     * 实例化Employee类
     */
    public RelectionUse createEmObject(Object object) {
        Class c = object.getClass();
        if (c == Employee.class) {
            try {
                Employee employee = (Employee) c.newInstance();
                employee.setAge(12);
                employee.setName("12");
                employee.setOther(new Other(12, "12", "12"));
                employee.setSex("12");
                Log.d(TAG, "createEmObject: " + employee.toString());
            } catch (Exception e) {
                Log.d(TAG, "createEmObject: " + "没有默认构造函数");
            }
        }
        return  this;
    }

    /**
     * 获取某域的值
     */
    public RelectionUse getFieleValue(Object object) {
        try {
            Field field = object.getClass().getDeclaredField("name");
            field.setAccessible(true);
            Object value = field.get(object);

            if (value instanceof String) {
                Log.d(TAG, "name = " + value);
            }

            field.set(object, "hahahahaha");
            if (object instanceof Employee) {
                Log.d(TAG, "after set ,value =" + object.toString());
            }
        } catch (Exception e) {
            Log.d(TAG, "getFieleValue: " + "该域值不存在");
        }
        return  this;
    }

    /**
     * 调用Method方法
     */
    public RelectionUse inVokingMethod(Object object) {
        try {
            Log.d(TAG, "inVokingMethod: " + object.toString());
            Method method = object.getClass().getDeclaredMethod("setName",String.class);
            method.setAccessible(true);
            method.invoke(object, "wawawawawawa");
            Log.d(TAG, "inVokingMethod: " + object.toString());
        } catch (Exception e) {
            Log.d(TAG, "inVokingMethod: " + "该方法不存在 ");
        }
        return this;
    }
}
