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
public class BForm {

    @Id
    @GeneratedValue
    private int Id;
    @OneToMany(mappedBy = "Owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BField> BFields;
    @ManyToOne
    @Getter(onMethod = @__(@JsonIgnore))
    private User Filler;
    @ManyToOne
    @Getter(onMethod = @__(@JsonIgnore))
    private MetaBForm Parent;

    public void addBField(BField bField){
        BFields.add(bField);
        bField.setOwner(this);
    }

    public void removeField(BField bField){
        BFields.remove(bField);
        bField.setOwner(null);
    }

}