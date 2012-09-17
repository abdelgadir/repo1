package core.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.Produces;

/**
 * Date: 13/09/12
 * Time: 08:52
 */
public class Factory {
    private static Logger logger = LoggerFactory.getLogger(Factory.class);
    static {
        final String iniFile = "classpath:shiro.ini";
        logger.info("Initializing Shiro INI SecurityManager using " + iniFile);
        SecurityManager securityManager = new IniSecurityManagerFactory(iniFile).getInstance();
        SecurityUtils.setSecurityManager(securityManager);
    }

    @Produces
    public Subject getCurrentSubject(){
        return SecurityUtils.getSubject();
    }
}
