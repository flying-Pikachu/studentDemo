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
 * @ Date       ：Created in 上午11:00 2018/6/22
 * @ Description：This servlet can handle registration requests
 */
@WebServlet(name = "/Register")
public class Register extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int tno = 0;
        String tpas = "";
        String ttel = "";
        String getTeacherRegiserNo = request.getParameter("tno");
        String getTeacherRegiserPas = request.getParameter("tps");
        String getTeacherRegiserTel = request.getParameter("ttel");
        if (getTeacherRegiserPas != null && !getTeacherRegiserPas.equals(""))
            tpas = getTeacherRegiserPas;
            // 前端进行空传入控制
        else {

        }

        if (getTeacherRegiserTel != null && !getTeacherRegiserTel.equals(""))
            ttel = getTeacherRegiserTel;
            // 前端进行空传入控制
        else {

        }

        try {
            if (getTeacherRegiserNo != null && !getTeacherRegiserNo.equals(""))
                tno = Integer.parseInt(getTeacherRegiserNo);
                // 前端进行控制
            else {

            }
        } catch (NumberFormatException e) {
            // 传入非数字检测
            // 可以在前端进行操作
            // 测试的时候就进入了默认账号
            tno = 1;
            tpas = "1";
            ttel = "1";
        }

        boolean isSuccessful = TeacherDao.insertATeacher(tno, tpas, ttel);

        if (isSuccessful) {
            request.getRequestDispatcher("registerSuc.html").forward(request, response);
        } else {
            request.getRequestDispatcher("register.html").forward(request, response);
        }
    }
}
