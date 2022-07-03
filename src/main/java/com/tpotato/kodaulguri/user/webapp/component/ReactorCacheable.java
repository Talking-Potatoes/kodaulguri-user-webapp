package com.tpotato.kodaulguri.user.webapp.component;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ReactorCacheable {
  String name();
}
