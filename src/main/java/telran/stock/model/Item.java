package telran.stock.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"itemId"})
@Entity
public class Item {
	@Id
	Long itemId;
	String itemName;
	Integer amount;
	String inventoryCode;
}
