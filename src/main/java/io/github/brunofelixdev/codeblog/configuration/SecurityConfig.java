package io.github.brunofelixdev.codeblog.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

    private static final String[] AUTH_LIST = {
            "/",
            "/posts",
            "/posts/{id}"
    };

//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.csrf().disable().authorizeHttpRequests().requestMatchers(AUTH_LIST).permitAll()
//                .anyRequest().authenticated()
//                .and().formLogin().permitAll()
//                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
//    }
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication()
//                .withUser("michelli").password("{noop}123").roles("ADMIN");
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception{
//        web.ignoring().requestMatchers("/bootstrap/**");
////        web.ignoring().antMatchers("/bootstrap/**", "/style/**");
//    }
}
