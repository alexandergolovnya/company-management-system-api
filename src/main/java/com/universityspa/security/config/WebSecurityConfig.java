package com.universityspa.security.config;

import com.universityspa.security.filter.TokenAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@ComponentScan("com.universityspa")
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private TokenAuthenticationFilter tokenAuthenticationFilter;

    public static final String TEACHER = "TEACHER";
    public static final String STUDENT = "STUDENT";
    public static final String ADMIN = "ADMIN";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()

                .addFilterBefore(tokenAuthenticationFilter, BasicAuthenticationFilter.class)
                .antMatcher("/**")
                .authenticationProvider(authenticationProvider)
                .authorizeRequests()

                /**
                 * Permit all users to access main page
                 */
                .antMatchers("/").permitAll()
                .antMatchers("/api/login").permitAll()
                .antMatchers("/api/users").permitAll()

                /** Студенты */
                .antMatchers(HttpMethod.GET,"/api/students/**").hasAnyAuthority(TEACHER, STUDENT)
                .antMatchers(HttpMethod.GET,"/api/students/{id}/**").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers(HttpMethod.PUT,"/api/students/{id}/**").hasAuthority(STUDENT)
                .antMatchers("/api/students/*").hasAuthority(ADMIN)

                /** Преподаватели */
                .antMatchers(HttpMethod.GET,"/api/teachers/**").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers(HttpMethod.GET,"/api/teachers/{id}/**").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers(HttpMethod.PUT,"/api/teachers/{id}/**").hasAnyAuthority(TEACHER)
                .antMatchers("/api/teachers/**").hasAuthority(ADMIN)

                /** Факультеты */
                .antMatchers(HttpMethod.GET,"/api/faculties/**").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers(HttpMethod.GET,"/api/faculties/{id}/**").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers("/api/faculties/**").hasAuthority(ADMIN)

                /** Кафедры */
                .antMatchers(HttpMethod.GET,"/api/departments/**").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers(HttpMethod.GET,"/api/departments/{id}/**").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers("/api/departments/**").hasAuthority(ADMIN)

                /** Специальности */
                .antMatchers(HttpMethod.GET,"/api/specialties/**").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers(HttpMethod.GET,"/api/specialties/{id}/**").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers("/api/specialties/**").hasAuthority(ADMIN)

                /** Предметы */
                .antMatchers(HttpMethod.GET,"/api/subjects/**").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers(HttpMethod.GET,"/api/subjects/{id}/**").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers("/api/subjects/**").hasAuthority(ADMIN)

                /** Группы студентов */
                .antMatchers(HttpMethod.GET,"/api/groups/**").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers(HttpMethod.GET,"/api/groups/{id}/**").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers("/api/groups/**").hasAuthority(ADMIN)

                /** Журнал посещаемости и успеваемости */
                .antMatchers(HttpMethod.GET,"/api/journal/**").hasAnyAuthority(STUDENT)
                .antMatchers(HttpMethod.GET,"/api/journal/scores/{id}/**").hasAnyAuthority(STUDENT)
                .antMatchers(HttpMethod.GET,"/api/journal/passes/{id}/**").hasAnyAuthority(STUDENT)
                .antMatchers(HttpMethod.GET,"/api/journal/passes-number/{id}/**").hasAnyAuthority(STUDENT)
                .antMatchers(HttpMethod.GET,"/api/journal/passes-marks/{id}/**").hasAnyAuthority(STUDENT)
                .antMatchers("/api/journal/**").hasAnyAuthority(ADMIN,TEACHER)

                /** Расписание */
                .antMatchers(HttpMethod.GET,"/api/schedule/**").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers(HttpMethod.GET,"/api/schedule/{id}/**").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers(HttpMethod.GET,"/api/schedule/lessons/{id}/**").hasAuthority(TEACHER)
                .antMatchers(HttpMethod.GET,"/api/schedule/lessons-count/{id}/**").hasAuthority(TEACHER)
                .antMatchers("/api/schedule/**").hasAuthority(ADMIN)

                ;
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:8081", "http://localhost:5000", "https://university-spa.herokuapp.com"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "Origin", "Access-Control-Request-Method",
                "Access-Control-Request-Headers", "Access-Control-Allow-Origin"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }



}