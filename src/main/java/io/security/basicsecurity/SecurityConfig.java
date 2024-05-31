package io.security.basicsecurity;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

import static org.springframework.security.config.Customizer.withDefaults;


// https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter 스프링 영어 문서
//https://kimchanjung.github.io/programming/2020/07/02/spring-security-02/  함수 정리 블로그
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {   //파비콘같은거 할때 튕기면 안되서
        return (web) -> web.ignoring().requestMatchers("/loginPage"); // `/ignore/` 경로의 요청을 무시
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http
                .authorizeHttpRequests((requests) -> requests  // http요청의 접근을 제한하겠다
                        .requestMatchers("/api/hello").permitAll() // api/hello 에대한 접근은 인증없이 허용하겠다
                        .anyRequest().authenticated() //나머지는 인증을 받겠다 인데 왜 접근이 안되냐
                );
//        .requestMatchers("/public/**").permitAll()    // `/public/` 경로의 모든 요청을 허용
//                .requestMatchers("/admin/**").hasRole("ADMIN") // `/admin/` 경로는 관리자만 접근 가능
//                .requestMatchers("/user/**").hasRole("USER")   // `/user/` 경로는 사용자만 접근 가능
//                .anyRequest().authenticated()

        return http.build();

    }
}

//@Bean
//public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
////        // 사이트 위변조 요청 방지
////        http.csrf(AbstractHttpConfigurer::disable);
//
//    http
//            .authorizeHttpRequests((requests) -> requests
//                    .anyRequest().authenticated()
//            )
//            .formLogin(form -> form
//                    .loginPage("/loginPage")   				// 사용자 정의 로그인 페이지
//                    .defaultSuccessUrl("/")				    // 로그인 성공 후 이동 페이지
//                    .failureUrl("/login")	// 로그인 실패 후 이동 페이지
//                    .usernameParameter("username")			// 아이디 파라미터명 설정
//                    .passwordParameter("password")			// 패스워드 파라미터명 설정
//                    .loginProcessingUrl("/login_proc")			// 로그인 Form Action url 명칭 정하는건데 쓸모있나?
//                    .successHandler(new AuthenticationSuccessHandler() {
//                                        @Override
//                                        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//                                            System.out.println("authentication success" + authentication.getName());
//                                            response.sendRedirect("/");
//                                        }
//                                    }
//                    ).failureHandler(new AuthenticationFailureHandler() {
//                        @Override
//                        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//                            System.out.println("exception" + exception.getMessage());
//                            response.sendRedirect("/login");
//                        }
//                    })
//                    .permitAll()
//
//            );
//
//
//    return http.build();
//
//}

