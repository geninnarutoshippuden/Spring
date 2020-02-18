package controllers;

import models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Map;

@Controller
@ControllerAdvice
//@SessionAttributes("session_emp")
public class HelloController implements org.springframework.web.servlet.mvc.Controller {

    @Autowired
    private Employee employee;

    @RequestMapping(value = "input/session_emp", method = RequestMethod.POST)
    public ResponseEntity<String> addToSpringSession(@RequestBody Employee employee, Model model) {
        model.addAttribute("session_emp", employee);
        model.addAttribute("not_session_emp", employee);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "input/http_session_emp", method = RequestMethod.POST)
    public ResponseEntity<String> addToHttpSession(@RequestBody Employee employee, HttpSession session) {
        session.setAttribute("http_session_emp", employee);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "input/bean_session_emp", method = RequestMethod.POST)
    public ResponseEntity<String> addToSessionBean(@RequestBody Employee emp, Model model) {
        employee.setId(emp.getId());
        employee.setName(emp.getName());
        model.addAttribute("employee", employee);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

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

    @GetMapping(value = "/hello/{id}")
    public ModelAndView example5(@PathVariable("id") String idPath, @RequestParam String idParam) {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("msg", "Message From Hello Controller");
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

//    @GetMapping("/hello/employee")
    public ModelAndView helloEmployee(Model model) {
        ModelAndView modelAndView = new ModelAndView("hello");
        Employee employee = new Employee();
        employee.setId(123);
        employee.setName("Tom");
        modelAndView.addObject("msg", "Message from " + employee.getName());
        modelAndView.addObject("emp", employee);
        return modelAndView;
    }


    @GetMapping("/hello/employee")
    public String helloEmployee2(@ModelAttribute("defaultEmp") Employee employee) {
       employee.setName("John Smith");
       return "hello";
    }


    @GetMapping("/hello/params")
    public String hello(WebRequest webRequest, NativeWebRequest nativeWebRequest, HttpMethod httpMethod,
                        @RequestAttribute(required = false) String s, Principal principal) {
        return "hello";
    }

    @RequestMapping("/input")
    public String input() {
        return "input";
    }

    @RequestMapping(value = "/input/hello", method = RequestMethod.POST)
    public @ResponseBody Employee input2(Model model, @RequestParam Map<String, String> map,
                                         HttpServletRequest request, HttpSession session,
                                         @ModelAttribute("session_emp") Employee sessionEmp, @ModelAttribute("not_session_emp") Employee notSessionEmp) {
        return sessionEmp;
    }

    @RequestMapping(value = "/input/session", method = RequestMethod.POST)
    public @ResponseBody Employee getSessionEmp(Model model, @RequestParam Map<String, String> map,
                                                HttpServletRequest request, HttpSession session,
                                                SessionStatus sessionStatus) {
        return (Employee) employee;
    }


    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("hello");
//        modelAndView.addObject("msg", "Message From Hello Controller");
        return modelAndView;
    }

    @ModelAttribute
    public void addAttributes(Model model, HttpServletRequest request) {
        model.addAttribute("defaultMsg", "Message from method with @ModelAttribute annotation");
        Employee employee = new Employee();
        employee.setName("John");
        employee.setId(98);

        model.addAttribute("defaultEmp", employee);
    }
}
