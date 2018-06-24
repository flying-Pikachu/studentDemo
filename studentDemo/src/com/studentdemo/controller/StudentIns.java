package com.studentdemo.controller;

import com.studentdemo.been.Student;
import com.studentdemo.dao.StudentDao;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 上午10:54 2018/6/22
 * @ Description：This servlet can handle student's information insert requests
 * @ Modified By：
 * @Version: $version$
 */
@WebServlet(name = "StudentIns")
public class StudentIns extends HttpServlet {
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

        System.out.println(sno + " " + sname + " " + chinese + " " + math + " " +english);
        // 做插入的时候，首先需要检测输入的学号与姓名是否存在在数据库中，如果存在，分数如果已经有了，就进行覆盖，否则进行插入
        boolean isExist = StudentDao.isExit(sno, sname);
        System.out.println(isExist);
        PrintWriter pw = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        List<Student> list = StudentDao.getSomeStudentBySnoAndSname(sno, sname);
        if (isExist && list.size() != 0) {
            // 存在，执行更新
            boolean isUpdate = StudentDao.updateAStudentInformation(sno, sname, chinese, math, english);
            if (isUpdate) {
                // 更新成功，返回添加成功界面
                jsonObject.put("isSuccess", true);
                jsonObject.put("sno", sno);
                jsonObject.put("sname", sname);
                jsonObject.put("chinese", chinese);
                jsonObject.put("math", math);
                jsonObject.put("english", english);
            } else {
                // 更新失败，返回添加界面
                jsonObject.put("isSuccess", false);
            }
        } else {
            // 不存在，执行插入
            boolean isInsert = StudentDao.insertAStudentScore(sno, sname, chinese, math, english);
            if (isInsert) {
                // 插入成功，返回添加成功界面
                jsonObject.put("isSuccess", true);
                jsonObject.put("sno", sno);
                jsonObject.put("sname", sname);
                jsonObject.put("chinese", chinese);
                jsonObject.put("math", math);
                jsonObject.put("english", english);
            } else {
                // 添加失败，返回添加界面
                jsonObject.put("isSuccess", false);
            }
        }
        System.out.println(jsonObject.toString());
        pw.write(jsonObject.toString());
    }
}
