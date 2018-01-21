package BForms.Models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class BFieldType {

    @Id
    @GeneratedValue
    private int Id;
    private String Type;
}
