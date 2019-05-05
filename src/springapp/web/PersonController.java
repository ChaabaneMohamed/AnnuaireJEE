package springapp.web;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springapp.business.IPersonManager;
import springapp.model.Group;
import springapp.model.Person;

@Controller()
@RequestMapping("/person")
public class PersonController {

    @Autowired
    IPersonManager manager;

    protected final Log logger = LogFactory.getLog(getClass());

    @ModelAttribute("groups")
    Collection<Group> groups() {
        logger.info("Making list of products");
        return manager.findAllGroups();
    }
    
    @ModelAttribute
    public Person newPerson(
            @RequestParam(value = "id", required = false) Integer productNumber) {
        if (productNumber != null) {
            logger.info("find product " + productNumber);
            return manager.findPerson(productNumber);
        }
        Person p = new Person();
        p.setId(0);
        p.setFirstName("");
        p.setLastName("");
        p.setMail("");
        p.setBirthDay(null);
        p.setPassword("");
        logger.info("new product = " + p);
        return p;
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listGroups() {
        logger.info("List of groups");
        return "groupsList";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editGroup(@ModelAttribute Group g) {
        return "groupForm";
    }

}