package BForms.Models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue
    private int Id;
    private String Nickname;
    private String Email;
    private String PasswordHash;
    @OneToMany(mappedBy = "Creator", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<MetaBForm> MetaBForms;
    @OneToMany(mappedBy = "Filler", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BForm> BForms;

    public void addMetaBForm(MetaBForm metaBForm){
        MetaBForms.add(metaBForm);
        metaBForm.setCreator(this);
    }

    public void removeMetaBForm(MetaBForm metaBForm){
        MetaBForms.remove(metaBForm);
        metaBForm.setCreator(null);
    }

    public void addBForm(BForm bForm){
        BForms.add(bForm);
        bForm.setFiller(this);
    }

    public void removeBForm(BForm bForm){
        BForms.remove(bForm);
        bForm.setFiller(null);
    }

}
