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
 * @ Date       ：Created in 上午10:54 2018/6/22
 * @ Description：This servlet can handle student's information delete requests
 * @ Modified By：
 * @Version: $version$
 */
@WebServlet(name = "StudentDel")
public class StudentDel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int getSno = Integer.parseInt(request.getParameter("sno"));
        boolean isDel = StudentDao.delAStudentInformationBySno(getSno);
        if (isDel) {
            // 删除成功
            request.getRequestDispatcher("deleteSuc.jsp?sno="+getSno).forward(request, response);
        } else {
            // 删除失败，返回删除界面
            request.getRequestDispatcher("searchStudent.html").forward(request, response);
        }
    }
}
