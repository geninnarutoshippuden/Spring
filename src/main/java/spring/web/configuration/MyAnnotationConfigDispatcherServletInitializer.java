package spring.web.configuration;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyAnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {ServletWebAppConfig.class};
    }


    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {RootWebAppConfig.class};
    }
}
