package diligentia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.text.NumberFormat;
import java.util.Locale;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private int id;

    private Article article;

    @NotNull
    @Min(value=1)
    private Double price;

    private Unit unit = Unit.SZTUK;

    private static final NumberFormat NUMBER_FORMAT = NumberFormat.getNumberInstance(new Locale("pl","PL"));
}
