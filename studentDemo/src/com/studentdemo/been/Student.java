package com.studentdemo.been;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 上午9:13 2018/6/22
 * @ Description：this class is the class of Student which package the students information
 * @ Modified By：
 */
public class Student {
    private int sno;
    private String sname;
    private int chinese;
    private int math;
    private int english;

    public Student() {

    }
    public Student(int sno, String sname, int chinese, int math, int english) {
        this.sno = sno;
        this.sname = sname;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public int getSno() {
        return sno;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSname() {
        return sname;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getMath() {
        return math;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getEnglish() {
        return english;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getChinese() {
        return chinese;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
