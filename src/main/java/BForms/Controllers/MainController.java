package BForms.Controllers;

import BForms.Models.BOption;
import BForms.Models.MetaBField;
import BForms.Models.MetaBForm;
import BForms.Models.User;
import BForms.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
public class MainController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/createUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(){
        BOption option1 = BOption.builder().Text("Yes").OptionOrder(0).build();
        BOption option2 = BOption.builder().Text("No").OptionOrder(1).build();
        BOption option3 = BOption.builder().Text("Yes").OptionOrder(0).build();
        BOption option4 = BOption.builder().Text("No").OptionOrder(1).build();
        MetaBField metaBField1 = MetaBField.builder().Name("School").Description("Do you like school?").FieldOrder(0).BOptions(new ArrayList<>()).build();
        MetaBField metaBField2 = MetaBField.builder().Name("Christmas").Description("Do you like christmas?").FieldOrder(1).BOptions(new ArrayList<>()).build();
        MetaBForm metaBForm = MetaBForm.builder().Title("Ankieta").UrlAddress("www.bforms.pl/1").MetaBFields(new ArrayList<>()).build();
        User user = User.builder().Nickname("Someone").Email("some@one.com").PasswordHash("8a67stdf8a76sd").MetaBForms(new ArrayList<>()).build();

        metaBField1.addBOption(option1);
        metaBField1.addBOption(option2);
        metaBField2.addBOption(option3);
        metaBField2.addBOption(option4);
        metaBForm.addMetaBField(metaBField1);
        metaBForm.addMetaBField(metaBField2);
        user.addMetaBForm(metaBForm);

        return userRepository.save(user);
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteUser(@RequestParam int Id){
        userRepository.delete(userRepository.findOne(Id));
    }

}
