package app.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class AllController {

    @Autowired
    private app.home.controller.AppProperties appProperties;

    @RequestMapping("/{d1}.html")
    public ModelAndView getAll(@PathVariable("d1") String d1){
        ModelAndView view = new ModelAndView();
        view.setViewName(d1);
        view.addObject("app", appProperties);
        return view;
    }

    @RequestMapping("/{d1}/{d2}.html")
    public ModelAndView getAll(@PathVariable("d1") String d1 , @PathVariable("d2") String d2){
        ModelAndView view = new ModelAndView();
        view.setViewName( d1 + "/" +  d2);
        view.addObject("app", appProperties);
        return  view;
    }

    @RequestMapping("/{d1}/{d2}/{d3}.html")
    public ModelAndView getAll(@PathVariable("d1") String d1,
                         @PathVariable("d2") String d2,
                         @PathVariable("d3") String d3){
        ModelAndView view = new ModelAndView();
        view.setViewName(d1 + "/" + d2 + "/" + d3);
        view.addObject("app", appProperties);
        return view;
    }


    @RequestMapping("/{d1}/{d2}/{d3}/{d4}.html")
    public ModelAndView getAll(@PathVariable("d1") String d1,
                         @PathVariable("d2") String d2,
                         @PathVariable("d3") String d3,
                         @PathVariable("d4") String d4){
        ModelAndView view = new ModelAndView();
        view.setViewName(d1 + "/" + d2 + "/" + d3 + "/" + d4);
        view.addObject("app", appProperties);
        return view;
    }


    @RequestMapping("/{d1}/{d2}/{d3}/{d4}/{d5}.html")
    public ModelAndView getAll(@PathVariable("d1") String d1,
                         @PathVariable("d2") String d2,
                         @PathVariable("d3") String d3,
                         @PathVariable("d4") String d4,
                         @PathVariable("d5") String d5){
        ModelAndView view = new ModelAndView();
        view.setViewName(d1 + "/" + d2 + "/" + d3 + "/" + d4 + "/" + d5);
        view.addObject("app", appProperties);
        return view;
    }
}
