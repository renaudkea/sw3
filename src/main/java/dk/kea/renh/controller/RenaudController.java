package dk.kea.renh.controller;


import dk.kea.renh.model.Student;
import dk.kea.renh.repository.IStudentRepository;
import dk.kea.renh.repository.StudentArrayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;



@Controller
@RequestMapping("renaud")
public class RenaudController {

    ArrayList<Student> students = new ArrayList<Student>();


    @Autowired
    IStudentRepository  studentRepo = new StudentArrayRepository();


    // READ ALL
    @RequestMapping("/")
    public String index(Model model) {

        students = studentRepo.readAll();//studentRepo.readAll();
        model.addAttribute("stu", students);
        return "index";
    }

    // CREATE
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Student stu) {

        studentRepo.create(stu);
        return "redirect:/";
        //return "create";
    }

    // READ
    @GetMapping("/details")
    public String details(@RequestParam("studentId") String studentId, Model model) {
        model.addAttribute("stu", studentRepo.read(Integer.parseInt(studentId)) );
        return "details";
    }

    // DELETE
    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") String studentId) {
        studentRepo.delete(Integer.parseInt(studentId));
        return "redirect:/";
    }

    // UPDATE
    // LAV en update metode
    @GetMapping("/update")
    public String update(@RequestParam("studentId") String studentId, Model model) {
        model.addAttribute("stu", studentRepo.read(Integer.parseInt(studentId)));
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Student stu) {
        studentRepo.update(stu);
        return "redirect:/";
    }
}