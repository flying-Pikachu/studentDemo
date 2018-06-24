package com.studentdemo.controller;

import com.studentdemo.dao.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 上午10:16 2018/6/22
 * @ Description：This servlet can handle login requests
 */
@WebServlet(name = "Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int teacherNum = 0;
        String teacherPassword = "";
        String getTeacherNum = request.getParameter("tno");
        String getTeacherPas = request.getParameter("tpas");
        System.out.println(getTeacherNum + " " + getTeacherPas);


        if (!getTeacherPas.equals("") && getTeacherPas != null)
            teacherPassword = getTeacherPas;
            // 前端进行空传入控制
        else {

        }

        try {
            if (!getTeacherNum.equals("") && getTeacherNum != null)
                teacherNum = Integer.parseInt(getTeacherNum);
                // 前端进行控制
            else {

            }
        } catch (NumberFormatException e) {
            // 传入非数字检测
            // 可以在前端进行操作
            // 测试的时候就进入了默认账号
            teacherNum = 1;
        }

        System.out.println(teacherNum + " " + teacherPassword);
        boolean isSucce = TeacherDao.checkLogin(teacherNum, teacherPassword);
        if (isSucce) {
            // 登录成果转入学生成绩搜索界面
            request.getRequestDispatcher("searchStudent.html").forward(request, response);
        } else {
            // 没有登录成功转回登录界面
            request.getRequestDispatcher("login.html").forward(request, response);
        }
    }
}
