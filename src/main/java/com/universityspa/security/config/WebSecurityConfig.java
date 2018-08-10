package com.universityspa.security.config;

import com.universityspa.security.filter.TokenAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private TokenAuthFilter tokenAuthFilter;

    public static final String TEACHER = "TEACHER";
    public static final String STUDENT = "STUDENT";
    public static final String ADMIN = "ADMIN";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()

                .addFilterBefore(tokenAuthFilter, BasicAuthenticationFilter.class)
                .antMatcher("/**")
                .authenticationProvider(authenticationProvider)
                .authorizeRequests()

//                .anyRequest().authenticated()

                /** Студенты */
                .antMatchers(HttpMethod.GET,"/students/").hasAnyAuthority(TEACHER, STUDENT)
                .antMatchers(HttpMethod.GET,"/students/{id}").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers(HttpMethod.PUT,"/students/{id}").hasAuthority(STUDENT)
                .antMatchers("/students/*").hasAuthority(ADMIN)

                /** Преподаватели */
                .antMatchers(HttpMethod.GET,"/teachers/").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers(HttpMethod.GET,"/teachers/{id}").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers(HttpMethod.PUT,"/teachers/{id}").hasAnyAuthority(TEACHER)
                .antMatchers("/teachers/*").hasAuthority(ADMIN)

                /** Факультеты */
                .antMatchers(HttpMethod.GET,"/faculties/").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers(HttpMethod.GET,"/faculties/{id}").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers("/faculties/*").hasAuthority(ADMIN)

                /** Кафедры */
                .antMatchers(HttpMethod.GET,"/departments/").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers(HttpMethod.GET,"/departments/{id}").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers("/departments/*").hasAuthority(ADMIN)

                /** Специальности */
                .antMatchers(HttpMethod.GET,"/specialties/").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers(HttpMethod.GET,"/specialties/{id}").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers("/specialties/*").hasAuthority(ADMIN)

                /** Предметы */
                .antMatchers(HttpMethod.GET,"/subjects/").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers(HttpMethod.GET,"/subjects/{id}").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers("/subjects/*").hasAuthority(ADMIN)

                /** Группы студентов */
                .antMatchers(HttpMethod.GET,"/groups/").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers(HttpMethod.GET,"/groups/{id}").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers("/groups/*").hasAuthority(ADMIN)

                /** Журнал посещаемости и успеваемости */
                .antMatchers(HttpMethod.GET,"/journal/*").hasAnyAuthority(STUDENT)
                .antMatchers(HttpMethod.GET,"/journal/scores/{id}").hasAnyAuthority(STUDENT)
                .antMatchers(HttpMethod.GET,"/journal/passes/{id}").hasAnyAuthority(STUDENT)
                .antMatchers(HttpMethod.GET,"/journal/passes-number/{id}").hasAnyAuthority(STUDENT)
                .antMatchers(HttpMethod.GET,"/journal/passes-marks/{id}").hasAnyAuthority(STUDENT)
                .antMatchers("/journal/*").hasAnyAuthority(ADMIN,TEACHER)

                /** Расписание */
                .antMatchers(HttpMethod.GET,"/schedule/").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers(HttpMethod.GET,"/schedule/{id}").hasAnyAuthority(TEACHER,STUDENT)
                .antMatchers(HttpMethod.GET,"/schedule/lessons/{id}").hasAuthority(TEACHER)
                .antMatchers(HttpMethod.GET,"/schedule/lessons-count/{id}").hasAuthority(TEACHER)
                .antMatchers("/schedule/*").hasAuthority(ADMIN)

                /**
                 * Permit all users to access main page
                 */
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()

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