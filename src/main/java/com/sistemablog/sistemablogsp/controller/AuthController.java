package com.sistemablog.sistemablogsp.controller;

import com.sistemablog.sistemablogsp.dto.LoginDTO;
import com.sistemablog.sistemablogsp.dto.RegistroDTO;
import com.sistemablog.sistemablogsp.model.Rol;
import com.sistemablog.sistemablogsp.model.Usuario;
import com.sistemablog.sistemablogsp.repository.RolRepositorio;
import com.sistemablog.sistemablogsp.repository.UsuarioRepositorio;
import com.sistemablog.sistemablogsp.security.JWTAuthResponseDTO;
import com.sistemablog.sistemablogsp.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private RolRepositorio rolRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/iniciarSesion")
    public ResponseEntity<JWTAuthResponseDTO> authenticateUser(@RequestBody LoginDTO loginDTO){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        //Obtener token del jwtTokenProvider
        String token = jwtTokenProvider.generarToken(authentication);
        return ResponseEntity.ok(new JWTAuthResponseDTO(token));
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario(@RequestBody RegistroDTO registroDTO){
        if(usuarioRepositorio.existsByUsername(registroDTO.getUsername())){
            return new ResponseEntity<>("Este usuario ya existe en la BD", HttpStatus.BAD_REQUEST);
        }if(usuarioRepositorio.existsByEmail(registroDTO.getEmail())){
            return new ResponseEntity<>("Este email ya existe en la BD", HttpStatus.BAD_REQUEST);
        }
        Usuario usuario = new Usuario();
        usuario.setNombre(registroDTO.getNombre());
        usuario.setUsername(registroDTO.getUsername());
        usuario.setEmail(registroDTO.getEmail());
        usuario.setPassword(passwordEncoder.encode(registroDTO.getPassword()));

        Rol roles = rolRepositorio.findByNombre("ROLE_ADMIN").get();
        usuario.setRoles(Collections.singleton(roles));

        usuarioRepositorio.save(usuario);
        return new ResponseEntity<>("Usuario registrado exitosamente", HttpStatus.OK);
    }
}

