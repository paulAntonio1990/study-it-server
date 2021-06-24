package com.degree.studyitserver.controller;

import com.degree.studyitserver.domain.entity.Role;
import com.degree.studyitserver.domain.entity.User;
import com.degree.studyitserver.domain.payload.request.LoginRequest;
import com.degree.studyitserver.domain.payload.request.SignupRequest;
import com.degree.studyitserver.domain.payload.response.JWTTokenResponse;
import com.degree.studyitserver.domain.payload.response.MessageResponse;
import com.degree.studyitserver.domain.types.RoleType;
import com.degree.studyitserver.repository.RoleRepository;
import com.degree.studyitserver.repository.UserRepository;
import com.degree.studyitserver.security.jwt.JWTUtilitary;
import com.degree.studyitserver.security.service.AppUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTUtilitary jwtUtilitary;

    @Autowired
    public AuthenticationController(UserRepository userRepository,
                                    PasswordEncoder passwordEncoder,
                                    RoleRepository roleRepository,
                                    AuthenticationManager authenticationManager, JWTUtilitary jwtUtilitary) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtilitary = jwtUtilitary;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUserName(signUpRequest.getUserName())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username already allocated!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email already allocated!"));
        }

        User user = new User(signUpRequest.getUserName(),
                signUpRequest.getEmail(),
                passwordEncoder.encode(signUpRequest.getPassword()));

        String stringRole = signUpRequest.getRole();
        Role userRole = null;

        if (stringRole == null) {
            userRole = roleRepository.findByName(RoleType.ROLE_STUDENT)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        } else {
            switch (stringRole) {
                case "admin":
                    userRole = roleRepository.findByName(RoleType.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    break;
                case "profesor":
                    userRole = roleRepository.findByName(RoleType.ROLE_PROFESOR)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    break;
                default:
                    userRole = roleRepository.findByName(RoleType.ROLE_STUDENT)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            }
        }

        user.setRole(userRole);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String generatedJwtToken = jwtUtilitary.generateJwtToken(authentication);

        AppUserDetails userDetails = (AppUserDetails) authentication.getPrincipal();
        String userRole = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .findFirst().orElseThrow(() -> new IllegalArgumentException("User role was not found!"));

        return ResponseEntity.ok(new JWTTokenResponse(generatedJwtToken, userDetails.getId(),
                userDetails.getUsername(), userDetails.getEmail(), userRole));
    }
}
