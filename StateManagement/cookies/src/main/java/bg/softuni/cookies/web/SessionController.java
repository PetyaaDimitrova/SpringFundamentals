package bg.softuni.cookies.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class SessionController {

    private static final String LANG_SESSION_ATTRIBUTE = "lang";
    private static final String DEFAULT_LANG = "en";


    @GetMapping("/session")
    public String session(HttpSession session, Model model){

        var lang = session.getAttribute(LANG_SESSION_ATTRIBUTE);

        model.addAttribute("lang", lang != null ? lang : DEFAULT_LANG);
        return "session";
    }

    @PostMapping("/session")
    public String session( HttpSession session,
            @RequestParam("language") String language) {

        session.setAttribute("lang", language);

        return "redirect:/session";
    }
}
