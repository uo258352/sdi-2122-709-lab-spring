package com.uniovi.notaneitor.services;

import com.uniovi.notaneitor.entities.Professor;
import com.uniovi.notaneitor.entities.User;
import com.uniovi.notaneitor.repositories.ProfessorsRepository;
import com.uniovi.notaneitor.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorsService {


    @Autowired
    private ProfessorsRepository professorsRepository;

    @Autowired
    private RolesService rolesService;


    @Autowired
    private UsersService usersService;

    public List<User> getProfessors() {
        List<User> professors = new ArrayList<User>();
        List<User> users = usersService.getUsers();
        for (User user: users) {
            if (user.getRole().equals(rolesService.getRoles()[1]))
                professors.add(user);

        }
        return professors;

    }

    public User getProfessor(Long id) {

        return usersService.getUser(id);
    }

    public void addProfessor(User professor) {
        // Si en Id es null le asignamos el último + 1 de la lista
        professor.setRole(rolesService.getRoles()[1]);
        usersService.addUser(professor);
    }

    public void deleteProfessor(Long id) {

        usersService.deleteUser(id);
    }

}
