package com.wjl.teacher_management.config;
import com.wjl.teacher_management.service.MyCustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.firewall.StrictHttpFirewall;

/**
 * @Author: wugege
 * @Date: 2020/2/25 15:46
 * 一给窝哩 giao giao 呀吼
 * 4
 */
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    MyCustomUserService myCustomUserService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myCustomUserService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        //去掉";"黑名单
        firewall.setAllowSemicolon(true);
        //加入自定义的防火墙
        web.httpFirewall(firewall);
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(new String[]{"/js/**","/css/**","/img/**","/images/**","/fonts/**","/**/favicon.ico","/login","/login.html","/role","/register/**","/register2","/changePassword"}).permitAll()
                //.antMatchers("/","index","/login","/login-error","/401","/static/**","/js/**").permitAll()
                // 只能让拥有 "ROLE_ADMIN"角色的用户访问。
                //hasAnyRole 拥有就可以访问 access同事具有()()权限的可以访问
                .antMatchers("/").hasAnyRole("USER","MANAGER")
                .antMatchers("/user/**").hasAnyRole("USER")
                .antMatchers("/manager/**").hasAnyRole("MANAGER","ADMIN")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().hasRole("ADMIN")
                .and()
                .csrf().disable()
                .headers().frameOptions().sameOrigin()
                 ; //登出成功后跳转页




        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authentication/form")
                .defaultSuccessUrl("/")
                .and()
                .logout().logoutSuccessUrl("/")
                .and()
                .csrf().disable()
        ;

//        http.authorizeRequests()
//                .anyRequest().permitAll().and().logout().permitAll()
//                .and()
//                .csrf().disable()
//                .headers().frameOptions().sameOrigin();//配置不需要登录验证


        //*************  test3   *****************

//        http.authorizeRequests()
//
//                .antMatchers(new String[]{"/js/**","/css/**","/img/**","/images/**","/fonts/**","/**/favicon.ico","/authentication/*","/login"}).permitAll()
//                //.antMatchers("/","index","/login","/login-error","/401","/static/**","/js/**").permitAll()
//                // 只能让拥有 "ROLE_ADMIN"角色的用户访问。
//                //hasAnyRole 拥有就可以访问 access同事具有()()权限的可以访问
//                .antMatchers("/","/user/**").hasAnyRole("USER")
//                //.antMatchers("/login.html", "/authentication/require",
//                //        "/authentication/form").permitAll()// 这些页面不需要身份认证,其他请求需要认证
//                .antMatchers("/","/manager/**").hasAnyRole("MANAGER")
//                .antMatchers("/","/admin/**").hasRole("ADMIN")
//                .anyRequest().hasRole("ADMIN")
//                .and()
//                .formLogin()
//                .loginPage("/login") // 设置登录页面
//               // .loginProcessingUrl("/authentication/form")
//                .defaultSuccessUrl("/") // 设置默认登录成功后跳转的页面
//                .and()
//                .csrf().disable()  //取消csrf防护
//
//        ;

    }
}
