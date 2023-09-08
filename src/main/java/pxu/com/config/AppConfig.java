package pxu.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import pxu.com.repository.ProductRepository;
import pxu.com.repository.ProductRepositoryImpl;
import pxu.com.service.ProductService;
import pxu.com.service.ProductSeviceImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "pxu.com" })
public class AppConfig implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public ProductService productService() {
		return new ProductSeviceImpl();
	}

	@Bean
	public ProductRepository productRepository() {
		return new ProductRepositoryImpl();
	}
}