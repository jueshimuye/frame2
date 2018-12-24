package com.dc.dcrud.web.controller;

import com.dc.dcrud.pojo.Menu;
import com.dc.dcrud.service.rbac.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>Descriptions...
 *
 * @author DC
 * @date 2018/4/10.
 */
@Controller
public class IndexController {
    @Autowired
    private ResourceService resourceService;
    
    @RequestMapping({"/", "/index"})
    public Object index() {
        return "index";
    }
    
    @RequestMapping("/decorator")
    public Object decorator(){
        List<Menu> menus = resourceService.loadUserMenu();
        return new ModelAndView("common/decorator").addObject("menus", menus);
    }
    
}
