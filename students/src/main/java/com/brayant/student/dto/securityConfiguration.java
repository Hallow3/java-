package com.brayant.student.dto;
/*package com.brayant.demo.configuration;

import javax.servlet.annotation.WebFilter;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@WebFilter(urlPatterns = "/static/**")
public class securityConfiguration  extends WebSecurityConfigurerAdapter{

	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Autowired
	DataSource dataSource;
	
	@Value("${spring.queries.users-query}")
	private String usersQuery;
	
	@Value("${spring-queries-roles-query:select u.user_mail,r.role_name from user u inner join user_role ur on(u.user_id=ur.user_id and r.role_id=ur.role_id)}")
	private String rolesQuery;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery)
		.dataSource(dataSource).passwordEncoder(bcryptPasswordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		//configuration des url valide pour sauthentifier
		.antMatchers("/").permitAll()
		.antMatchers("/home").permitAll()
		.antMatchers("/search").permitAll()
		.antMatchers("/recette/**").permitAll()
		.antMatchers("/recettes/**").permitAll()
		.antMatchers("/recettes").permitAll()
		.antMatchers("/description").permitAll()
		.antMatchers("/recetteCategorie").permitAll()
		.antMatchers("/recherche").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers("/register").permitAll()
		.antMatchers("/admin/**").hasAnyAuthority("SUPER_USER","ADMIN_USER","SITE_USER")
		.antMatchers("/static/bootstrap-5.0.2-dist/css/**","/static/bootstrap-5.0.2-dist/js/**").permitAll()
		.anyRequest().authenticated()
		.and()
		// formulaire de connexion
		.csrf().disable().formLogin()
		.loginPage("/login")
		.failureUrl("/login?error=true")
		.defaultSuccessUrl("/admin/recettes")
		.usernameParameter("user_email")
		.passwordParameter("user_password")
		.and()
		//gestion de la deconnexion
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/home").and()
		// gestion des exeptions
		.exceptionHandling()
		.accessDeniedPage("/access-denied");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/resources/**","/templates/**","/static/**");
	}
	
}
*/
