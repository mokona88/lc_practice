//package com.solution;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
///*
//* Update the function below to calculate & populate numberOfCourses onto the Student objects.
//* */
//
///*
//* Update the function below to calculate & populate creditsFromHistory onto the Student objects.
//* creditsFromHistory should be a sum of the numberOfCredits field on each Course a student is taking,
//* if the Course has a department of 'History'.
//* */
//
//public class LeanData {
//  public List<Student> calculateStudentInfo(){
//    List<Student> students = getStudents(); //List of all students in the database
//    List<Course> courses = getCourses(); //List of all courses in the database
//    List<StudentCourseRelationship> studentCourses = getStudentCourseRelationships(); //List of all StudentCourseRelationship in the database
//    //Insert Code Here
//    Map<String, List<Course>> studentCourseRelationMap = new HashMap<>();
//    Map<String, Course> courseMap = new HashMap<>();
//    for (StudentCourseRelationship studentCourse : studentCourses) {
//      List<String> takenCourses = studentCourseRelationMap.get(studentCourse.studentId);
//      Course course = courseMap.get(studentCourse.courseId);
//      if (takenCourses != null) {
//        takenCourses.add(studentCourse.courseId);
//      } else {
//        takenCourses = new ArrayList<String>();
//        takenCourses.add(studentCourse.courseId);
//        studentCourseRelationMap.put(studentCourse.studentId, takenCourses);
//      }
//    }
//
//    // update student list with number of courses.
//    for (Student student : students) {
//      List<String> takenCourses = studentCourseRelationMap.get(student.Id);
//      student.numberOfCourses = takenCourses == null ? 0 : takenCourses.size();
//
//      student.creditsFromHistory = 0;
//
//      for (String courseId : takenCourses) {
//        Course course = getCourse(courseId, courses);
//        if (course != null && course.department.equals("History")) {
//          student.creditsFromHistory += course.numberOfCredits;
//        }
//      }
//    }
//
//    return students;
//  }
//
//  private Course getCourse(String courseId, List<Course> courses) {
//    for (Course course : courses) {
//      if (courseId.equals(course.Id)) {
//        return course;
//      }
//    }
//    return null;
//  }
//}
//class Student{
//  String Id;
//  String name;
//  Integer numberOfCourses;
//  Integer creditsFromHistory;
//  Boolean scheduleConflict;
//}
//class Course{
//  String Id;
//  String name;
//  String department;
//  Integer numberOfCredits;
//  Integer startTime;
//  Integer endTime;
//}
//class StudentCourseRelationship{
//  String studentId;
//  String courseId;
//}
//
//
