package me.alxndr.userservice.config.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import me.alxndr.userservice.vo.RequestLogin;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author : Alexander Choi
 * @date : 2022/11/21
 */
@RequiredArgsConstructor
@Configuration
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final ObjectMapper objectMapper;

    @Override
    public Authentication attemptAuthentication(final HttpServletRequest request,
                                                final HttpServletResponse response) throws AuthenticationException {

        try {
            final RequestLogin credentials = objectMapper.readValue(request.getInputStream(), RequestLogin.class);

            final UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(credentials.getEmail(), credentials.getPassword(), new ArrayList<>());
            return getAuthenticationManager().authenticate(token);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(final HttpServletRequest request,
                                            final HttpServletResponse response,
                                            final FilterChain chain,
                                            final Authentication authResult) throws IOException, ServletException {

    }
}
