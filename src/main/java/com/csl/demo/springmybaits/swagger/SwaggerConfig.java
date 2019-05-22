package com.csl.demo.springmybaits.swagger;
 
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 /**
  * http://localhost:8080/ymall/swagger/index.html#/
  * 常用注解： 
			- @Api()用于类； 
			表示标识这个类是swagger的资源 
			- @ApiOperation()用于方法； 
			表示一个http请求的操作 
			- @ApiParam()用于方法，参数，字段说明； 
			表示对参数的添加元数据（说明或是否必填等） 
			- @ApiModel()用于类 
			表示对类进行说明，用于参数用实体类接收 
			- @ApiModelProperty()用于方法，字段 
			表示对model属性的说明或者数据操作更改 
			- @ApiIgnore()用于类，方法，方法参数 
			表示这个方法或者类被忽略 
			- @ApiImplicitParam() 用于方法 
			表示单独的请求参数 
			- @ApiImplicitParams() 用于方法，包含多个 @ApiImplicitParam
  * @author Cherry
  * @date  2019年5月17日
  */
//@Configuration //声明该类为配置类
@EnableSwagger2 //声明启动Swagger2
@EnableWebMvc //声明启动mvc
public class SwaggerConfig{
	/*
	 * Docket可以配置多个
	 */
    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ymall.controller"))//扫描的包路径
                .build();
    }
 
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口测试")//文档说明
                .version("1.0.0")//文档版本说明
                .build();
    }
}
