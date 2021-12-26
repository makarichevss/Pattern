package HW7.java.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import HW7.java.beans.JwtTokenUtil;
import dto.JwtRequest;
import dto.JwtResponse;
import HW7.java.service.UserService;

@RestController
@AllArgsConstructor
@Api("Set of endpoint for new user authentication")
public class AuthController {
    private UserService userService;
    private JwtTokenUtil jwtTokenUtil;
    private AuthenticationManager authenticationManager;

    @PostMapping("/auth")
    @ApiOperation("Create token for user")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", defaultValue = "alan1", required = true, dataTypeClass = String.class, type = "String", paramType = "query",
                    value = "Username"),
            @ApiImplicitParam(name = "password", defaultValue = "123", required = true, dataTypeClass = String.class, type = "String", paramType = "query",
                    value = "Password")})
    public ResponseEntity<?> createToken(@RequestBody JwtRequest jwtRequest){
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
        UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
