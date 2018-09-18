package com.jiyun.greendaoduolianbiao;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;
/**
 * 高山仰止,景行行止.虽不能至,心向往之。
 * Created by de'l'l on 2018/9/12.
 */

@Entity
public class TwoStudent {
    @Id
    private Long twoStudentId;
    @NotNull
    private String name;
    private Long oneId;

    @Generated(hash = 1139606677)
    public TwoStudent(Long twoStudentId, @NotNull String name, Long oneId) {
        this.twoStudentId = twoStudentId;
        this.name = name;
        this.oneId = oneId;
    }
    @Generated(hash = 640146521)
    public TwoStudent() {
    }
    public Long getTwoStudentId() {
        return this.twoStudentId;
    }
    public void setTwoStudentId(Long twoStudentId) {
        this.twoStudentId = twoStudentId;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getOneId() {
        return this.oneId;
    }
    public void setOneId(Long oneId) {
        this.oneId = oneId;
    }

    @Override
    public String toString() {
        return "TwoStudent{" +
                "twoStudentId=" + twoStudentId +
                ", name='" + name + '\'' +
                ", oneId=" + oneId +
                '}';
    }
}
