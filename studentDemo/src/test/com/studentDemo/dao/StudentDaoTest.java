package test.com.studentDemo.dao; 

import com.studentdemo.been.Student;
import com.studentdemo.dao.StudentDao;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* StudentDao Tester. 
* 
* @author <Authors name> 
* @since <pre>六月 22, 2018</pre> 
* @version 1.0 
*/ 
public class StudentDaoTest { 

@Before
public void before() {
} 

@After
public void after() {
} 

/** 
* 
* Method: chechConnectiong() 
* 
*/ 
@Test
public void testChechConnectiong() {
//TODO: Test goes here... 
} 

/** 
* 
* Method: getAllStudent() 
* 
*/ 
@Test
public void testGetAllStudent() {
//TODO: Test goes here...
    for (Student s : StudentDao.getAllStudent())
        System.out.println(s.getSno());
} 

/** 
* 
* Method: getSomeStudentBySno(int sno) 
* 
*/ 
@Test
public void testGetSomeStudentBySno() {
//TODO: Test goes here...
    for (Student s : StudentDao.getSomeStudentBySno(1003))
        System.out.println(s.getSno());
} 

/** 
* 
* Method: getSomeStudentBySname(String sname) 
* 
*/ 
@Test
public void testGetSomeStudentBySname() {
//TODO: Test goes here...
    for (Student s : StudentDao.getSomeStudentBySname("1"))
        System.out.println(s.getSno());
} 

/** 
* 
* Method: getSomeStudentBySnoAndSname(int sno, String sname) 
* 
*/ 
@Test
public void testGetSomeStudentBySnoAndSname() {
//TODO: Test goes here...
    for (Student s : StudentDao.getSomeStudentBySnoAndSname(1001, "1"))
        System.out.println(s.getSno());
} 

/** 
* 
* Method: isExit(int sno, String sname) 
* 
*/ 
@Test
public void testIsExit() {
//TODO: Test goes here...
    System.out.println(StudentDao.isExit(1001, "1"));
} 

/** 
* 
* Method: insertAStudentScore(int sno, String sname, int chinese, int math, int english) 
* 
*/ 
@Test
public void testInsertAStudentScore() {
//TODO: Test goes here...
    System.out.println(StudentDao.insertAStudentScore(1007,"7", 5, 5, 5));
} 

/** 
* 
* Method: updateAStudentInformation(int sno, String sname, int chinese, int math, int english) 
* 
*/ 
@Test
public void testUpdateAStudentInformation() {
//TODO: Test goes here...
    System.out.println(StudentDao.updateAStudentInformation(1006, "6", 99,  99, 99));
} 

/** 
* 
* Method: main(String[] args) 
* 
*/ 
@Test
public void testMain() {
//TODO: Test goes here... 
} 


} 
