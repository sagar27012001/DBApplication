package com.example.DBApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import antlr.collections.List;

@Controller
public class HomeController {
    @Autowired
    AddRepo repo;

    @RequestMapping("/")
    public String home() {
        return "home.jsp";
    }

    @RequestMapping("/addAlien")
    public String addAlien(Alien alien) {
        repo.save(alien);
        return "home.jsp";
    }

    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam("aid") int aid) {
        ModelAndView mv = new ModelAndView();
        Alien alien = repo.findById(aid).orElse(new Alien());
        mv.setViewName("search.jsp");
        mv.addObject(alien);
        Alien[] alien2 = repo.findByAname("sagar");
        mv.addObject(alien2);
        return mv;
    }

    @RequestMapping("/delAlien")
    public ModelAndView delAlien(@RequestParam("aid") int aid) {
        ModelAndView mv2 = new ModelAndView("delete.jsp");
        repo.deleteById(aid);
        return mv2;
    }

    @RequestMapping("/delAlien2")
    public ModelAndView delAlien2(@RequestParam("aid") int aid) {
        ModelAndView mv4 = new ModelAndView("update.jsp");
        repo.deleteById(aid);
        return mv4;
    }

    @RequestMapping("/updateAlien")
    public ModelAndView updateAlien(Alien alien) {
        ModelAndView mv3 = new ModelAndView("home.jsp");
        repo.save(alien);
        return mv3;
    }
}
