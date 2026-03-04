package com.example.demo;

import jakarta.servlet.FilterChain;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Configuration
	public class WebMvcConfiguration implements WebMvcConfigurer{
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**")
					.allowedOrigins("/*")
					.allowedMethods("GET", "POST", "PUT", "DELETE");
		}
	}

	@Configuration
	@EnableWebSecurity
	public class SecurityConfig{

		@Bean
		public PasswordEncoder passwordEncoder(){
			return new BCryptPasswordEncoder();
		}

		@Bean
		public AuthenticationProvider authenticationProvider(
				UserDetailsService userDetailsService,
				PasswordEncoder passwordEncoder) {

			DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
			provider.setPasswordEncoder(passwordEncoder);
			return provider;
		}

		@Bean
		public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
			return http
					.csrf(AbstractHttpConfigurer::disable)
					.authorizeHttpRequests(request ->
							request.requestMatchers("/register", "/login").permitAll()
									.anyRequest().authenticated())
					.httpBasic(Customizer.withDefaults())
					.sessionManagement(
							session -> session.sessionCreationPolicy(
									SessionCreationPolicy.STATELESS
							)
					)
					//.oauth2ResourceServer(oauth ->
					//		oauth.jwt(Customizer.withDefaults()))
					.build();
		}
	}
}
