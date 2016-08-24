package diligentia.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Invoice {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany(targetEntity = Item.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private List<Item> item;

    @NotNull
    @OneToOne(fetch=FetchType.LAZY)
    private Company company;

}
