package com.quizz.quizPortal.controller;

import com.quizz.quizPortal.config.JwtUtils;
import com.quizz.quizPortal.entity.JwtRequest;
import com.quizz.quizPortal.entity.JwtResponse;
import com.quizz.quizPortal.entity.User;
import com.quizz.quizPortal.exception.UserNotFoundException;
import com.quizz.quizPortal.service.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUserDetails jwtUserDetails;
    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

        try{
            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());

        }catch (UserNotFoundException e){
            e.printStackTrace();
            throw  new Exception("User Not Found");
        }
        UserDetails userDetails= this.jwtUserDetails.loadUserByUsername(jwtRequest.getUsername());
        String token =this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        } catch (DisabledException e) {
            throw new Exception("User disabled" + e.getMessage());
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid credentials" + e.getMessage());
        }

    }
    @GetMapping("/current-user")
public User getCurrentUser(Principal principal){
     return ((User)this.jwtUserDetails.loadUserByUsername(principal.getName()));
}

}
