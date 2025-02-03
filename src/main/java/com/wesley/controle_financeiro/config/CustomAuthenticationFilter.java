package com.wesley.controle_financeiro.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationFilter.class);

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final AuthenticationManager authenticationManager;

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl("/auth/login"); // Certifique-se de que o URL do filtro está configurado corretamente
    }

    private final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            Map<String, String> credentials = objectMapper.readValue(request.getInputStream(), HashMap.class);
            String nomeUsuario = credentials.get("nomeUsuario");
            String senha = credentials.get("senha");


            logger.info("Tentando autenticação para o usuário: {}", nomeUsuario);

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(nomeUsuario, senha);
            return authenticationManager.authenticate(authenticationToken);
        } catch (IOException e) {
            logger.error("Erro ao ler as credenciais", e);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(nomeUsuario, senha);
            return getAuthenticationManager().authenticate(authenticationToken);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        logger.info("Autenticação bem-sucedida para o usuário: {}", authResult.getName());
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write("Autenticação bem-sucedida");
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {

        logger.info("Falha na autenticação: {}", failed.getMessage());

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("Falha na autenticação");
    }
}
