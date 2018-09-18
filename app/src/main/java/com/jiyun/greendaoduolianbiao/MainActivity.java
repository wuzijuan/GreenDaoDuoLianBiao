package com.jiyun.greendaoduolianbiao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jiyun.greendaoduolianbiao.dao.DaoMaster;
import com.jiyun.greendaoduolianbiao.dao.DaoSession;
import com.jiyun.greendaoduolianbiao.dao.MuchStudentDao;
import com.jiyun.greendaoduolianbiao.dao.MuchTeacherDao;
import com.jiyun.greendaoduolianbiao.dao.OneDao;
import com.jiyun.greendaoduolianbiao.dao.StudentDao;
import com.jiyun.greendaoduolianbiao.dao.TeacherDao;
import com.jiyun.greendaoduolianbiao.dao.TeacherJoinStudentDao;
import com.jiyun.greendaoduolianbiao.dao.TwoStudentDao;

import org.greenrobot.greendao.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button insert;

    private StudentDao studentDao;
    private TeacherDao teacherDao;
    private Button load;
    private Button much_insert;
    private Button much_load;
    private Button duo_insert;
    private Button duo_load;
    private TwoStudentDao twoStudentDao;
    private OneDao oneDao;
    private MuchTeacherDao muchTeacherDao;
    private MuchStudentDao muchStudentDao;
    private TeacherJoinStudentDao teacherJoinStudentDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        //一对一
        DaoSession daoSession = DaoMaster.newDevSession(this, StudentDao.TABLENAME);
        studentDao = daoSession.getStudentDao();
        teacherDao = daoSession.getTeacherDao();
        //一对多
        DaoSession daoSession2 = DaoMaster.newDevSession(this, OneDao.TABLENAME);
        twoStudentDao = daoSession2.getTwoStudentDao();
        oneDao = daoSession2.getOneDao();
        //多对多
        DaoSession daoSession3 = DaoMaster.newDevSession(this, MuchTeacherDao.TABLENAME);
        muchTeacherDao = daoSession3.getMuchTeacherDao();
        muchStudentDao = daoSession3.getMuchStudentDao();
        teacherJoinStudentDao = daoSession3.getTeacherJoinStudentDao();



    }

    private void initView() {
        insert = (Button) findViewById(R.id.insert);
        insert.setOnClickListener(this);
        load = (Button) findViewById(R.id.load);
        load.setOnClickListener(this);
        much_insert = (Button) findViewById(R.id.much_insert);
        much_insert.setOnClickListener(this);
        much_load = (Button) findViewById(R.id.much_load);
        much_load.setOnClickListener(this);
        duo_insert = (Button) findViewById(R.id.duo_insert);
        duo_insert.setOnClickListener(this);
        duo_load = (Button) findViewById(R.id.duo_load);
        duo_load.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //一对一
            case R.id.insert:
                long id = studentDao.insert(new Student(null, "lisi"));
                teacherDao.insert(new Teacher(null, "张三", id));
                Log.d("----------", id + "");

                break;
            case R.id.load:
                List<Teacher> teachers = teacherDao.loadAll();
                for (int i = 0; i < teachers.size(); i++) {

                    Log.d("============", teachers.get(i).getStudent().toString());
                }

                break;

            case R.id.much_insert:
                //一对多
                long oneId = oneDao.insert(new One(null, "小张"));

                ArrayList<TwoStudent> students = new ArrayList<>();

                for (int i = 0; i <5 ; i++) {
                    students.add(new TwoStudent(null,"学生"+i,oneId));
                }
                twoStudentDao.insertInTx(students);


                break;
            case R.id.much_load:
                Query<One> build = oneDao.queryBuilder().build();
                List<One> list = build.list();
                One one = list.get(0);
                if (null!=one){
                    Log.d("一对多",one.getTwostudents().toString());
                }

                break;
            case R.id.duo_insert:
                //多对多
//2个教师和3个学生的关系
//教师1，带学生1、2
//教师2，带学生1、3
//学生1，选修教师1和教师2的课
                List<MuchTeacher> teacherList = new ArrayList<MuchTeacher>();
                for (long i = 1; i < 3; i++) {
                    MuchTeacher teacherBean = new MuchTeacher();
                    teacherBean.setTeacherId(i);
                    teacherList.add(teacherBean);
                }
                muchTeacherDao.insertInTx(teacherList);
                List<MuchStudent> studentList = new ArrayList<MuchStudent>();
                for (long j = 1; j < 4; j++) {
                    MuchStudent studentBean = new MuchStudent();
                    studentBean.setStudentId(j);
                    studentList.add(studentBean);
                }
                muchStudentDao.insertInTx(studentList);

                List<TeacherJoinStudent> teacherJoinStudentList = new ArrayList<TeacherJoinStudent>();
//教师1带学生1、2
                TeacherJoinStudent teacherJoinStudentBean1 = new TeacherJoinStudent(null,1l,1l);
                teacherJoinStudentList.add(teacherJoinStudentBean1);

                TeacherJoinStudent teacherJoinStudentBean2 = new TeacherJoinStudent(null,1l,2l);
                teacherJoinStudentList.add(teacherJoinStudentBean2);

//教师2带学生1、3
                TeacherJoinStudent teacherJoinStudentBean3 = new TeacherJoinStudent(null,2l,1l);
                teacherJoinStudentList.add(teacherJoinStudentBean3);

                TeacherJoinStudent teacherJoinStudentBean4 = new TeacherJoinStudent(null,2l,3l);
                teacherJoinStudentList.add(teacherJoinStudentBean4);
                teacherJoinStudentDao.insertInTx(teacherJoinStudentList);

                break;
            case R.id.duo_load:
                List<TeacherJoinStudent> teacherJoinStudents = teacherJoinStudentDao.loadAll();
                for (int i = 0; i <teacherJoinStudents.size() ; i++) {
                    Log.d("多对多",teacherJoinStudents.get(i).getSId()+teacherJoinStudents.get(i).getTId().toString());

                }

                break;
        }
    }
}
