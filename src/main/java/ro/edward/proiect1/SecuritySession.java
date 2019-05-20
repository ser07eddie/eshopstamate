package ro.edward.proiect1;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SecuritySession {

    boolean isLogged;
    int userId;

    public void markUserLogged() {

        isLogged = true;
    }

    public boolean isUserLogged() {

        return isLogged;
    }

    public boolean userNotLogged() {
        return isLogged = false;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
