package diligentia.model;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name="article")
public class Article extends AbstractPersistable<Integer> {
	
	@NotNull @Size(min=5, max=200)
	private String name;
	
	private String description;
	
	@NotNull @Min(value=1)
	private Integer amount;//TODO-rwichrowski przenieść do faktury

	@NotNull @Min(value=1)
	private Double price;

	private Unit unit = Unit.SZTUK;
	
	private static final NumberFormat NUMBER_FORMAT = NumberFormat.getNumberInstance(new Locale("pl","PL"));
	
	public Article(){
	}
	
	public Article(Integer id, String name, String description, Integer amount, Double price, Integer version) {
		setId(id);
		this.name = name;
		this.description = description;
		this.amount = amount;
		this.price = price;
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
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getPrecoFormatado() {
		return convertPrecoToString(this.price);
	}
	
	public static String convertPrecoToString(double preco) {
		return NUMBER_FORMAT.format(preco);
	}
	
	public static double formatStringToPreco(String strPreco) throws ParseException {
		 return NUMBER_FORMAT.parse(strPreco).doubleValue();
	}
	
}
