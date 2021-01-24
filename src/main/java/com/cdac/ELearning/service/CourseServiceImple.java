package com.cdac.ELearning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.ELearning.model.Course;
import com.cdac.ELearning.model.Problem;
import com.cdac.ELearning.model.Quiz;
import com.cdac.ELearning.repository.CourseRepository;

@Service
public class CourseServiceImple implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    
    
    
    @Override
    public void addQuiz(List<Quiz> quiz,String courseName) {

        Course course = courseRepository.findByCourseName(courseName);
        
        System.out.println();
        System.out.println(course.getQuiz());
        course.getQuiz().addAll(quiz);

        courseRepository.save(course);
    }

    @Override
    public void addProblem(Problem problem, String courseName) {

        Course course = this.courseRepository.findByCourseName(courseName);

        course.getProblem().add(problem);

        this.courseRepository.save(course);
    }

    @Override
    public void addQuizScore(String courseName, String score) {
        Course course = this.courseRepository.findByCourseName(courseName);
        course.getScore().setQuizScore(score);
        this.courseRepository.save(course);
    }

    @Override
    public void addCourse(Course course) {

        this.courseRepository.insert(course);
    }

    @Override
    public List<Course> fetchAllCourses() {
        // System.out.println(courseRepository.findAll());
        return courseRepository.findAll();
        //List<Course> c = new ArrayList<>();
        //return c;
    }

    @Override
    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Quiz> getQuiz(String courseName) {

        Course course = this.courseRepository.findByCourseName(courseName);
        return course.getQuiz();
    }

    @Override
    public List<Problem> fetchAllProblemsByCourse(String courseName) {
        Course course = this.courseRepository.findByCourseName(courseName);
        return course.getProblem();
    }

    @Override
    public Problem fetchProblem(String courseName, String problemName) {

        Course course = this.courseRepository.findByCourseName(courseName);

        List<Problem> problems = course.getProblem();

        for(Problem p : problems){
            if(p.getProblemName().equals(problemName)){
                return p;
            }
        }
        Problem p = new Problem();
        return p;
    }


}

