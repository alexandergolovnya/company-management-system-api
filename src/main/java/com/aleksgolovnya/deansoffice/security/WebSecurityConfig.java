package com.aleksgolovnya.deansoffice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String TEACHER = "TEACHER";
    public static final String STUDENT = "STUDENT";
    public static final String GUEST = "GUEST";
    public static final String ADMIN = "ADMIN";


    @Autowired
    private AuthenticationConfig authenticationConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()

                .httpBasic()
                .authenticationEntryPoint(authenticationConfig)
                .and()
                .authorizeRequests()

                /** Студенты */
                .antMatchers(HttpMethod.GET,"/students/").hasAnyRole(TEACHER, STUDENT)
                .antMatchers(HttpMethod.GET,"/students/{id}").hasAnyRole(TEACHER,STUDENT)
                .antMatchers(HttpMethod.PUT,"/students/{id}").hasRole(STUDENT)
                .antMatchers("/students/*").hasRole(ADMIN)

                /** Преподаватели */
                .antMatchers(HttpMethod.GET,"/teachers/").hasAnyRole(TEACHER,STUDENT)
                .antMatchers(HttpMethod.GET,"/teachers/{id}").hasAnyRole(TEACHER,STUDENT)
                .antMatchers(HttpMethod.PUT,"/teachers/{id}").hasRole(TEACHER)
                .antMatchers("/teachers/*").hasRole(ADMIN)

                /** Факультеты */
                .antMatchers(HttpMethod.GET,"/faculties/").hasAnyRole(TEACHER,STUDENT,GUEST)
                .antMatchers(HttpMethod.GET,"/faculties/{id}").hasAnyRole(TEACHER,STUDENT,GUEST)
                .antMatchers("/faculties/*").hasRole(ADMIN)

                /** Кафедры */
                .antMatchers(HttpMethod.GET,"/departments/").hasAnyRole(TEACHER,STUDENT,GUEST)
                .antMatchers(HttpMethod.GET,"/departments/{id}").hasAnyRole(TEACHER,STUDENT,GUEST)
                .antMatchers("/departments/*").hasRole(ADMIN)

                /** Специальности */
                .antMatchers(HttpMethod.GET,"/specialties/").hasAnyRole(TEACHER,STUDENT,GUEST)
                .antMatchers(HttpMethod.GET,"/specialties/{id}").hasAnyRole(TEACHER,STUDENT,GUEST)
                .antMatchers("/specialties/*").hasRole(ADMIN)

                /** Предметы */
                .antMatchers(HttpMethod.GET,"/subjects/").hasAnyRole(TEACHER,STUDENT)
                .antMatchers(HttpMethod.GET,"/subjects/{id}").hasAnyRole(TEACHER,STUDENT)
                .antMatchers("/subjects/*").hasRole(ADMIN)

                /** Группы студентов */
                .antMatchers(HttpMethod.GET,"/groups/").hasAnyRole(TEACHER,STUDENT)
                .antMatchers(HttpMethod.GET,"/groups/{id}").hasAnyRole(TEACHER,STUDENT)
                .antMatchers("/groups/*").hasRole(ADMIN)

                /** Журнал посещаемости и успеваемости */
                .antMatchers(HttpMethod.GET,"/journal**").hasAnyRole(STUDENT)
                .antMatchers(HttpMethod.GET,"/journal/*").hasAnyRole(STUDENT)
                .antMatchers(HttpMethod.GET,"/journal/scores/{id}").hasAnyRole(STUDENT)
                .antMatchers(HttpMethod.GET,"/journal/passes/{id}").hasAnyRole(STUDENT)
                .antMatchers(HttpMethod.GET,"/journal/passes-number/{id}").hasAnyRole(STUDENT)
                .antMatchers(HttpMethod.GET,"/journal/passes-marks/{id}").hasAnyRole(STUDENT)
                .antMatchers("/journal/*").hasAnyRole(ADMIN,TEACHER)

                /** Расписание */
                .antMatchers(HttpMethod.GET,"/schedule/").hasAnyRole(TEACHER,STUDENT)
                .antMatchers(HttpMethod.GET,"/schedule/{id}").hasAnyRole(TEACHER,STUDENT)
                .antMatchers(HttpMethod.GET,"/schedule/lessons/{id}").hasRole(TEACHER)
                .antMatchers(HttpMethod.GET,"/schedule/lessons-count/{id}").hasRole(TEACHER)
                .antMatchers("/schedule/*").hasRole(ADMIN)

//                .anyRequest().authenticated()
                ;
    }

    @Autowired
    public void userDetailsService(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication().withUser("admin")
                .password("{noop}admin")
                .roles(ADMIN, TEACHER,STUDENT,GUEST);
        builder.inMemoryAuthentication().withUser("teacher")
                .password("{noop}teacher")
                .roles(TEACHER);
        builder.inMemoryAuthentication().withUser("student")
                .password("{noop}student")
                .roles(STUDENT);
        builder.inMemoryAuthentication().withUser("guest")
                .password("{noop}guest")
                .roles(GUEST);
    }
}