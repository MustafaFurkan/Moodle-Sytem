package tr.edu.gtu.furkanaksoy.hw1;

import tr.edu.gtu.furkanaksoy.hw1.permissions.UserPermission;

import java.util.ArrayList;

/**
 * abstract class to show all user.
 * it has lots of permission.
 * @author MUSTAFA
 * Created by MUSTAFA on 21.02.2016.
 */
abstract class User {

    private String name;
    private String surname;
    private String password;
    private int id;

    public static final ArrayList<User> allUsers = new ArrayList<User>();

    /**
     * set name of user.
     * @param adminName
     */
    public void setName(String adminName){
        name = adminName;
    }

    /**
     * set last name of user.
     * @param adminSurname
     */
    public void setSurname(String adminSurname){
        surname = adminSurname;
    }

    /**
     * set password of user.
     * @param adminPassword
     */
    public void setPassword(String adminPassword) {
        password = adminPassword;
    }

    /**
     * set ssn of user.
     * @param adminId
     */
    public void setId(int adminId) {
        id = adminId;
    }

    /**
     * get name of user.
     * @return
     */
    public String getName(){
        return(name);
    }

    /**
     * get last name of user.
     * @return
     */
    public String getSurname(){
        return(surname);
    }

    /**
     * get password of user.
     * @return
     */
    public String getPassword() {
        return(password);
    }

    /**
     * get ssn od user.
     * @return
     */
    public int getId() {
        return(id);
    }

    /**
     * get all users.
     * @return
     */
    public ArrayList<User> getAllUsers(){return(allUsers);}

    /**
     * constructer to add users.
     */
    public User(){
        allUsers.add(this);
    }

    /**
     * constructer to add users.
     * @param userName to set name of user.
     * @param userSurname to set last name of user.
     * @param userPassword to set password of user.
     * @param userId to set ssn of user.
     */
    public User(String userName, String userSurname, String userPassword, int userId){

        name    = userName;
        surname = userSurname;
        password= userPassword;
        id      = userId;
        allUsers.add(this);
    }

    /**
     * toString shows description with smart and good interface.
     * @return
     */
    @Override
    public String toString(){
      StringBuilder result = new StringBuilder();
// used string builder to creat faster.
        result.append("Name     :" + getName() + "\n");
        result.append("Surname  :" + getSurname() + "\n");
        result.append("Password :" + getPassword() + "\n");
        result.append("Id       :" + getId() + "\n");

        return(result.toString());
    }

    /**
     * to add administrator.
     * @param addAdmin
     * @return
     */
    protected abstract Administrator addUser(Administrator addAdmin);

    /**
     * to add teacher.
     * @param addTeacher
     * @return
     */
    protected abstract Teacher addUser(Teacher addTeacher);

    /**
     * to add student.
     * @param addStudent
     * @return
     */
    protected abstract Student addUser(Student addStudent);

    /**
     * to add tutor.
     * @param addTutor
     * @return
     */
    protected abstract Tutor addUser(Tutor addTutor);

    /**
     * to add new course.
     * @param courseName
     * @param teacherName
     * @param teacherSurname
     * @param courseYear
     * @return
     */
    protected abstract Course addCourse(String courseName, String teacherName, String teacherSurname, int courseYear);

    /**
     * method for creat own permission list.
     * @return
     */
    protected abstract ArrayList<UserPermission> initPermissions();
}
