/*
 * Author Name: Philip Meshach
 * Date: 18-01-2023
 * Praise The Lord
 */
package com.niit.AuthenticationService.service;




import com.niit.AuthenticationService.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class GenerateTokenImpl implements TokenGenerate {
    @Override
    public Map<String, String> generateToken(User user) {
        String jwt = null;
        jwt = Jwts.builder().setSubject(user.getFirstName()).setIssuedAt(new Date()).setExpiration(Date.from(ZonedDateTime.now().plusMinutes(1).toInstant()))
                .signWith(SignatureAlgorithm.HS256,"security key").compact();
        Map<String,String>map = new HashMap<>();
        map.put("token",jwt);
        map.put("Message","User Logged In Successfully");
        return map;
    }
}
