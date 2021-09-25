package vip.efactory.common.i18n.service;


import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

/**
 * 这是一个专门用来处理国际化的组件
 * 以后可以优化使用配置的文件里的参数
 */
//@Component
public class LocaleMsgSourceServiceImpl implements ILocaleMsgSourceService {

    /**
     * Description:注入Spring提供的Bean
     */
//    @Autowired
    private MessageSource messageSource;

    public LocaleMsgSourceServiceImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String getMessage(String key) {
        return this.getMessage(key, new Object[]{});
    }

    @Override
    public String getMessage(String key, String defaultValue) {
        return this.getMessage(key, null, defaultValue);
    }

    @Override
    public String getMessage(String key, String defaultValue, Locale locale) {
        return this.getMessage(key, null, defaultValue, locale);
    }

    @Override
    public String getMessage(String key, Locale locale) {
        return this.getMessage(key, null, "", locale);
    }


    @Override
    public String getMessage(String key, Object[] args) {
        return this.getMessage(key, args, "");
    }

    @Override
    public String getMessage(String key, Object[] args, Locale locale) {
        return this.getMessage(key, args, "", locale);
    }

    @Override
    public String getMessage(String key, Object[] args, String defaultValue) {
        //这里使用比较方便的方法，不依赖request.
        Locale locale = LocaleContextHolder.getLocale();
        return this.getMessage(key, args, defaultValue, locale);
    }

    @Override
    public String getMessage(String key, Object[] args, String defaultValue, Locale locale) {
        return messageSource.getMessage(key, args, defaultValue, locale);
    }
}
