package BForms.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class BField {

    @Id
    @GeneratedValue
    private int Id;
    private String Text;
    @ManyToOne
    private BOption SelectedOption;
    @ManyToOne
    @Getter(onMethod = @__(@JsonIgnore))
    private BForm Owner;
    @ManyToOne
    @Getter(onMethod = @__(@JsonIgnore))
    private MetaBField Parent;

}
