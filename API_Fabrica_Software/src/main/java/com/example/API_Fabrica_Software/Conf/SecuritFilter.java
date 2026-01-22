package com.example.API_Fabrica_Software.Conf;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.API_Fabrica_Software.Model.Usuario;
import com.example.API_Fabrica_Software.Repository.RepositoryUsuario;
import com.example.API_Fabrica_Software.Service.Auth.AuthenticationServices;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecuritFilter extends OncePerRequestFilter {

  @Autowired
  AuthenticationServices authenticationServices;

  @Autowired
  RepositoryUsuario repositoryUsuario;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    try {
      String toker = extrairToker(request);

      String path = request.getServletPath();
      if (path.equals("/user") || path.equals("/auth") || path.equals("/auth/refrash")) {
        filterChain.doFilter(request, response);
        return;
      }
      if (toker != null) {
        String login = authenticationServices.validarToken(toker);
        Usuario user = repositoryUsuario.findByLogin(login);
        String role = user.getRoles().name();
        System.out.println(role);
        if (!role.equals("ADMIN")) {
          response.setStatus(HttpServletResponse.SC_FORBIDDEN);
          response.getWriter().write("""
                  {
                    "status": 403,
                    "error": "Acesso negado",
                    "message": "Você não tem permissão"
                  }
              """);
          return;
        }

        var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
      filterChain.doFilter(request, response);
    } catch (TokenExpiredException e) {

      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      response.setContentType("application/json");
      response.getWriter().write("""
              {
                "status": 401,
                "error": "Token expirado",
                "message": "Seu token expirou, faça login novamente"
              }
          """);

    } catch (JWTVerificationException e) {

      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      response.setContentType("application/json");
      response.getWriter().write("""
              {
                "status": 401,
                "error": "Token inválido",
                "message": "JWT inválido ou mal formatado"
              }
          """);
    }
  }

  private String extrairToker(HttpServletRequest request) {
    String authHeder = request.getHeader("Authorization");
    if (authHeder == null) {
      return null;
    }
    if (!authHeder.split(" ")[0].equals("Bearer")) {
      return null;
    }

    return authHeder.split(" ")[1];
  }

}
