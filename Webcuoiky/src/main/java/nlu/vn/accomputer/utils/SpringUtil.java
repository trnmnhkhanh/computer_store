package nlu.vn.accomputer.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SpringUtil {
    public static ApplicationContext appCt;

    @Autowired
    private void setApplicationContext(ApplicationContext context){  appCt=context;

    }
}
