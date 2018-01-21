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
public class BOption {

    @Id
    @GeneratedValue
    private int Id;
    private String Text;
    private int OptionOrder;
    @ManyToOne
    @Getter(onMethod = @__(@JsonIgnore))
    private MetaBField Owner;
}
