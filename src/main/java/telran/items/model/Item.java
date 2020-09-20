package telran.items.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"num"})
@Entity
@Table(name = "items")
public class Item {
	@Id
	Integer num;
	String name;
	Integer amount;
	Integer inventoryCode;

}
