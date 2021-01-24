package com.cdac.ELearning.service;

import java.util.List;

import com.cdac.ELearning.model.Course;
import com.cdac.ELearning.model.Problem;
import com.cdac.ELearning.model.Quiz;

public interface CourseService {
	
	
    void addQuiz(List<Quiz> quiz,String courseName);
    void addProblem(Problem problem, String courseName);
    void addQuizScore(String courseName,String score);
    void addCourse(Course course);
    List<Course> fetchAllCourses();
    void deleteCourse(String id);
    List<Quiz> getQuiz(String courseName);
    List<Problem> fetchAllProblemsByCourse(String courseName);
    Problem fetchProblem(String courseName,String  problemName);

}
