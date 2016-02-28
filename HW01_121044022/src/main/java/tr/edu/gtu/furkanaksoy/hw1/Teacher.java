package tr.edu.gtu.furkanaksoy.hw1;

import tr.edu.gtu.furkanaksoy.hw1.permissions.*;

import java.util.ArrayList;

/**
 * Teacher extends abstract user class.
 * Teacher has a permission to use system.
 * @author MUSTAFA
 * Created by MUSTAFA on 21.02.2016.
 */
public class Teacher extends User {
    /**
     * Constructer uses super class constructer.
     */
    Teacher(){
        super();
    }

    /**
     * Constructer uses seuper class constructer.
     * @param teacherName is name of teacher.
     * @param teacherSurname is name of last name of teacher.
     * @param teacherPassword is password of teacher.
     * @param teacherId is ssn of teacher.
     */
    Teacher(String teacherName, String teacherSurname, String teacherPassword, int teacherId){
        super(teacherName,teacherSurname,teacherPassword,teacherId);
    }

    /**
     * method overrided to add if it has a permission.
     * @param addAdmin to add administractor.
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
     * method to add course which is not denied
     * @param courseName is name of course.
     * @param teacherName is name of course teacher.
     * @param teacherSurname is last name of course teacher.
     * @param courseYear is year of course.
     * @return new course object.
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
        ArrayList<UserPermission> teacherPermission = new ArrayList<UserPermission>();

        teacherPermission.add(new ViewOldCoursePermission());
        teacherPermission.add(new RemoveCourseStaffPermisssion());
        teacherPermission.add(new AddAssignPermission());

        return(teacherPermission);
    }
}
