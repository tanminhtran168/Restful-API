package com.hust.baseweb.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD}) // xác định nó sẽ được đặt trên các phương thức
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAfter {
}
