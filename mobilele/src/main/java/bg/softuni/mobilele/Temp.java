package bg.softuni.mobilele;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Temp implements CommandLineRunner {

    private PasswordEncoder passwordEncoder;

    public Temp(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(passwordEncoder.encode("abv"));
    }
}
