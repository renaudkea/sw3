package dk.kea.renh.repository;

import dk.kea.renh.model.Student;

import java.util.ArrayList;

public class StudentArrayRepository implements IStudentRepository {

    // CRUD fra Arraylist
    private ArrayList<Student> students = new ArrayList<>();

    @Override
    public void create(Student st) {
        Integer sizeOfArray = students.size() + 1;
        st.setStudentId(sizeOfArray);

        // sizeOfArray om det eksisterer i arraylistens id´er

        students.add(st);
    }

    @Override
    public ArrayList<Student> readAll() {
        return students;
    }

    @Override
    public Student read(int id) {

        for (Student st : students) {
            if (st.getStudentId() == id) {
                return st;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        Student st = read(id);
        students.remove(st);
    }

    @Override
    public void update(Student st) { // st
        // gamle studerende
        //Student stu = read(st.getStudentId());
        delete(st.getStudentId());
        students.add(st);
        // students.set(students.indexOf(st + 1, st))
    }
}
