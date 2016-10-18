package diligentia.entity;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Invoice {

    @Id
    @GeneratedValue
    private int id;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cmsNewsEntity", cascade = CascadeType.ALL)
//    @MapKey(name = "userId")
//    @OneToMany(targetEntity = Item.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "id", insertable = false, updatable = false)
    @OneToMany(mappedBy="invoice")
    private List<Item> item;

    @NotNull
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="companyId")
    private Company company;

}
