package com.uniovi.notaneitor.controllers;

import com.uniovi.notaneitor.entities.Professor;
import com.uniovi.notaneitor.services.ProfessorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfessorsController {

    @Autowired
    private ProfessorsService professorsService;

    @RequestMapping("/professor/list")
    public String getList(){
        return professorsService.getProfessors().toString();
    }

    @RequestMapping(value = "/professor/add", method = RequestMethod.POST)
    public String setProfessor(@ModelAttribute Professor professor){
        professorsService.addTeacher(professor);
        return "Ok";
    }

    @RequestMapping("/professor/details/{id}")
    public String getDetail(@PathVariable Long id){
        return professorsService.getTeacher(id).toString();
    }

    @RequestMapping("/professor/delete/{id}")
    public String deleteProfessor(@PathVariable Long id){
        professorsService.deleteTeacher(id);
        return "Ok";
    }

    @RequestMapping(value="/teacher/edit", method=RequestMethod.POST)
    public String setEdit(@ModelAttribute Professor professor){
        professorsService.deleteTeacher(professor.getId());
        professorsService.addTeacher(professor);
        return getDetail(professor.getId());
    }
}
