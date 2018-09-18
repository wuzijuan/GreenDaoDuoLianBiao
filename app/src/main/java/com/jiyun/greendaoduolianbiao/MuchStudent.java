package com.jiyun.greendaoduolianbiao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.jiyun.greendaoduolianbiao.dao.DaoSession;
import com.jiyun.greendaoduolianbiao.dao.MuchTeacherDao;
import com.jiyun.greendaoduolianbiao.dao.MuchStudentDao;

/**
 * 高山仰止,景行行止.虽不能至,心向往之。
 * Created by de'l'l on 2018/9/12.
 */

@Entity
public class MuchStudent {
    @Id
    private Long studentId;
    //entity指的是绑定类
    //sourceProperty填写绑定类中标示自身的id，此处为sId，指StudentBean的id
    //targetProperty填写绑定类中标示关联类的id，此处为tId，指TeacherBean的id
    @ToMany
    @JoinEntity(entity = TeacherJoinStudent.class,
            sourceProperty = "sId",
            targetProperty = "tId")
    private List<MuchTeacher> teacherBeanList;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1670311458)
    private transient MuchStudentDao myDao;
    @Generated(hash = 780925964)
    public MuchStudent(Long studentId) {
        this.studentId = studentId;
    }
    @Generated(hash = 1332078718)
    public MuchStudent() {
    }
    public Long getStudentId() {
        return this.studentId;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 947266183)
    public List<MuchTeacher> getTeacherBeanList() {
        if (teacherBeanList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MuchTeacherDao targetDao = daoSession.getMuchTeacherDao();
            List<MuchTeacher> teacherBeanListNew = targetDao
                    ._queryMuchStudent_TeacherBeanList(studentId);
            synchronized (this) {
                if (teacherBeanList == null) {
                    teacherBeanList = teacherBeanListNew;
                }
            }
        }
        return teacherBeanList;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 832141143)
    public synchronized void resetTeacherBeanList() {
        teacherBeanList = null;
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 667552623)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getMuchStudentDao() : null;
    }


}
