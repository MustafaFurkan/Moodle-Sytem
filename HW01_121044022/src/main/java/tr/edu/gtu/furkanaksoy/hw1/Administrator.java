package tr.edu.gtu.furkanaksoy.hw1;

import tr.edu.gtu.furkanaksoy.hw1.permissions.*;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Administrator extends abstract class of user.
 * It has lots of permission to change system
 * @author MUSTAFA
 * Created by MUSTAFA on 20.02.2016.
 */
public class Administrator extends User {

    private static final int CURRENT_YEAR = 2016;

    /**
     * Constructer call super class(abstract user)
     */
    Administrator(){
        super();
    }

    /**
     * Constructer call super class(abstract user)
     * @param adminName is name of administrator
     * @param adminSurname is surname of administrator
     * @param adminPassword is password of administrator
     * @param adminId is ssn of administrator
     */
    Administrator(String adminName, String adminSurname, String adminPassword, int adminId){
        super(adminName,adminSurname,adminPassword,adminId);
    }

    /**
     * Permission was overridded to get own permission.
     * @return value as a permission array list
     */
    @Override
    protected ArrayList<UserPermission> initPermissions() {
        ArrayList<UserPermission> adminPermission = new ArrayList<UserPermission>();

        adminPermission.add(new RemoveUserPermisssion());
        adminPermission.add(new RemoveCoursePermission());
        adminPermission.add(new ViewOldCoursePermission());

        return(adminPermission);
    }

    /**
     * toString was overridded to show good interface.
     * @return value as a toString.
     */
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
// String Builder used to quick and smart interface.
        result.append("Name     :" + getName() + "\n");
        result.append("Surname  :" + getSurname() + "\n");
        result.append("Password :" + getPassword() + "\n");
        result.append("Id       :" + getId() + "\n");

        return(result.toString());
    }

    /**
     * Administrator can add new admin.
     * @param addAdmin to creat new object of administrator.
     * @return new object if it's permission supports.
     */
    public Administrator addUser(Administrator addAdmin){

        for (UserPermission check : initPermissions())
            if (check instanceof AddUserPermission)
                return(addAdmin);
        return(null);
    }

    /**
     * Administrator can add teacher.
     * @param addTeacher to creat new object of teacher.
     * @return new object if it's permission supports.
     */
    public Teacher addUser(Teacher addTeacher){
        for (UserPermission check : initPermissions())
            if (check instanceof AddUserPermission)
                return(addTeacher);
        return(null);
    }

    /**
     * Administrator can add student.
     * @param addStudent to creat new object of student.
     * @return new object if it's permission supports.
     */
    public Student addUser(Student addStudent){
        for (UserPermission check : initPermissions())
            if (check instanceof AddUserPermission)
                return(addStudent);
        return(null);
    }

    /**
     * Administrator can add student.
     * @param addTutor to creat new object of tutor.
     * @return new object if it's permission supports.
     */
    public Tutor addUser(Tutor addTutor){
        for (UserPermission check : initPermissions())
            if (check instanceof AddUserPermission)
                return(addTutor);
        return(null);
    }

    /**
     * Administrator can add new course.
     * @param courseName is name of course.
     * @param teacherName is name of course's teacher.
     * @param teacherSurname is last name of course's teacher.
     * @param courseYear is year of course.
     * @return new object if it's permission supports.
     */
    public Course addCourse(String courseName, String teacherName, String teacherSurname, int courseYear){
        for (UserPermission check : initPermissions())
            if (check instanceof AddCoursePermission)
                return(new Course(courseName,teacherName,teacherSurname,courseYear));
        return(null);
    }
}
