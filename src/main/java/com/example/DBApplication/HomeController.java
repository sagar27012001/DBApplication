package com.example.DBApplication;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
        // System.out.println(repo.findByAname("sagar"));
        // System.out.println(repo.findByAidGreaterThan(2));
        // System.out.println(repo.findByAnameSorted("sagar"));
        mv.addObject(alien);
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

    @RequestMapping("aliens")
    @ResponseBody
    public List<Alien> aliens() {
        return repo.findAll();
    }

    @RequestMapping("alien/{aid}")
    @ResponseBody
    public Optional<Alien> aliens(@PathVariable("aid") int aid) {
        return repo.findById(aid);
    }
}
