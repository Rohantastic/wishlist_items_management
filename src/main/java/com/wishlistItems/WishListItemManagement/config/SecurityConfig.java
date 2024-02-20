package com.wishlistItems.WishListItemManagement.config;

import com.wishlistItems.WishListItemManagement.security.JwtAuthenticationEntryPoint;
import com.wishlistItems.WishListItemManagement.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.csrf(csrf->csrf.disable()) //disabling CSRF
                .cors(cors-> cors.disable()) // Disable Cross-Origin Resource Sharing (CORS)
                .authorizeHttpRequests(auth->auth.requestMatchers("/api/**") // Allow access to "/api/**" for authenticated users
                        .authenticated().requestMatchers("/auth/login") //Allow access to "/auth/login" for all users
                        .permitAll().requestMatchers("/auth/create-user").permitAll().anyRequest().authenticated())
                .exceptionHandling(ex->ex.authenticationEntryPoint(jwtAuthenticationEntryPoint))
                .sessionManagement(session->session.sessionCreationPolicy((SessionCreationPolicy.STATELESS)))
        ;

        // Add a custom JWT authentication filter before the default filter
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        // Build and return the configured security filter chain
        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){

        // Create a new instance of DaoAuthenticationProvider
        DaoAuthenticationProvider daoAuthenticationProvider= new DaoAuthenticationProvider();

        // Set the UserDetailsService responsible for retrieving user details
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);

        // Set the PasswordEncoder for handling password encoding and verification
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);

        // Return the configured DaoAuthenticationProvider bean
        return daoAuthenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception{
        // Retrieve the AuthenticationManager from the provided AuthenticationConfiguration
        return builder.getAuthenticationManager();
    }
}
