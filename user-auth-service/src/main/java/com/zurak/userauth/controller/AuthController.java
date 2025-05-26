package com.zurak.userauth.controller;

import com.zurak.userauth.domain.User;
import com.zurak.userauth.security.JwtUtil;
import com.zurak.userauth.service.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthController(@Lazy UserService userService, UserDetailsService userDetailsService,
                          JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest registrationRequest){
      try{
          User user=userService.registerUser(
                  registrationRequest.getUsername(),
                  registrationRequest.getPassword(),
                  registrationRequest.getEmail()
          );
          Map<String, String> response= new HashMap<>();
          response.put("message","User Registered Successfully");
          response.put("userId",user.getUsername().toString());
          return new ResponseEntity<>(response, HttpStatus.CREATED);

      }catch (RuntimeException e){
          Map<String, String> errorResponse=new HashMap<>();
          errorResponse.put("error",e.getMessage() );
          return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
      }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        try{
            Authentication authentication=authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.username,loginRequest.password)
            );
            if (authentication.isAuthenticated()){
                final UserDetails userDetails=userDetailsService.loadUserByUsername(loginRequest.username);
                final String jwt=jwtUtil.generateToken(userDetails);
                Map<String, String> response=new HashMap<>();
                response.put("token", jwt);
                return ResponseEntity.ok(response);
            }else{
                Map<String, String> errorResponse=new HashMap<>();
                errorResponse.put("error","Invalid Credentials");
                return new ResponseEntity<>(errorResponse,HttpStatus.UNAUTHORIZED);
            }
        }catch (Exception e){
            Map<String, String> errorResponse=new HashMap<>();
            errorResponse.put("error","Invalid Credentials");
            return new ResponseEntity<>(errorResponse,HttpStatus.UNAUTHORIZED);

        }
    }

    record RegistrationRequest(String username, String password, String email) {
        public String getUsername() {
            return username;
        }
        public String getPassword() {
            return password;
        }
        public String getEmail() {
            return email;
        }
    }
    public record LoginRequest(String username, String password) {
    }
}
