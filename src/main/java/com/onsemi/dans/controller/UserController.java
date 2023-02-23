package com.onsemi.dans.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import com.onsemi.dans.model.UserSession;
import com.onsemi.dans.tools.EmailSender;
import com.onsemi.dans.tools.SystemUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes({"userSession"})
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    String[] args = {};

    @Autowired
    ServletContext servletContext;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String user(Model model, @ModelAttribute UserSession userSession) {
        return "user/user";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile() {
        return "user/profile";
    }

    @RequestMapping(value = "/email/text", method = RequestMethod.GET)
    public String textEmail(Model model, HttpServletRequest request) {
        EmailSender emailSender = new EmailSender();
//        emailSender.textEmail(
//                "sarmifairuz@gmail.com",
//                "Hello From TEXTSPML",
//                "Text Email Test"
//        );
        emailSender.textEmail(
                "zbqb9x@onsemi.com",
                "Hello From TEXTSPML",
                "Text Email Test"
        );
        return "redirect:/";
    }

    @RequestMapping(value = "/email/html", method = RequestMethod.GET)
    public String htmlEmail(Model model, @ModelAttribute UserSession userSession) {
        EmailSender emailSender = new EmailSender();
        com.onsemi.dans.model.User user = new com.onsemi.dans.model.User();
        user.setFullname(userSession.getFullname());
//        emailSender.htmlEmail(
//                servletContext,
//                user,
//                "sarmifairuz@gmail.com",
//                "Hello From HTML SPML",
//                "Text Email Test"
//        );
        emailSender.htmlEmail(
                servletContext,
                user,
                "zbqb9x@onsemi.com",
                "Hello From HTML SPML",
                "Text Email Test"
        );
        return "redirect:/";
    }

    @RequestMapping(value = "/email/mime", method = RequestMethod.GET)
    public String mimeEmail(Model model, @ModelAttribute UserSession userSession) {
        EmailSender emailSender = new EmailSender();
        com.onsemi.dans.model.User user = new com.onsemi.dans.model.User();
        user.setFullname(userSession.getFullname());
//        emailSender.mimeEmail(
//                servletContext,
//                user,
//                "sarmifairuz@gmail.com",
//                "Hello From MIME SPML",
//                "Text Email Test"
//        );
        emailSender.mimeEmail(
                servletContext,
                user,
                "zbqb9x@onsemi.com",
                "Hello From MIME SPML",
                "Text Email Test"
        );
        return "redirect:/";
    }

    @RequestMapping(value = "/email/login", method = RequestMethod.GET)
    public String emailLogin(
            Model model, 
            HttpServletRequest request, 
            @ModelAttribute UserSession userSession) {
        EmailSender emailSender = new EmailSender();
        com.onsemi.dans.model.User user = new com.onsemi.dans.model.User();
        user.setFullname(userSession.getFullname());
        String emailTitle = "DANS Login Information";
        String emailContent = "Login ID: " + userSession.getLoginId() + "<br/>"
                + "Password: ********<br/><br/>"
                + "Please login and complete your Profile Information.<br/><br/>"
                + "<a href='" + SystemUtil.serverUrl(request) + "' target='_blank'>LOGIN HERE</a>";
//        emailSender.htmlEmail(
//                servletContext,
//                user,
//                "sarmifairuz@gmail.com",
//                emailTitle,
//                emailContent
//        );
        emailSender.htmlEmail(
                servletContext,
                user,
                "zbqb9x@onsemi.com",
                emailTitle,
                emailContent
        );
        return "redirect:/";
    }

}
