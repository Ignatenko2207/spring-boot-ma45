package com.mainacad.config;

import com.mainacad.security.UserAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan("com.mainacad.security")
@Profile("jsp")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserAuthProvider userAuthProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("registration").anonymous()
                .antMatchers("/**").authenticated()
                .and().csrf().disable()
                .formLogin().loginPage("authorization")
                .loginProcessingUrl("/auth/login").usernameParameter("login")
                .and().logout();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(userAuthProvider);
    }
}
