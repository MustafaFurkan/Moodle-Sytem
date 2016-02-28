package tr.edu.gtu.furkanaksoy.hw1;

import tr.edu.gtu.furkanaksoy.hw1.permissions.EnrollablePermission;
import tr.edu.gtu.furkanaksoy.hw1.permissions.UserPermission;
import tr.edu.gtu.furkanaksoy.hw1.permissions.ViewAssignPermission;
import tr.edu.gtu.furkanaksoy.hw1.permissions.ViewOldCoursePermission;

import java.util.ArrayList;

/**
 * Tutor extends Students.
 * Tutor has permissions to use system.
 * @author MUSTAFA
 * Created by MUSTAFA on 21.02.2016.
 */
public class Tutor extends Student {
    /**
     * constructer call abstract class to set.
     */
   Tutor(){
       super();
   }

    /**
     * constructer sets in super class
     * @param tutorName is name of tutor.
     * @param tutorSurname is last name of tutor.
     * @param tutorPassword is password of tutor.
     * @param tutorId is ssn of tutor.
     */
   Tutor(String tutorName, String tutorSurname, String tutorPassword, int tutorId){
       super(tutorName,tutorSurname,tutorPassword,tutorId);
   }

    /**
     * permission list to control other methods.
     * @return new object of permission.
     */
    @Override
    protected ArrayList<UserPermission> initPermissions() {
        ArrayList<UserPermission> tutorPermission = new ArrayList<UserPermission>();

        tutorPermission.add(new ViewOldCoursePermission());
        tutorPermission.add(new EnrollablePermission());
        tutorPermission.add(new ViewAssignPermission());

        return(tutorPermission);
    }
}