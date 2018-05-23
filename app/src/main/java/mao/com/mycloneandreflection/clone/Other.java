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

public class Other implements Cloneable{
    private int bodyHeight;
    private String hobby;
    private String address;

    public Other(){

    }


    public Other(int bodyHeight, String hobby, String address) {
        this.bodyHeight = bodyHeight;
        this.hobby = hobby;
        this.address = address;
    }

    public int getBodyHeight() {
        return bodyHeight;
    }

    public void setBodyHeight(int bodyHeight) {
        this.bodyHeight = bodyHeight;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @TargetApi(19)
    @Override
    public int hashCode() {
        return Objects.hash(bodyHeight, hobby, address);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Other other = (Other) obj;
        return bodyHeight == other.getBodyHeight()
                && hobby == other.getHobby()
                && address == other.getAddress();
    }

    @Override
    public Other clone() throws CloneNotSupportedException {
        return (Other) super.clone();
    }

    @Override
    public String toString() {
        return "Other{" +
                "bodyHeight=" + bodyHeight +
                ", hobby='" + hobby + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
