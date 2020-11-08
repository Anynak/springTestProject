package testgroup.filmography.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import testgroup.filmography.model.Film;
import testgroup.filmography.service.FilmService;
import testgroup.filmography.service.FilmServiceImpl;

import java.util.List;

@Controller
public class FilmController {
    private final FilmService filmService = new FilmServiceImpl();
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allFilms() {
        ModelAndView modelAndView = new ModelAndView();

        List<Film> films = filmService.allFilms();
        modelAndView.setViewName("films");
        modelAndView.addObject("filmsList", films);

        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editFilm(@ModelAttribute("film") Film film) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(film);
        modelAndView.setViewName("redirect:/");
        filmService.edit(film);
        return modelAndView;
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addFilm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add");
        return modelAndView;
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        Film film = filmService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("film", film);
        return modelAndView;
    }
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteFilm(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Film film = filmService.getById(id);
        filmService.delete(film);
        return modelAndView;
    }

}