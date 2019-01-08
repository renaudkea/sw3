package dk.kea.renh.repository;

import dk.kea.renh.model.Student;

import java.util.ArrayList;

public interface IStudentRepository {
    void create(Student st);

    ArrayList<Student> readAll();

    Student read(int id);

    void update(Student st);

    void delete(int id);
}
