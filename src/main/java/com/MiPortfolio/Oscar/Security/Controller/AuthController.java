
package com.MiPortfolio.Oscar.Security.Controller;

import com.MiPortfolio.Oscar.Security.Dto.JwtDto;
import com.MiPortfolio.Oscar.Security.Dto.LoginUsuario;
import com.MiPortfolio.Oscar.Security.Dto.NuevoUsuario;
import com.MiPortfolio.Oscar.Security.Entity.Rol;
import com.MiPortfolio.Oscar.Security.Entity.Usuario;
import com.MiPortfolio.Oscar.Security.Enums.RolNombre;
import com.MiPortfolio.Oscar.Security.Service.RolService;
import com.MiPortfolio.Oscar.Security.Service.UsuarioService;
import com.MiPortfolio.Oscar.Security.jwt.JwtProvider;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("auth")
@CrossOrigin(origins = "https://frontend1910-6bd06.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
   @Autowired
   PasswordEncoder passwordEncoder;
   @Autowired
   AuthenticationManager authenticationManager;
   @Autowired
   UsuarioService usuarioService;
   @Autowired
   RolService rolService;
   @Autowired
   JwtProvider jwtProvider;
 
   @PostMapping("/nuevo")
   public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
   if(bindingResult.hasErrors()) 
       return new ResponseEntity(new Mensaje("campos mal puestos o mail invalido"), HttpStatus.BAD_REQUEST);
   
   if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
       return new ResponseEntity(new Mensaje("ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
   
   if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
       return new ResponseEntity(new Mensaje("este email ya existe"), HttpStatus.BAD_REQUEST);
   
   Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),
   nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));
   
   Set<Rol> roles = new HashSet<>();
   roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
   
      if(nuevoUsuario.getRoles().contains("admin"))
          roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
      usuario.setRoles(roles);
      usuarioService.save(usuario);
      
      return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
      
   }
   @PostMapping("/login")
   public ResponseEntity<JwtDto>login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){

       if(bindingResult.hasErrors())
       return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);
       
    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(),loginUsuario.getPassword()));
       
SecurityContextHolder.getContext().setAuthentication(authentication);

String jwt = jwtProvider.generateToken(authentication);

UserDetails userDetails = (UserDetails) authentication.getPrincipal();

JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
return new ResponseEntity(jwtDto, HttpStatus.OK);


} 

    private JwtDto JwtDto(String jwt, String username, Collection<? extends GrantedAuthority> authorities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
