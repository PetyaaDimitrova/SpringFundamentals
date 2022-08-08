package bg.softuni.mobilele.user;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {

    private String name;
    private boolean isLogged;

    public String getName() {
        return name;
    }

    public CurrentUser setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public boolean isAnonymous(){
        return  !isLogged;
    }

    public CurrentUser setLogged(boolean logged) {
        isLogged = logged;
        return this;
    }

    public void clear(){
        isLogged = false;
        name = null;
    }
}
