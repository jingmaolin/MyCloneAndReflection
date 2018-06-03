package mao.com.mycloneandreflection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import mao.com.mycloneandreflection.clone.Employee;
import mao.com.mycloneandreflection.clone.Other;
import mao.com.mycloneandreflection.reflect.ReflectionTest;
import mao.com.mycloneandreflection.reflect.RelectionUse;
import mao.com.mycloneandreflection.reflectUtils.ReflectArrayUtil;
import mao.com.mycloneandreflection.reflectUtils.ReflectToStringUtil;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //equal测试
        Employee e = new Employee("小明", "男", 20, new Other(170, "乒乓球", "火星"));
        Employee c = new Employee("小明", "男", 20, new Other(170, "乒乓球", "火星"));
        Log.d(TAG, "onCreate: " + e.equals(c));

//        cloneTest();
//        reflectTest();
//        reflectUse();
//        reflectArrayUtil();
        reflectToStringUtil();
    }

    //克隆，深拷贝
    public void cloneTest() {
        Employee e = new Employee("小明", "男", 20, new Other(170, "乒乓球", "火星"));
        try {
            Employee c = e.clone();
            c.getOther().setAddress("地球");
            Log.d(TAG, "e toString: " + e.toString());
            Log.d(TAG, "c toString: " + c.toString());
        } catch (CloneNotSupportedException e1) {
            e1.printStackTrace();
        }
    }

    //通过反射分析类的能力
    public void reflectTest() {
        new ReflectionTest().getClassInformation(Employee.class);
    }

    //通过反射来实例化某类、获取/设置对象中某域的值、调用对象方法
    public void reflectUse() {
        Employee e = new Employee("小明", "female", 22, new Other(165, "pingpingball", "mianyang"));
        new RelectionUse().createEmObject(e)
                .getFieleValue(e)
                .inVokingMethod(e);
    }

    //通过反射拷贝数组
    public void reflectArrayUtil() {
        String[] str = new String[]{"1", "2", "3", "4", "5", "6"};
        for (String s : str) {
            Log.d(TAG, "before copy: " + s);
        }
        String[] newStr = (String[]) ReflectArrayUtil.goodCopy(str,3);
        for (String s : newStr) {
            Log.d(TAG, "after copy: " + s);
        }
    }

    //通过反射建立通用性toString方法
    public void reflectToStringUtil(){
        String str = new String("maomao");
        Log.d(TAG, "reflectToStringUtil: str=" + ReflectToStringUtil.toString(str));

        String[] array = new String[]{"1","2","3","4","5","6","7","8"};
        Log.d(TAG, "reflectToStringUtil: array=" + ReflectToStringUtil.toString(array));


    }
}
