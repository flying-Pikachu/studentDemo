package com.studentdemo.dao;

import com.studentdemo.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 上午10:34 2018/6/22
 * @ Description：this class the operation of the class of teacher
 * @ Modified By：
 * @Version: $version$
 */
public class TeacherDao {
    /**
     * create by: xzp
     * description:this function check the teacher's login information
     * create time: 上午10:36 2018/6/22
     *
     * @param tno the number of the teacher's no
     * @param tpas the number of the teacher's pas
     *
     * @return com.studentdemo.been.Teacher
     * @throws SQLException
     */
    public static boolean checkLogin(int tno, String tpas) {
        String sql = "SELECT tpas FROM teacher WHERE tno = ?";
        Connection conn = DBHelper.conn();
        ResultSet rs = null;
        String password = "";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, tno);
            rs = pst.executeQuery();
            if (rs.next()) {
                password = rs.getString(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return password.equals(tpas);
    }

    /**
     * create by: xzp
     * description:
     * create time: 上午11:03 2018/6/22
     *
     * @param tno the number of the teacher's no
     * @param tpas the number of the teacher's pas
     * @param ttel the number of the teacher's tel
     * @return boolean
     * @throws SQLException when
     */
    public static boolean insertATeacher(int tno, String tpas, String ttel) {
        String sql = "INSERT INTO teacher(tno, tpas, ttel) VALUES(?, ?, ?)";
        Connection conn = DBHelper.conn();
        PreparedStatement pst = null;
        int i = 0;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, tno);
            pst.setString(2, tpas);
            pst.setString(3, ttel);
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
