package tr.edu.gtu.furkanaksoy.hw1;

import tr.edu.gtu.furkanaksoy.hw1.permissions.UserPermission;

import java.util.Iterator;

/**
 * Test functions
 * @author MUSTAFA
 * Created by MUSTAFA on 20.02.2016.
 */
public class Main {
    /**
     * main has test functions
     * @param args
     */
    public static void main(String[] args){

        System.out.println("---------------------------");
        System.out.println("----- Course Add Test -----");
        System.out.println("---------------------------");
// creat admin
        User u = new Administrator("ERKAN", "ZE", "123A123", 121044055);

        Course lecture, lec2;
        lecture = u.addCourse("Malzeme", "Eyup","Yazkan",2016);
        Course math1 = new Course("Bil-321", "Taha","Aksoy",2016);
        u.addCourse("Bilgisayar", "Mustafa", "Aksoy", 2014);


        for (Course checkCourse : lecture.getActiveCourses())
            System.out.println(checkCourse);

        System.out.println("-------------------------");
        System.out.println("----- User Add Test -----");
        System.out.println("-------------------------");

        Teacher th;
// admin also must be user
        th = u.addUser(new Teacher("Mustafa", "Aksoy", "123A123", 100044055));
        Student st = u.addUser(new Student("Sefa", "ttrr", "sad2asd", 21104466));
        Student st2 = u.addUser(new Tutor("Ahmet", "ttrr", "sad2asd", 6546466));

        for (User look : u.getAllUsers())
            System.out.println(look);

        System.out.println("---------------------------");
        System.out.println("----- Old Course Test -----");
        System.out.println("---------------------------");
// tutor can see
        System.out.println("Tutor:");
        lecture.courseUsers = st2;
        lecture.viewOldCourse("Bilgisayar");
        System.out.println("Teacher:");
        System.out.println("**************************");
// teacher can see
        lecture.courseUsers = th;
        lecture.viewOldCourse("Bilgisayar");

        System.out.println("---------------------------------");
        System.out.println("----- Add Course Staff Test -----");
        System.out.println("---------------------------------");
// teacher can add and remove course staff(users, tutors, documents)
// add tutor test
        System.out.println("Add tutor:");
        lecture.courseUsers = th;
        lecture.addCourseStaff(st2);
        System.out.println(lecture.getEnrolledStudents().get(0));
// add document test
        System.out.println("Add Document:");
        Document file1 = new File();
        lecture.addCourseStaff(file1,"abc.txt");

        for (Document docFile : lecture.allDocuments)
            if (docFile instanceof File){
                File temp = (File)docFile;
                System.out.println(temp.getName());
            }
    }

}
