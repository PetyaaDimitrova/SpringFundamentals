package com.softuni.CoffeeShop.session;

import com.softuni.CoffeeShop.models.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoggedUser {

    private long id;
    private String lastName;

    public void login(User user){
        this.id = user.getId();
        this.lastName = user.getLastName();
    }

    public void logout(){
        this.id = 0;
        this.lastName = "";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
