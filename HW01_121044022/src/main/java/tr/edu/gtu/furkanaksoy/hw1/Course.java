package tr.edu.gtu.furkanaksoy.hw1;

import tr.edu.gtu.furkanaksoy.hw1.Assignment;
import tr.edu.gtu.furkanaksoy.hw1.permissions.*;

import java.util.ArrayList;

/**
 * Course takes lots of array list about course staff.
 * it has user, document and assignment.
 * @author MUSTAFA
 * @created 22-Þub-2016 20:05:38
 */
public class Course {

	private ArrayList<User> enrolledStudents = new ArrayList<User>();
	private String name;
	private String surname;
	private int year;
	private static final ArrayList<Course> oldCourses = new ArrayList<Course>();
	private String teacher;
	private static final ArrayList<Course> activeCourses = new ArrayList<Course>();
	private static final int CURRENT_YEAR = 2016;

	public User courseUsers;
	public ArrayList<Document> allDocuments = new ArrayList<Document>();
	public ArrayList<Document> controlDocuments = new ArrayList<Document>();
	public Assignment m_Assignment;

	/**
	 * default constructer to add new course.
	 */
	public Course(){
		activeCourses.add(this);
	}

	/**
	 * constructer to set parameters and add or remove course.
	 * @param courseName to set name of course.
	 * @param teacherName to set teacher name of course.
	 * @param teacherSurname to set teacher last name of course.
	 * @param courseYear to set year of course.
	 */
	public Course(String courseName, String teacherName, String teacherSurname, int courseYear){
		name 	= courseName;
		teacher = teacherName;
		surname = teacherSurname;
		year	= courseYear;
// if course is on current year, add to active course list.
// if course is not active, add to old course list.
		if (courseYear == CURRENT_YEAR)
			activeCourses.add(this);
		else
			oldCourses.add(this);
	}

	/**
	 * return name of course.
	 * @return
	 */
	public String getName(){
		return(name);
	}

	/**
	 * return teacher last name of course.
	 * @return
	 */
	public String getSurname(){
		return(surname);
	}

	/**
	 * return year of course.
	 * @return
	 */
	public int getYear(){
		return(year);
	}

	/**
	 * return name of course teacher.
	 * @return
	 */
	public String getTeacher(){
		return(teacher);
	}

	/**
	 * return student who enrolled the course.
	 * @return
	 */
	public ArrayList<User> getEnrolledStudents(){
		return(enrolledStudents);
	}

	/**
	 * return course which is active
	 * @return
	 */
	public ArrayList<Course> getActiveCourses(){
		return(activeCourses);
	}

	/**
	 * return course which is not active.
	 * @return
	 */
	public ArrayList<Course> getOldCourses() {
		return(oldCourses);
	}

	/**
	 * set name of course.
	 * @param courseName
	 */
	public void setName(String courseName){
		name = courseName;
	}

	/**
	 * set teacher last name of course.
	 * @param teacherSurname
	 */
	public void setSurname(String teacherSurname){
		surname = teacherSurname;
	}

	/**
	 * set teacher name of course.
	 * @param teacherName
	 */
	public void setTeacher(String teacherName){
		teacher = teacherName;
	}

	/**
	 * set year of course.
	 * @param courseYear
	 */
	public void setYear(int courseYear){year = courseYear;}

	/**
	 * overrided to string to get good interface.
	 * @return
	 */
	@Override
	public String toString(){
		StringBuilder result = new StringBuilder();

		result.append("Course Name		:" + getName() + "\n");
		result.append("Course Teacher	:" + getTeacher() + " " + getSurname() + "\n");
		result.append("Course Year		:" + getYear() + "\n");
		return(result.toString());
	}

	/**
	 * Teacher can add users, tutors
	 * @param id uses to find correct user.
	 */
	public void addCourseStaff(User id) {
// permission controlled.
		for (UserPermission check : courseUsers.initPermissions())
			if (check instanceof AddAssignPermission) {
// user controlled who is also added to list.
				int i = 0;
				for (User look : enrolledStudents) {
					if (id.getId() == look.getId()) {
						System.out.println("User has seen in system.");
						return;
					}
					++i;
				}
// add student.
				enrolledStudents.add(id);
				return;
			}
// permission error.
		System.out.println("Permission denied.");
	}

	/**
	 * method to print courses which is not active.
	 * @param show uses to compare old courses.
	 */
	public void viewOldCourse(String show) {
// permission check.
		for (UserPermission check : courseUsers.initPermissions())
			if (check instanceof ViewOldCoursePermission) {
				for (Course look : oldCourses)
					if(show.equals(look.getName()))
						System.out.println(look);
				return;
			}
		System.out.println("Permission Denied!");
	}

	/**
	 * method uses to remove course.
	 * @param delete name of course which is want to remove.
	 */
	public void removeCourse(String delete){

		for (UserPermission look : courseUsers.initPermissions())
			if (look instanceof RemoveCoursePermission) {
				int i=0;
				for (Course check : activeCourses){
					if(check.getName().equals(delete))
						activeCourses.remove(i);
					++i;
				}
			}
	}

	/**
	 * Teacher can add documents
	 * @param something type of documents to find correct type
	 * documents name which teacher want to add
	 */
	public void addCourseStaff(Document something,String doc) {
// add control documents
		controlDocuments.add(new Book());
		controlDocuments.add(new File());
		controlDocuments.add(new Slide());
		controlDocuments.add(new Url());
		controlDocuments.add(new WhiteboardDescription());
// permission controlled.
		for (UserPermission look : courseUsers.initPermissions())
			if (look instanceof AddCourseStaffPermission) {
// documents controls.
// add new document to all documents list.
				for (Document check : controlDocuments){
					if (check instanceof Book){
						((Book) check).setName(doc);
						allDocuments.add(check);
					}
					else if (check instanceof File)
					{
						((File) check).setName(doc);
						allDocuments.add(check);
					}
					else if (check instanceof Slide)
					{
						((Slide) check).setName(doc);
						allDocuments.add(check);
					}
					else if (check instanceof Url){
						((Url) check).setName(doc);
						allDocuments.add(check);
					}
					else if (check instanceof WhiteboardDescription){
						((WhiteboardDescription) check).setName(doc);
						allDocuments.add(check);
					}
				}
			}
	}
}