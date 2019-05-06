package springapp.web;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
    
    @Autowired
    PersonValidator validator;

    protected final Log logger = LogFactory.getLog(getClass());

    @ModelAttribute("groups")
    Collection<Group> groups() {
        logger.info("Making list of groups");
        return manager.findAllGroups();
    }
    
    @ModelAttribute("persons")
    Collection<Person> persons() {
        logger.info("Making list of persons");
        return manager.findAllPersons();
    }
    
    @ModelAttribute
    public Person newPerson(
            @RequestParam(value = "id", required = false) Integer personNumber) {
        if (personNumber != null) {
            logger.info("find person " + personNumber);
            return manager.findPerson(personNumber);
        }
        Person p = new Person();
        p.setId(0);
        p.setFirstName("");
        p.setLastName("");
        p.setMail("");
        p.setBirthDay(null);
        p.setPassword("");
        p.setGroupId(0);
        logger.info("new person = " + p);
        return p;
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listGroups() {
        logger.info("List of groups");
        return "groupsList";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPerson(@ModelAttribute Group g) {
        return "personForm";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute @Valid Person p, BindingResult result) {
    	validator.validate(p, result);
        if (result.hasErrors()) {
            return "personForm";
        }
        manager.savePerson(p);
        return "redirect:list";
    }
    
    @ModelAttribute("groupTypes")
    public Map<Integer, String> groupTypes() {
        Map<Integer, String> types = new LinkedHashMap<>();
        types.put(1, "ILD");
        types.put(2, "FSI");
        types.put(3, "GIG");
        types.put(4, "IAAA");
        return types;
    }
    
}