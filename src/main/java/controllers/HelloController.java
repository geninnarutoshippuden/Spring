package controllers;

import models.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@ControllerAdvice
public class HelloController implements org.springframework.web.servlet.mvc.Controller {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView hello1() {
        ModelAndView modelAndView = new ModelAndView("hello");
//        modelAndView.addObject("msg", "Message From Hello Controller");
        return modelAndView;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public ModelAndView hello2() {
        ModelAndView modelAndView = new ModelAndView("hello");
//        modelAndView.addObject("msg", "Message From Hello Controller");
        return modelAndView;
    }

    @RequestMapping(value = "/hello")
    public ModelAndView hello3(Model model) {
        ModelAndView modelAndView = new ModelAndView("hello");
//        modelAndView.addObject("msg", "Message From Hello Controller");
        return modelAndView;
    }

    @RequestMapping(value = "/hello", params = {"k"})
    public ModelAndView hello5(@ModelAttribute("msg") String msg) {
        ModelAndView modelAndView = new ModelAndView("hello");
//        modelAndView.addObject("msg", "Message From Hello Controller");
        return modelAndView;
    }

    @RequestMapping(value = "/hello", params = {"!k"})
    public ModelAndView hello9(@ModelAttribute("msg") String msg) {
        ModelAndView modelAndView = new ModelAndView("hello");
//        modelAndView.addObject("msg", "Message From Hello Controller");
        return modelAndView;
    }

    @RequestMapping(value = "/hello", params = {"k", "j"})
    public ModelAndView hello8(@ModelAttribute("msg") String msg) {
        ModelAndView modelAndView = new ModelAndView("hello");
//        modelAndView.addObject("msg", "Message From Hello Controller");
        return modelAndView;
    }


    @RequestMapping(value = "/hello", params = {"!j", "k"})
    public ModelAndView hello4(@ModelAttribute("msg") String msg) {
        ModelAndView modelAndView = new ModelAndView("hello");
//        modelAndView.addObject("msg", "Message From Hello Controller");
        return modelAndView;
    }

    @RequestMapping(value = "/hello", params = {"!j", "k", "l"})
    public ModelAndView hello6(@ModelAttribute("msg") String msg) {
        ModelAndView modelAndView = new ModelAndView("hello");
//        modelAndView.addObject("msg", "Message From Hello Controller");
        return modelAndView;
    }


    @GetMapping("/hello/{firstValue}/{secondValue}")
    public ModelAndView example(@PathVariable("firstValue") String firstValue,
                                @PathVariable("secondValue") String secondValue) {
        ModelAndView modelAndView = new ModelAndView("hello");
//        modelAndView.addObject("msg", "Message From Hello Controller");
        return modelAndView;
    }

    @GetMapping(value = "/hello/{firstValue}/{secondValue:[\\w\\d.]+}", params = "k")
    public ModelAndView example2(@PathVariable("firstValue") String firstValue,
                                 @PathVariable("secondValue") String secondValue) {
        ModelAndView modelAndView = new ModelAndView("hello");
//        modelAndView.addObject("msg", "Message From Hello Controller");
        return modelAndView;
    }

    @GetMapping("/hello/employee")
    public ModelAndView helloEmployee(Model model) {
        ModelAndView modelAndView = new ModelAndView("hello");
        Employee employee = new Employee();
        employee.setId(123);
        employee.setName("Tom");
        modelAndView.addObject("msg", "Message from " + employee.getName());
        modelAndView.addObject("emp", employee);
        return modelAndView;
    }


//    @GetMapping("/hello/employee")
    public String helloEmployee2(@ModelAttribute("defaultEmp") Employee employee) {
       employee.setName("John Smith");
       return "hello";
    }

    @RequestMapping(value = "/hello/{emp}", method = RequestMethod.GET)
    public String helloEmployee3(@MatrixVariable Integer id, @MatrixVariable String name,
                                 @MatrixVariable Number[] numbers,
                                 Model model,
                                 @PathVariable("emp") String path,
                                 HttpServletRequest request) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setId(1);
        model.addAttribute("emp", employee);
        return "hello";
    }

    @RequestMapping(value = "/hello/companyEmployee/{comp}/{emp}", method = RequestMethod.GET)
    public String helloEmployee4(@MatrixVariable(value = "name", pathVar = "comp") String name,
                                 Model model,
                                 @PathVariable("emp") String emp,
                                 HttpServletRequest request) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setId(Integer.parseInt("3"));
        model.addAttribute("emp", employee);
        return "hello";
    }


    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("hello");
//        modelAndView.addObject("msg", "Message From Hello Controller");
        return modelAndView;
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("defaultMsg", "Message from method with @ModelAttribute annotation");
        Employee employee = new Employee();
        employee.setName("John");
        employee.setId(98);

        model.addAttribute("defaultEmp", employee);
    }
}
