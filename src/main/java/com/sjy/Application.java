package com.sjy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sunjiyun on 2017/10/10.
 */
@SpringBootApplication
@Controller
/**
 * The first step in producing a deployable war file is to provide a SpringBootServletInitializer subclass and override its configure() method. 
 * This makes use of Spring Framework’s Servlet 3.0 support and allows you to configure your application
 * when it’s launched by the servlet container.
 * @author sunjiyun
 *
 */
public class Application extends SpringBootServletInitializer {

    @RequestMapping("/")
    public String hello() {
        return "login";
    }

    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
