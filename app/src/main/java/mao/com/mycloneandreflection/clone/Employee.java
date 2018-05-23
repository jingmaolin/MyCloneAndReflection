package mao.com.mycloneandreflection.clone;

import android.annotation.TargetApi;

import java.util.Objects;

/**
 * Description:
 * author:jingmaolin
 * email:1271799407@qq.com.
 * phone:13342446520.
 * date: 2018/5/13.
 */

public class Employee implements Cloneable {
    private String name;
    private String sex;
    private int age;
    private Other other;

    public Employee(){

    }

    public Employee(String name, String sex, int age, Other other) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.other = other;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Other getOther() {
        return other;
    }

    public void setOther(Other other) {
        this.other = other;
    }

    @TargetApi(19)
    @Override
    public int hashCode() {
        return Objects.hash(name, sex, age, other);
    }

    @TargetApi(19)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (obj.getClass() != getClass()) {
            return false;
        }

        Employee e = (Employee) obj;
        return getAge() == e.getAge() && Objects.equals(getName(), e.getName())
                && Objects.equals(getSex(), e.getSex()) && Objects.equals(getOther(), e.getOther());
    }

    public Employee clone() throws CloneNotSupportedException {
        Employee employee = (Employee) super.clone();
        employee.other=other.clone();
        return  employee;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", other=" + other.toString() +
                '}';
    }
}
