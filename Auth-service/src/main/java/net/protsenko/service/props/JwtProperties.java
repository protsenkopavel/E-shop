package net.protsenko.service.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "security.jwt")
public class JwtProperties {

    private String secret;

    private Long access;

    private Long refresh;

    public String getSecret() {
        return secret;
    }

    public Long getAccess() {
        return access;
    }

    public Long getRefresh() {
        return refresh;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public void setAccess(Long access) {
        this.access = access;
    }

    public void setRefresh(Long refresh) {
        this.refresh = refresh;
    }
}
