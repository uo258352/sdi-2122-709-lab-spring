package com.uniovi.notaneitor.services;

import com.uniovi.notaneitor.entities.Mark;
import com.uniovi.notaneitor.entities.Teacher;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class TeachersService {


    private List<Teacher> teacherList = new LinkedList<>();

    @PostConstruct
    public void init() {
        teacherList.add(new Teacher(1L, "77777777W", "Juan", "López Martínez", "Algoritmia"));
        teacherList.add(new Teacher(2L, "66666666J", "Ramón", "García García", "Sistemas Informáticos"));
    }

    public List<Teacher> getTeachers() {
        return teacherList;
    }

    public Teacher getTeacher(Long id) {
        return teacherList.stream()
                .filter(teacher -> teacher.getId().equals(id)).findFirst().get();
    }

    public void addTeacher(Teacher teacher) {
        // Si en Id es null le asignamos el último + 1 de la lista
        if(teacher.getId() == null)
            teacher.setId(teacherList.get(teacherList.size()-1).getId()+1);
        teacherList.add(teacher);
    }

    public void deleteTeacher(Long id) {

        teacherList.removeIf(teacher->teacher.getId().equals(id));
    }

}
