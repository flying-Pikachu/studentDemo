package test.com.studentDemo.dao; 

import com.studentdemo.dao.TeacherDao;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* TeacherDao Tester. 
* 
* @author <Authors name> 
* @since <pre>六月 22, 2018</pre> 
* @version 1.0 
*/ 
public class TeacherDaoTest { 

@Before
public void before() {
} 

@After
public void after() {
} 

/** 
* 
* Method: checkLogin(int tno, String tpas) 
* 
*/ 
@Test
public void testCheckLogin() {
//TODO: Test goes here...
    System.out.println(TeacherDao.checkLogin(1, "2"));
} 

/** 
* 
* Method: insertATeacher(int tno, String tpas, String ttel) 
* 
*/ 
@Test
public void testInsertATeacher() {
//TODO: Test goes here...
    System.out.println(TeacherDao.insertATeacher(4, "4", "4"));
} 


} 
