package com.example.Project06.Config;

import com.example.Project06.Config.filter.CustomAuthenticationProvider;
import com.example.Project06.Config.filter.JwtTokenAuthenticationFilter;
import com.example.Project06.Config.filter.JwtUsernamePasswordAuthenticationFilter;
import com.example.Project06.exception.CustomAccessDeniedHandler;
import com.example.Project06.jwt.JwtConfig;
import com.example.Project06.jwt.JwtService;
import com.example.Project06.security.UserDetailsServiceCustom;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class AppConfig {

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Autowired
    JwtConfig jwtConfig;


    @Autowired
    private JwtService jwtService;

    @Bean
    public JwtConfig jwtConfig(){
        return new JwtConfig();
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){

        return new UserDetailsServiceCustom();
    }

    @Autowired
    public void configGlobal(final AuthenticationManagerBuilder auth){
        auth.authenticationProvider(customAuthenticationProvider);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder builder = http.getSharedObject(AuthenticationManagerBuilder.class);

        builder.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());

        AuthenticationManager manager = builder.build();

        http
                .cors().configurationSource(corsConfigurationSource())
                .and()
                .csrf().disable()
                .formLogin().disable()
                .authorizeHttpRequests()
                .requestMatchers("/account/**").permitAll()
                .requestMatchers("/JobFair/**").permitAll()
                .requestMatchers("/jobFairQueAns/**").permitAll()
                .requestMatchers("/banner/**").permitAll()
                .requestMatchers("/bootcamp/**").permitAll()
                .requestMatchers("/hr/**").permitAll()
                .requestMatchers("/bootcampbookings/**").permitAll()
                .requestMatchers("/mentorfeedback/**").permitAll()

                .requestMatchers("/mentor/**").permitAll()
                .requestMatchers("/plan/**").permitAll()
                .requestMatchers("/LiveProject/**").permitAll()
                .requestMatchers("/job/**").permitAll()
                .requestMatchers("/ItTrainingBooking/**").permitAll()
                .requestMatchers("/ItTraining/**").permitAll()
                .requestMatchers("/ESuggest/**").permitAll()
                .requestMatchers("/StudentProfile/**").permitAll()
                .requestMatchers("/HrCall/**").permitAll()
                .requestMatchers("/Blogs/**").permitAll()
                .requestMatchers("/verification/**").permitAll()
                .requestMatchers("/company/**").permitAll()
                .requestMatchers("/Events/**").permitAll()
                .requestMatchers("/user/**").permitAll()
                .requestMatchers("/mentorprogramgit/**").permitAll()
                .requestMatchers("/filter/**").permitAll()
                .requestMatchers("/save/**").permitAll()
                .requestMatchers("/studentApplication/**").permitAll()
                .requestMatchers("/banner/**").permitAll()
                .requestMatchers("/bootcamp/**").permitAll()
                .requestMatchers("/hr/**").permitAll()
                .requestMatchers("/bootcampbookings/**").permitAll()
                .requestMatchers("/mentorfeedback/**").permitAll()
                .requestMatchers("/mentorprogram/**").permitAll()
                .requestMatchers("/mentorProgramBooking/**").permitAll()
                .requestMatchers("/mentorschedule/**").permitAll()
                .requestMatchers("/CareerPlanning/**").permitAll()

                .anyRequest().authenticated()
                .and()
                .authenticationManager(manager)
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(
                        ((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                )
                .accessDeniedHandler(new CustomAccessDeniedHandler())
                .and()
                .addFilterBefore(new JwtUsernamePasswordAuthenticationFilter(manager, jwtConfig, jwtService), UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(new JwtTokenAuthenticationFilter(jwtConfig, jwtService), UsernamePasswordAuthenticationFilter.class)
        ;
        return http.build();
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        return new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowedOrigins(Collections.singletonList("http://localhost:5173"));
                config.setAllowedMethods(Collections.singletonList("*"));
                config.setAllowCredentials(true);
                config.setAllowedHeaders(Collections.singletonList("*"));
                config.setExposedHeaders(Arrays.asList("Authorization"));
                config.setMaxAge(3600L);
                return config;
            }
        };
    }


}
