package com.jiyun.greendaoduolianbiao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.jiyun.greendaoduolianbiao.dao.DaoSession;
import com.jiyun.greendaoduolianbiao.dao.TwoStudentDao;
import com.jiyun.greendaoduolianbiao.dao.OneDao;

/**
 * 高山仰止,景行行止.虽不能至,心向往之。
 * Created by de'l'l on 2018/9/12.
 */

@Entity
public class One {
    @Id
    private Long id;
    private String name;
    //把Id作为外建存储到TwoStudent的oneId
    @ToMany(joinProperties = {@JoinProperty(name="id",referencedName = "oneId")})
    private List<TwoStudent>twostudents;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 906847902)
    private transient OneDao myDao;
    @Generated(hash = 299086881)
    public One(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 1073040421)
    public One() {
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
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1668503976)
    public List<TwoStudent> getTwostudents() {
        if (twostudents == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TwoStudentDao targetDao = daoSession.getTwoStudentDao();
            List<TwoStudent> twostudentsNew = targetDao._queryOne_Twostudents(id);
            synchronized (this) {
                if (twostudents == null) {
                    twostudents = twostudentsNew;
                }
            }
        }
        return twostudents;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1936782039)
    public synchronized void resetTwostudents() {
        twostudents = null;
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
    @Generated(hash = 669627017)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getOneDao() : null;
    }

    @Override
    public String toString() {
        return "One{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", twostudents=" + twostudents +
                ", daoSession=" + daoSession +
                ", myDao=" + myDao +
                '}';
    }
}
