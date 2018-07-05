package com.aleksgolovnya.deansoffice;

import com.aleksgolovnya.deansoffice.entity.*;
import com.aleksgolovnya.deansoffice.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public CommandLineRunner demoFaculty(FacultyRepository facultyRepository) {
        return (args) -> {
            facultyRepository.save(new Faculty("АВТ", "Описание факультета АВТ"));
            facultyRepository.save(new Faculty("Девочки", "Описание факультета девочек"));
        };
    }

//    @Bean
//    public CommandLineRunner demoTeacher(TeacherRepository teacherRepository) {
//        return (args) -> {
//            teacherRepository.save(new Teacher("Александр", "Головня", "Доцент"));
//            teacherRepository.save(new Teacher("Елена", "Шалимова", "Старший преподаватель"));
//        };
//    }

//    @Bean
//    public CommandLineRunner demoDepartment(DepartmentRepository departmentRepository) {
//        return (args) -> {
//            departmentRepository.save(new Department("Информационные технологии и компьютерные системы", "Описание кафедры информационные технологии и компьютерные системы"));
//            departmentRepository.save(new Department("Информационные системы", "Описание кафедры информационные системы"));
//        };
//    }

//    @Bean
//    public CommandLineRunner demoSpecialty(SpecialtyRepository specialtyRepository) {
//        return (args) -> {
//            specialtyRepository.save(new Specialty("Информатика и вычислительная техника", "Описание направления информатика и вычислительная техника"));
//            specialtyRepository.save(new Specialty("Информационные системы", "Описание направления информационные системы"));
//        };
//    }

//    @Bean
//    public CommandLineRunner demoSubject(SubjectRepository subjectRepository) {
//        return (args) -> {
//            subjectRepository.save(new Subject("Операционные системы", "Дичь"));
//            subjectRepository.save(new Subject("Алгоритмы и методы вычислений", "Полезная штука"));
//        };
//    }

    @Bean
    public CommandLineRunner demoStudentsGroup(StudentsGroupRepository studentsGroupRepository) {
        return (args) -> {
            studentsGroupRepository.save(new StudentsGroup("ИС-41о"));
            studentsGroupRepository.save(new StudentsGroup("ИВТ/б-41о"));
        };
    }

//    @Bean
//    public CommandLineRunner demoStudent(StudentRepository studentRepository) {
//        return (args) -> {
//            studentRepository.save(new Student("Павел", "Lehjd", 1));
//            studentRepository.save(new Student("Александр", "Головня", 4));
//            studentRepository.save(new Student("Ника", "Лапочка", 4));
//        };
//    }


}
