package com.studentdemo.controller;

import com.studentdemo.been.Student;
import com.studentdemo.dao.StudentDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 上午10:46 2018/6/22
 * @ Description：This servlet can handle student's information search requests
 * @ Modified By：
 * @Version: $version$
 */
@WebServlet(name = "/StudentSearch")
public class StudentSearch extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        int studentNum = 0;
        String studentName = "";
        String getStudentNum = request.getParameter("sno");
        String getStudentName = request.getParameter("name");

        System.out.println(getStudentNum);
        if (getStudentName != null && !getStudentName.equals(""))
            studentName = getStudentName;
            // 前端进行空传入控制
        else {

        }
        try {
            if (getStudentNum != null && !getStudentNum.equals(""))
                studentNum = Integer.parseInt(getStudentNum);
                // 前端进行控制
            else {

            }
        } catch (NumberFormatException e) {
            // 传入非数字检测
            // 可以在前端进行操作
            // 测试的时候就进入了默认账号
            studentNum = 1001;
            studentName = "1";
        }


        System.out.println(studentName + " " + studentNum);

        System.out.println(StudentDao.getSomeStudentBySnoAndSname(studentNum, studentName).size());
        PrintWriter pw = response.getWriter();
        JSONArray jsonArray = new JSONArray();
        for (Student s : StudentDao.getSomeStudentBySnoAndSname(studentNum, studentName)) {
            System.out.println(s.getSno());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("stuNum", s.getSno());
            jsonObject.put("stuName", s.getSname());
            jsonObject.put("stuChinese", s.getChinese());
            jsonObject.put("stuMath", s.getMath());
            jsonObject.put("stuEnglish", s.getEnglish());
            jsonArray.add(jsonObject);
        }
        System.out.println(jsonArray.toString());
        pw.write(jsonArray.toString());
    }
}
