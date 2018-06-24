package com.studentdemo.controller;

import com.studentdemo.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 上午10:55 2018/6/22
 * @ Description：This servlet can handle student's information uupdate requests
 * @ Modified By：
 * @Version: $version$
 */
@WebServlet(name = "StudentUpd")
public class StudentUpd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sno = 0;
        String sname= "";
        int chinese = 0;
        int math = 0;
        int english = 0;

        String getSno = request.getParameter("sno");
        String getSname = request.getParameter("sname");
        String getChinese = request.getParameter("chinese");
        String getMath = request.getParameter("math");
        String getEnglish = request.getParameter("english");

        if (getSname != null && !getSname.equals(""))
            sname = getSname;
            // 前端进行空传入控制
        else {

        }


        try {
            if (getChinese != null && !getChinese.equals(""))
                chinese = Integer.parseInt(getChinese);
                // 前端进行控制
            else {

            }
        } catch (NumberFormatException e) {
            // 传入非数字检测
            // 可以在前端进行操作
            // 测试的时候就进入了默认账号
            chinese = 0;
        }

        try {
            if (getMath != null && !getMath.equals(""))
                math = Integer.parseInt(getMath);
                // 前端进行控制
            else {

            }
        } catch (NumberFormatException e) {
            // 传入非数字检测
            // 可以在前端进行操作
            // 测试的时候就进入了默认账号
            math = 0;
        }

        try {
            if (getEnglish != null && !getEnglish.equals(""))
                english = Integer.parseInt(getEnglish);
                // 前端进行控制
            else {

            }
        } catch (NumberFormatException e) {
            // 传入非数字检测
            // 可以在前端进行操作
            // 测试的时候就进入了默认账号
            english = 0;
        }

        try {
            if (getSno != null && !getSno.equals(""))
                sno = Integer.parseInt(getSno);
                // 前端进行控制
            else {

            }
        } catch (NumberFormatException e) {
            // 传入非数字检测
            // 可以在前端进行操作
            // 测试的时候就先默认为1010，之后再
            sno = 1010;
        }

        System.out.println(sno + " " + sname + " " + chinese + " " + math + " " + english);
        boolean isUpdate = StudentDao.updateAStudentInformation(sno, sname, chinese, math, english);
        if (isUpdate) {
            // 更新完成
            request.getRequestDispatcher("updateSuc.jsp?sno="+ sno +"&sname=" + sname + "&chinese=" + chinese + "&math=" + math + "&english" + english).forward(request, response);
        } else {
                // 更新失败，返回更新界面
            request.getRequestDispatcher("searchStudent.html").forward(request, response);
        }

    }
}
