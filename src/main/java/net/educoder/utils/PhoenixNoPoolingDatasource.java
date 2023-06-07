package net.educoder.utils;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.Driver;
import java.util.Properties;

public class PhoenixNoPoolingDatasource extends SimpleDriverDataSource {
    public PhoenixNoPoolingDatasource() {
    }

    public PhoenixNoPoolingDatasource(Driver driver, String url) {
        super(driver, url);
    }

    public PhoenixNoPoolingDatasource(Driver driver, String url, String username, String password) {
        super(driver, url, username, password);
    }

    public PhoenixNoPoolingDatasource(Driver driver, String url, Properties conProps) {
        super(driver, url, conProps);
    }

    public void setDriverClassName(String driverClassName) {
        try {
            Class<?> driverClass = this.getClass().getClassLoader().loadClass(driverClassName);
            setDriverClass((Class<? extends Driver>) driverClass);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load class of driverClassName " + driverClassName, e);
        }
    }
}
