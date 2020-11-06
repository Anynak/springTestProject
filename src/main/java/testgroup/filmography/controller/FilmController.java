package testgroup.filmography.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import testgroup.filmography.model.Film;
import testgroup.filmography.service.FilmService;
import testgroup.filmography.service.FilmServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class FilmController {
    private FilmService filmService = new FilmServiceImpl();

    @RequestMapping
    public String handleAllTradesRequests (@RequestHeader("User-Agent") String userAgent,
                                           Model model) {
        model.addAttribute("msg", "all trades requests, User-Agent header  : "
                + userAgent);
        System.out.println(userAgent);

        return "my-page";
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String allFilms(HttpServletRequest request) {

        String userAgent = request.getHeader("User-Agent");
        ModelAndView modelAndView = new ModelAndView();
        List<Film> films = filmService.allFilms();
        //modelAndView.setViewName("films");
        modelAndView.addObject("filmsList", userAgent.toString());

        return "films";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }



}