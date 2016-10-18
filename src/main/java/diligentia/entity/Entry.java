package diligentia.entity;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.Version;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import diligentia.model.Unit;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Entry extends AbstractPersistable<Integer> {
	
	@NotNull @Size(min=5, max=200)
	private String name;
	
	private String description;
	
	@NotNull @Min(value=1)
	private Integer amount;//TODO-rwichrowski przenieść do faktury

	@NotNull @Min(value=1)
	private Double price;

	@Version
	private Integer version;

	private Unit unit = Unit.SZTUK;
	
	private static final NumberFormat NUMBER_FORMAT = NumberFormat.getNumberInstance(new Locale("pl","PL"));
	
	public Entry(){
	}
	
	public Entry(Integer id, String name, String description, Integer amount, Double price, Integer version) {
		setId(id);
		this.name = name;
		this.description = description;
		this.amount = amount;
		this.price = price;
		this.version = version;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getAmount() {
		return amount;
	}
	
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public Double getPrice() {
		if (price == null) {
			return Double.valueOf(0);
		}
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getVersion() {
		return version;
	}

	public String getPriceFormatted() {
		return convertPriceToString(this.price);
	}

	public static String convertPriceToString(double price) {
		return NUMBER_FORMAT.format(price);
	}

	public static double formatStringToPreco(String strPreco) throws ParseException {
		 return NUMBER_FORMAT.parse(strPreco).doubleValue();
	}
	
}
