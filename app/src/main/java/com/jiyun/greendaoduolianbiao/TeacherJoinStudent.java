package com.jiyun.greendaoduolianbiao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 高山仰止,景行行止.虽不能至,心向往之。
 * Created by de'l'l on 2018/9/13.
 */

@Entity
public class TeacherJoinStudent {
    @Id
    private Long id;
    private Long tId;
    private Long sId;
    @Generated(hash = 1478813119)
    public TeacherJoinStudent(Long id, Long tId, Long sId) {
        this.id = id;
        this.tId = tId;
        this.sId = sId;
    }
    @Generated(hash = 1349573332)
    public TeacherJoinStudent() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getTId() {
        return this.tId;
    }
    public void setTId(Long tId) {
        this.tId = tId;
    }
    public Long getSId() {
        return this.sId;
    }
    public void setSId(Long sId) {
        this.sId = sId;
    }
}
