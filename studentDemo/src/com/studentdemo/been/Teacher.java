package com.studentdemo.been;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 上午10:32 2018/6/22
 * @ Description：this class is the class of Teacher which package the teacher's information
 * @ Modified By：
 * @Version: $version$
 */
public class Teacher {

    private int tno;
    private String tpas;
    private String ttel;


    public Teacher(int tno, String tpas, String ttel) {
        this.tno = tno;
        this.tpas = tpas;
        this.ttel =ttel;
    }

    //根据需要定义其他的构造函数

    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public String getTpas() {
        return tpas;
    }

    public void setTpas(String tpas) {
        this.tpas = tpas;
    }

    public String getTtel() {
        return ttel;
    }

    public void setTtel(String ttel) {
        this.ttel = ttel;
    }
}
