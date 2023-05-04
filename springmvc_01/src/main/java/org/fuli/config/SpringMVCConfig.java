package org.fuli.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.fuli.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan({"org.fuli.controller"})
@EnableWebMvc
public class SpringMVCConfig implements WebMvcConfigurer {

    @Bean
    public DispatcherServlet dispatcherServlet(){
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        return dispatcherServlet;
    }

    //文件上传
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setMaxUploadSize(10*1024*1024);
        resolver.setMaxInMemorySize(10*1024*1024);
        return resolver;
    }


//    @Bean
//    public RequestMappingHandlerAdapter requestMappingHandlerAdapter(){
//        RequestMappingHandlerAdapter handlerAdapter = new RequestMappingHandlerAdapter();
//        List<HttpMessageConverter<?>> list = new ArrayList<>();
//        list.add(new MappingJackson2HttpMessageConverter());
//        handlerAdapter.setMessageConverters(list);
//        return handlerAdapter;
//    }


    /**配置默认资源处理
     * 类似于配置下面的Bean
     * 配置默认servlet，映射静态资源路径
     *     @Bean
     *     DefaultServletHttpRequestHandler defaultServletHttpRequestHandler(){
     *         DefaultServletHttpRequestHandler handler = new DefaultServletHttpRequestHandler();
     *         return handler;
     *     }
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/xxx");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index.jsp");
    }

    @Override
    //配置json转换消息处理器
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        List<MediaType> mediaTypes = new ArrayList<MediaType>();
        mediaTypes.add(new MediaType(MediaType.TEXT_HTML, Charset.forName("UTF-8")));
        mediaTypes.add(new MediaType(MediaType.APPLICATION_JSON, Charset.forName("UTF-8")));
        mediaTypes.add(new MediaType(MediaType.APPLICATION_XML, Charset.forName("UTF-8")));

        converter.setSupportedMediaTypes(mediaTypes);

        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

        converter.setFastJsonConfig(fastJsonConfig);

        converters.add(converter);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置静态资源映射
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:static/");
    }
}
