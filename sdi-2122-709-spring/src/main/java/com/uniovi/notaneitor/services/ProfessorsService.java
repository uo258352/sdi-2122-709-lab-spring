package com.uniovi.notaneitor.services;

import com.uniovi.notaneitor.entities.Professor;
import com.uniovi.notaneitor.repositories.ProfessorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorsService {


    @Autowired
    private ProfessorsRepository professorsRepository;



    public List<Professor> getProfessors() {
        List<Professor> professors = new ArrayList<Professor>();
        professorsRepository.findAll().forEach(professors::add);
        return professors;

    }

    public Professor getTeacher(Long id) {
        return professorsRepository.findById(id).get();
    }

    public void addTeacher(Professor professor) {
        // Si en Id es null le asignamos el último + 1 de la lista
        if (professor.getId() == null) {
            professor.setId(professorsRepository.count()+1);
        }

        professorsRepository.save(professor);
    }

    public void deleteTeacher(Long id) {

        professorsRepository.deleteById(id);
    }

}
