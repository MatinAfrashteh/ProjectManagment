//package com.example.ProjectManagment;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class Config implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")  // یا مسیرهای خاص خود را وارد کنید
//                .allowedOrigins("*")  // اجازه دسترسی به همه منابع (می‌توانید آدرس‌های خاص را وارد کنید)
//                .allowedMethods("GET", "POST", "PUT", "DELETE")  // متدهای مجاز
//                .allowedHeaders("*")  // هدرهای مجاز
//                .allowCredentials(true);  // اگر نیاز به اعتبارسنجی دارید
//    }
//}
