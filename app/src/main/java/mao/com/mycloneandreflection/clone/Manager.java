package mao.com.mycloneandreflection.clone;

/**
 * Description:
 * author:jingmaolin
 * email:1271799407@qq.com.
 * phone:13342446520.
 * date: 2018/5/13.
 */

public class Manager extends Employee{
    private int salary;

    public Manager(){

    }

    public Manager(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
