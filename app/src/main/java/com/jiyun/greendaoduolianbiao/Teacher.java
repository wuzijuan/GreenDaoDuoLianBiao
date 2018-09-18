package com.jiyun.greendaoduolianbiao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.jiyun.greendaoduolianbiao.dao.DaoSession;
import com.jiyun.greendaoduolianbiao.dao.StudentDao;
import com.jiyun.greendaoduolianbiao.dao.TeacherDao;

/**
 * 高山仰止,景行行止.虽不能至,心向往之。
 * Created by de'l'l on 2018/9/12.
 */

@Entity
public class Teacher {
    @Id
    private Long id;
    private String name;
    private Long studentId;

    @ToOne(joinProperty = "studentId")
    private Student student;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 648119699)
    private transient TeacherDao myDao;
    @Generated(hash = 94089050)
    public Teacher(Long id, String name, Long studentId) {
        this.id = id;
        this.name = name;
        this.studentId = studentId;
    }
    @Generated(hash = 1630413260)
    public Teacher() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getStudentId() {
        return this.studentId;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    @Generated(hash = 79695740)
    private transient Long student__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 313494093)
    public Student getStudent() {
        Long __key = this.studentId;
        if (student__resolvedKey == null || !student__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            StudentDao targetDao = daoSession.getStudentDao();
            Student studentNew = targetDao.load(__key);
            synchronized (this) {
                student = studentNew;
                student__resolvedKey = __key;
            }
        }
        return student;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 490304967)
    public void setStudent(Student student) {
        synchronized (this) {
            this.student = student;
            studentId = student == null ? null : student.getId();
            student__resolvedKey = studentId;
        }
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
    @Generated(hash = 1349174479)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTeacherDao() : null;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentId=" + studentId +
                ", student=" + student +
                ", daoSession=" + daoSession +
                ", myDao=" + myDao +
                ", student__resolvedKey=" + student__resolvedKey +
                '}';
    }
}
