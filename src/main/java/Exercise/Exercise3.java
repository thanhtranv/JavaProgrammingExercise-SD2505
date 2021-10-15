package Exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;


class Course {
	String courseId;
	String courseName;
	String instructor;
	String startDate;
	int lessons;
	int level;
	
	public void filterByLevel(int level) {
		
	}
	
	public void filterByInstructor(String instructor) {
		
	}
	
	public void filterByLevelAndLessons(int level, int lessons) {
		
	}
	
	public void findCourse(String keyword) {
		
	}
}


public class Exercise3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// JSON parser object to parse read file
		Course[] courseList = null;
		courseList = parseJsonFileToArrayObject("data.json");
		
		for (int i = 0; i < courseList.length; i++) {
			System.out.println(courseList[i]);
		}
	}
	
	public static Course[] parseJsonFileToArrayObject(String fileName) {
		String filePath = new File("").getAbsolutePath();
		filePath = filePath + "\\src\\main\\resources\\" + fileName;
		Course[] courseList = null;
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(filePath));
			Gson gson = new Gson(); 
			courseList = gson.fromJson(reader, Course[].class);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courseList;
	}

}
