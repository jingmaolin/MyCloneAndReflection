package mao.com.mycloneandreflection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import mao.com.mycloneandreflection.clone.Employee;
import mao.com.mycloneandreflection.clone.Other;
import mao.com.mycloneandreflection.reflect.ReflectionTest;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //equal测试
        Employee e=new Employee("小明","男",20,new Other(170,"乒乓球","火星"));
        Employee c=new Employee("小明","男",20,new Other(170,"乒乓球","火星"));
        Log.d(TAG, "onCreate: "+e.equals(c));

        cloneTest();
        reflectTest();
    }

    //克隆，深拷贝
    public void cloneTest(){
        Employee e=new Employee("小明","男",20,new Other(170,"乒乓球","火星"));
        try {
            Employee c=e.clone();
            c.getOther().setAddress("地球");
            Log.d(TAG, "e toString: "+e.toString());
            Log.d(TAG, "c toString: "+c.toString());
        } catch (CloneNotSupportedException e1) {
            e1.printStackTrace();
        }
    }

    //通过反射分析类的能力
    public void reflectTest(){
        new ReflectionTest().getClassInformation(Employee.class);
    }
}
