package com.quizz.quizPortal.service;
import com.quizz.quizPortal.entity.Role;
import com.quizz.quizPortal.entity.User;
import com.quizz.quizPortal.repository.RoleRepository;
import com.quizz.quizPortal.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class UserService{
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    public User saveUser(User user) {
        log.info("Saving a new user {} to the database", user.getFirstName());
        return userRepository.save(user);
    }
    public Role saveRole(Role role) {
        log.info("Saving a new role {} to the database", role.getRolename());
        return roleRepository.save(role);
    }

    public void addRoleToUser(String username, String rolename) {
        log.info("Adding role {} to the user {}", rolename, username);
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByRolename(rolename);
        user.getUserRoles().add(role);
    }

}
