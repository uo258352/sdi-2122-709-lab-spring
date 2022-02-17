package com.uniovi.notaneitor.services;

import com.uniovi.notaneitor.entities.Mark;
import com.uniovi.notaneitor.entities.Teacher;
import com.uniovi.notaneitor.repositories.MarksRepository;
import com.uniovi.notaneitor.repositories.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class TeachersService {


    @Autowired
    private TeachersRepository teachersRepository;



    public List<Teacher> getTeachers() {
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachersRepository.findAll().forEach(teachers::add);
        return teachers;

    }

    public Teacher getTeacher(Long id) {
        return teachersRepository.findById(id).get();
    }

    public void addTeacher(Teacher teacher) {
        // Si en Id es null le asignamos el último + 1 de la lista
        if (teacher.getId() == null) {
            teacher.setId(teachersRepository.count()+1);
        }

        teachersRepository.save(teacher);
    }

    public void deleteTeacher(Long id) {

        teachersRepository.deleteById(id);
    }

}
