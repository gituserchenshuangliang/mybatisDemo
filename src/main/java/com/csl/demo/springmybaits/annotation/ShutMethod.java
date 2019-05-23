package com.csl.demo.springmybaits.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 注解也叫元数据，例如我们常见的@Override和@Deprecated，注解是JDK1.5版本开始引入的一个特性，用于对代码进行说明，可以对包、类、接口、字段、方法参数、局部变量等进行注解。它主要的作用有以下四方面：
		生成文档，通过代码里标识的元数据生成javadoc文档。
		编译检查，通过代码里标识的元数据让编译器在编译期间进行检查验证。
		编译时动态处理，编译时通过代码里标识的元数据动态处理，例如动态生成代码。
		运行时动态处理，运行时通过代码里标识的元数据动态处理，例如使用反射注入实例。
    一般注解可以分为三类：
		一类是Java自带的标准注解，包括@Override、@Deprecated和@SuppressWarnings，分别用于标明重写某个方法、标明某个类或方法过时、标明要忽略的警告，用这些注解标明后编译器就会进行检查。
		一类为元注解，元注解是用于定义注解的注解，包括@Retention、@Target、@Inherited、@Documented，@Retention用于标明注解被保留的阶段，@Target用于标明注解使用的范围，@Inherited用于标明注解可继承，@Documented用于标明是否生成javadoc文档。
		一类为自定义注解，可以根据自己的需求定义注解，并可用元注解对自定义注解进行注解。
 * @author Cherry
 * @date  2019年5月23日
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ShutMethod {
	boolean isShunt() default false;
}
