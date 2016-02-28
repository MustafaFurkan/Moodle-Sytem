package tr.edu.gtu.furkanaksoy.hw1;

import tr.edu.gtu.furkanaksoy.hw1.permissions.*;

import java.util.ArrayList;

/**
 * Student extends abstract user.
 * Student has permissions to use system.
 * @author MUSTAFA
 * Created by MUSTAFA on 21.02.2016.
 */
public class Student extends User {
    /**
     * constructer call abstract class to set.
     */
    Student(){
        super();
    }

    /**
     * constructer sets in super class(abstract class of user)
     * @param studentName to set name of student.
     * @param studentSurname to set last name of student.
     * @param studentPassword to set password of student.
     * @param studentId to set ssn of student.
     */
    Student(String studentName, String studentSurname, String studentPassword, int studentId){
        super(studentName,studentSurname,studentPassword,studentId);
    }

    /**
     * method overrided to add if it has a permission.
     * @param addAdmin to add administrator.
     * @return null if permission denied.
     */
    @Override
    protected Administrator addUser(Administrator addAdmin){
        for (UserPermission check : initPermissions())
            if (check instanceof AddUserPermission)
                return(addAdmin);
        return(null);
    }

    /**
     * method overrided to add if it has a permission.
     * @param addTeacher to add teacher.
     * @return null if permission denied.
     */
    @Override
    protected Teacher addUser(Teacher addTeacher){
        for (UserPermission check : initPermissions())
            if (check instanceof AddUserPermission)
                return(addTeacher);
        return(null);
    }

    /**
     * method overrided to add if it has a permission.
     * @param addStudent to add student.
     * @return null if permission denied.
     */
    @Override
    protected Student addUser(Student addStudent){
        for (UserPermission check : initPermissions())
            if (check instanceof AddUserPermission)
                return(addStudent);
        return(null);
    }

    /**
     * method overrided to add if it has a permission.
     * @param addTutor to add tutor.
     * @return null if permission denied.
     */
    @Override
    protected Tutor addUser(Tutor addTutor){
        for (UserPermission check : initPermissions())
            if (check instanceof AddUserPermission)
                return(addTutor);
        return(null);
    }

    /**
     * method to add new course if it has permission
     * @param courseName is name of course
     * @param teacherName is teacher name of course.
     * @param teacherSurname is teacher last name of course.
     * @param courseYear is year of course.
     * @return new object if user has a permission.
     */
    @Override
    protected Course addCourse(String courseName, String teacherName, String teacherSurname, int courseYear){
        for (UserPermission check : initPermissions())
            if (check instanceof AddCoursePermission)
                return(new Course(courseName,teacherName,teacherSurname,courseYear));
        return(null);
    }

    /**
     * permission list to control other methods.
     * @return new object of permission.
     */
    @Override
    protected ArrayList<UserPermission> initPermissions() {
        ArrayList<UserPermission> userPermissions = new ArrayList<UserPermission>();

        userPermissions.add(new EnrollablePermission());
        userPermissions.add(new LoadAssignPermission());
        userPermissions.add(new ViewStudentStaffPermission());

        return(userPermissions);
    }
}
