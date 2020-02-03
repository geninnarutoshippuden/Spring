package spring.web.configuration;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Nullable
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {AppConfig.class};
    }

    @Nullable
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {SpringMvcConfig.class};
    }
}
