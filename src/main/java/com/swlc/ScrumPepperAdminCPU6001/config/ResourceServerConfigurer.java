package com.swlc.ScrumPepperAdminCPU6001.config;

import com.swlc.ScrumPepperAdminCPU6001.constant.ApplicationConstant;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

/**
 * @author hp
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {
    private static final String RESOURCE_ID = "resource_id";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
//                anonymous().disable()
                .authorizeRequests()
// ------------ /corporate --------------------------------------------------------------------------------------------------
                .antMatchers(HttpMethod.GET, ApplicationConstant.API_BASE_URL + "/corporate/all")
                .access("hasAnyRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.PATCH, ApplicationConstant.API_BASE_URL + "/corporate/all")
                .access("hasAnyRole('ROLE_ADMIN')")
// ------------ /user --------------------------------------------------------------------------------------------------
                .antMatchers(HttpMethod.GET, ApplicationConstant.API_BASE_URL + "/user/all")
                .access("hasAnyRole('ROLE_ADMIN')")

                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}
