package im.hdy.rsa.utils;

import org.hibernate.cfg.DefaultNamingStrategy;
import org.hibernate.cfg.ImprovedNamingStrategy;

/**
 * Created by hdy on 2017/7/10.
 */
public class MySQLUpperCaseStrategy extends ImprovedNamingStrategy {

    @Override
    public String tableName(String tableName) {
        return tableName.toUpperCase();
    }
}
