package diligentia.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.text.NumberFormat;
import java.util.Locale;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private int id;

    private Entry entry;

    @NotNull
    @Min(value=1)
    private Double price;

    private Unit unit = Unit.SZTUK;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoiceId")
    private Invoice invoice;

    private static final NumberFormat NUMBER_FORMAT = NumberFormat.getNumberInstance(new Locale("pl","PL"));
}
