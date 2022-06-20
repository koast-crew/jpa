//package net.koast.jpa.config;
//
//import com.whatailsyou.admin.interceptor.AccessLogInterceptor;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.MessageSourceAccessor;
//import org.springframework.context.support.ReloadableResourceBundleMessageSource;
//import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
//import org.springframework.web.servlet.config.annotation.*;
//
///**
// * 상속을 안 받아도 될거 같은데. interceptor 같은걸 어떻게 적용 할지를 모르겠음
// * $author : gt1000
// * @date   : 2021-10-20 오후 6:13
// */
//@Slf4j
//@RequiredArgsConstructor
//@EnableWebMvc
//@Configuration
//public class ServletConfig implements WebMvcConfigurer {
//
//    private final AccessLogInterceptor logInterceptor;
//
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(logInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/login/**", "/error", "/docs/*", "/swagger/*");
//    }
//
//    /**
//     * TODO 운영에서는 docs 노출하면 안됨
//     * $author : gt1000
//     * @date   : 2021-10-20 오후 6:28
//     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        log.info(" @@@ ServletConfig addResourceHandlers @@@");
//
//        // profile 을 사용해서 로컬, 개발에서만 적용
//        registry.addResourceHandler("/**").addResourceLocations("classpath:static/");
//    }
//
//    @Bean
//    public ReloadableResourceBundleMessageSource messageSource(){
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
////        messageSource.setBasenames("classpath:/messages/messages", "classpath:org/springframework/security/messages");
//        messageSource.setBasename("classpath:/messages/messages");
//        messageSource.setDefaultEncoding("UTF-8");
//        return messageSource;
//    }
//
//    @Bean
//    public MessageSourceAccessor getMessageSourceAccessor(){
//        ReloadableResourceBundleMessageSource m = messageSource();
//        return new MessageSourceAccessor(m);
//    }
//
//    /**
//     * anotation @Valid 를 사용하려면 이 빈을 생성해 줘야 함
//     */
//    @Bean
//    public LocalValidatorFactoryBean getValidator() {
//        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
//        bean.setValidationMessageSource(messageSource());
//        return bean;
//    }
//}
