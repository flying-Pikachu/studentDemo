package com.studentdemo.dao;

import com.studentdemo.been.Student;
import com.studentdemo.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 上午9:16 2018/6/22
 * @ Description：this class the operation of the class of student
 * @ Modified By：
 * @Version: $version$
 */
public class StudentDao {

    /**
     * create by: xzp
     * description: this function can get all Students information
     * create time: 上午9:18 2018/6/22
     *
     * @return java.util.List<com.studentdemo.been.Student>
     * @throws SQLException
     */
    public static List<Student> getAllStudent() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM student";
        Student emp;
        Connection conn = DBHelper.conn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                emp = new Student();
                emp.setSno(rs.getInt(1));
                emp.setSname(rs.getString(2));
                emp.setChinese(rs.getInt(3));
                emp.setMath(rs.getInt(4));
                emp.setEnglish(rs.getInt(5));
                list.add(emp);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                pst.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * create by: xzp
     * description: this function can get the special student's information by his sno
     * create time: 上午9:20 2018/6/22
     *
     * @param sno the student's no
     * @return java.util.List<com.studentdemo.been.Student>
     * @throws SQLException
     */
    public static List<Student> getSomeStudentBySno(int sno) {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM student WHERE SNO = ?";
        Student emp;
        Connection conn = DBHelper.conn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, sno);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                emp = new Student();
                emp.setSno(rs.getInt(1));
                emp.setSname(rs.getString(2));
                emp.setChinese(rs.getInt(3));
                emp.setMath(rs.getInt(4));
                emp.setEnglish(rs.getInt(5));
                list.add(emp);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                pst.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * create by: xzp
     * description: this function can get the special students' information by their name
     * create time: 上午9:20 2018/6/22
     *
     * @param sname the name tend to search
     * @return java.util.List<com.studentdemo.been.Student>
     * @throws SQLException
     */
    public static List<Student> getSomeStudentBySname(String sname) {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM student WHERE SNAME= ?";
        Student emp;
        Connection conn = DBHelper.conn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, sname);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                emp = new Student();
                emp.setSno(rs.getInt(1));
                emp.setSname(rs.getString(2));
                emp.setChinese(rs.getInt(3));
                emp.setMath(rs.getInt(4));
                emp.setEnglish(rs.getInt(5));
                list.add(emp);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                pst.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * create by: xzp
     * description: this function can get the special student's information by his sno and sname
     * create time: 上午9:23 2018/6/22
     *
     * @param sno the student's no
     * @param sname the student's name
     * @return java.util.List<com.studentdemo.been.Student>
     * @throws SQLException
     */
    public static List<Student> getSomeStudentBySnoAndSname(int sno, String sname) {

        List<Student> list = new ArrayList<>();
        if (sname.equals("") && sno != 0)
            return getSomeStudentBySno(sno);
        else if (sno == 0 && !sname.equals(""))
            return getSomeStudentBySname(sname);
        else if (sno == 0 && sname.equals(""))
            return getAllStudent();
        else {
            return getSomeStudentBySno(sno);
        }
    }

    /**
     * create by: xzp
     * description: judge the student whoes no and name has given
     * create time: 上午11:16 2018/6/22
     *
     * @param sno the no of the student
     * @param sname the name of the student
     * @return boolean
     * @throws SQLException
     */
    public static boolean isExit(int sno, String sname) {
        return getSomeStudentBySnoAndSname(sno, sname).size() != 0;
    }

    /**
     * create by: xzp
     * description:
     * create time: 上午11:23 2018/6/22
     *
     * @param sno the student's no
     * @param english the student's english score
     * @param chinese the student's chinese score
     * @param math the student's math score
     * @param sname the student's name
     * @return boolean
     * @throws SQLException
     */
    public static boolean insertAStudentScore(int sno, String sname, int chinese, int math, int english) {
        String sql = "INSERT INTO student(sno, sname, chinese, math, english) VALUES(?, ?, ?, ?, ?)";
        Connection conn = DBHelper.conn();
        PreparedStatement pst = null;
        int i = 0;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, sno);
            pst.setString(2, sname);
            pst.setInt(3, chinese);
            pst.setInt(4, math);
            pst.setInt(5, english);
            i = pst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                pst.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return i >= 0;
    }

    /**
     * create by: xzp
     * description: update the student's information, don't update the sno
     * create time: 上午11:24 2018/6/22
     *
     * @param sno the student's no
     * @param sname the student's name
     * @param chinese the student's chinese score
     * @param english the student's english score
     * @param math the student's math score
     * @return boolean
     * @throws SQLException when
     */
    public static boolean updateAStudentInformation(int sno, String sname, int chinese, int math, int english) {
        String sql = "UPDATE student SET sname=?, chinese=?, math=?, english=? where sno=?";
        Connection conn = DBHelper.conn();
        PreparedStatement pst = null;
        int i = 0;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, sname);
            pst.setInt(2, chinese);
            pst.setInt(3, math);
            pst.setInt(4, english);
            pst.setInt(5, sno);
            i = pst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                pst.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return i >= 0;
    }

    /**
     * create by: xzp
     * description: delete a student information by its sno
     * create time: 下午11:47 2018/6/22
     *
     * @param sno the sno of the student
     * @return boolean
     * @throw SQLException when
     */
    public static boolean delAStudentInformationBySno(int sno) {
        String sql = "DELETE FROM student WHERE sno = ?";
        Connection conn = DBHelper.conn();
        PreparedStatement pst = null;
        int i = 0;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, sno);
            i = pst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                pst.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return i >= 0;
    }

}
