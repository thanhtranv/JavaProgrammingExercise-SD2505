package Exercise;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



class Course {
	String courseId;
	String courseName;
	String instructor;
	String startDate;
	String lessons;
	String level;
	
	public Course() {

	}

	public Course(String courseId, String courseName, String instructor, String startDate, String lessons, String level) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.instructor = instructor;
		this.startDate = startDate;
		this.lessons = lessons;
		this.level = level;
	}
	
	List<Course> parseCourseObject(JSONArray infoList) {
		List<Course> in = new ArrayList<>();
		
		for (int i = 0; i < infoList.size(); i++) {
			JSONObject info = (JSONObject) infoList.get(i);
			
			String courseId = info.get("courseId").toString();
			String courseName = info.get("courseName").toString();
			String instructor = info.get("instructor").toString();
			String startDate = info.get("startDate").toString();
			String lessons = info.get("lessons").toString();
			String level = info.get("level").toString();

			in.add(new Course(courseId, courseName, instructor, startDate, lessons, level));
		}
		
		return in;
	}
	
	public void filterByLevel(List<Course> infoList, String level) {
		System.out.printf("Courses are fitered by level %s: \n", level);
		for (int i = 0; i < infoList.size(); i++) {
			if (infoList.get(i).level.equals(level.trim())) {
				System.out.println(infoList.get(i).courseName);
			}
		}
	}
	
	public void filterByInstructor(List<Course> infoList, String instructor) {
		System.out.printf("Courses are fitered by instructor %s: \n", instructor);
		for (int i = 0; i < infoList.size(); i++) {
			if (infoList.get(i).instructor.toLowerCase().equals(instructor.trim().toLowerCase())) {
				System.out.println(infoList.get(i).courseName);
			}
		}
	}
	
	public void filterByLevelAndLessons(List<Course> infoList, String level, String lessons) {
		System.out.printf("Courses are fitered by level %s and lessons %s: \n", level, lessons);
		for (int i = 0; i < infoList.size(); i++) {
			if (infoList.get(i).level.equals(level.trim()) && infoList.get(i).lessons.equals(lessons.trim())) {
				System.out.println(infoList.get(i).courseName);
			}
		}
	}
	
	public void findCourse(List<Course> infoList, String keyword) {
		System.out.printf("Courses are fitered by keyword %s: \n", keyword);
		for (int i = 0; i < infoList.size(); i++) {
			if (infoList.get(i).courseName.toLowerCase().contains(keyword.trim().toLowerCase())) {
				System.out.println(infoList.get(i).courseName);
			}
		}
	}
}


public class Exercise3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// JSON parser object to parse read file
		List<Course> courseList = new ArrayList<Course>();
		
		Course c = new Course();
		
		Scanner sc = new Scanner(System.in);

		courseList = parseJsonFileToArrayObject("data.json");
		
		System.out.print("Enter the level to filter: ");
        
        String level = sc.nextLine();
        
        c.filterByLevel(courseList, level);
        
        System.out.print("Enter the instructor to filter: ");
        
        String instructor = sc.nextLine();
        
        c.filterByInstructor(courseList, instructor);
        
        System.out.print("Enter the level: ");
        
        String level1 = sc.nextLine();
        
        System.out.print("And enter the lesson to filter: ");
        
        String lessons = sc.nextLine();
        
        c.filterByLevelAndLessons(courseList, level1, lessons);
        
        System.out.print("Enter the keyword to find course: ");
        
        String keyword = sc.nextLine();
        
        c.findCourse(courseList, keyword);
        
	}
	
	public static List<Course> parseJsonFileToArrayObject(String file) {
		List<Course> courseList = null;
		JSONParser jsonParser = new JSONParser();
		
		try {
			URL resource = Exercise3.class.getClassLoader().getResource(file);
	        
	        FileReader reader = new FileReader(resource.getFile());

			// Read JSON file
	        JSONObject  obj = (JSONObject) jsonParser.parse(reader);
			
			JSONArray infoList = (JSONArray) obj.get("courses");
			
			Course course = new Course();
			
			courseList = course.parseCourseObject(infoList);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return courseList;
	}

}
