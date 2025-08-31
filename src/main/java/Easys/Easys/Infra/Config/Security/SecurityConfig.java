package Easys.Easys.Infra.Config.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthFilter jwtAuthFilter) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/create").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/create-professional").permitAll()
                        
                        // User endpoints
                        .requestMatchers(HttpMethod.GET, "/users/**").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/users/**").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/users/**").authenticated()
                        
                        // Service endpoints
                        .requestMatchers(HttpMethod.GET, "/services/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/services/create").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/services/**").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/services/**").authenticated()
                        
                        // Professional endpoints
                        .requestMatchers(HttpMethod.GET, "/professionals/**").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/professionals/**").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/professionals/**").authenticated()
                        
                        // Appointment endpoints
                        .requestMatchers(HttpMethod.GET, "/appointments/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/appointments/create").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/appointments/**").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/appointments/**").authenticated()

                        .anyRequest().authenticated())
                .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}



