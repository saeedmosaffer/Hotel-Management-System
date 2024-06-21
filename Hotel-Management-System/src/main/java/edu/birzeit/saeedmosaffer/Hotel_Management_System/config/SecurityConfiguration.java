package edu.birzeit.saeedmosaffer.Hotel_Management_System.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static edu.birzeit.saeedmosaffer.Hotel_Management_System.user.Role.ADMIN;
import static edu.birzeit.saeedmosaffer.Hotel_Management_System.user.Role.CUSTOMER;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {

  // The authentication filter for JWT.
  private final JwtAuthenticationFilter jwtAuthFilter;
  // The AuthenticationProvider which will authenticate the user's credentials.
  private final AuthenticationProvider authenticationProvider;

  // Define the security filter chain which specifies the security settings.
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      return http
              // Disabling CSRF protection as we're using JWT for stateless authentication.
              .csrf(AbstractHttpConfigurer::disable)
              // Disabling CORS support.
              .cors(AbstractHttpConfigurer::disable)
              // Define authorization requests.
              .authorizeHttpRequests(auth -> auth
                      .requestMatchers("/api/v1/auth/**","/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        .requestMatchers("/v1/users/**").hasAnyAuthority(ADMIN.name())
                        .requestMatchers(HttpMethod.GET, "/api/v1/rooms").hasAnyAuthority(CUSTOMER.name(), ADMIN.name())


                      .anyRequest().authenticated())
              // Define the session management strategy - here we're going for stateless session creation (no session).
              .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
              // Set the AuthenticationProvider to be used.
              .authenticationProvider(authenticationProvider)
              // Add the JWT authentication filter before the UsernamePasswordAuthenticationFilter.
              .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
              .build();
  }

}
