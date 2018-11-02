package com.dc.dcrud.web.view.support.viewpojo.datatable;

import com.dc.dcrud.web.view.data.TableOptionButtonFilter;
import com.dc.dcrud.web.view.option.OperationPermissionCheck;

import java.lang.annotation.*;

/**
 * <p>Descriptions...
 *
 * @author Diamon.Cheng
 * @date 2018/11/1.
 */
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface TableOptionButtonConfig {
    String name();
    
    String title() default "";
    
    String id() default "";
    
    String[] classes() default {};
    
    String href() default "javascript:";
    
    Class<? extends OperationPermissionCheck> permissionCheckClass() default OperationPermissionCheck.class;
    
    com.dc.dcrud.web.view.option.OptionButton.Type type() default com.dc.dcrud.web.view.option.OptionButton.Type.DEFAULT;
    
    Class<? extends TableOptionButtonFilter> filter() default TableOptionButtonFilter.class;
}
