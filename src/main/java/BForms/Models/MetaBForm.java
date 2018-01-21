package BForms.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class MetaBForm {

    @Id
    @GeneratedValue
    private int Id;
    private String Title;
    private String UrlAddress;
    @OneToMany(mappedBy = "Owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MetaBField> MetaBFields;
    @OneToMany(mappedBy = "Parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BForm> BForms;
    @ManyToOne
    @Getter(onMethod = @__(@JsonIgnore))
    private User Creator;

    public void addMetaBField(MetaBField metaBField){
        MetaBFields.add(metaBField);
        metaBField.setOwner(this);
    }

    public void removeMetaBField(MetaBField metaBField){
        MetaBFields.remove(metaBField);
        metaBField.setOwner(null);
    }

    public void addBForm(BForm bForm){
        BForms.add(bForm);
        bForm.setParent(this);
    }

    public void removeBFForm(BForm bForm){
        BForms.remove(bForm);
        bForm.setParent(null);
    }


}
