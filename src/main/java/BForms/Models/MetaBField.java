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
public class MetaBField {

    @Id
    @GeneratedValue
    private int Id;
    private String Name;
    private String Description;
    private int FieldOrder;
    @OneToMany(mappedBy = "Parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BField> BFields;
    @OneToMany(mappedBy = "Owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BOption> BOptions;
    @ManyToOne
    private BFieldType Type;
    @ManyToOne
    @Getter(onMethod = @__(@JsonIgnore))
    private MetaBForm Owner;

    public void addBField(BField bField) {
        BFields.add(bField);
        bField.setParent(this);
    }

    public void removeBField(BField bField) {
        BFields.remove(bField);
        bField.setParent(null);
    }

    public void addBOption(BOption bOption) {
        BOptions.add(bOption);
        bOption.setOwner(this);
    }

    public void removeBOprion(BOption bOption) {
        BOptions.remove(bOption);
        bOption.setOwner(null);
    }
}
