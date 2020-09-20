package telran.items.service;

import java.util.List;

import telran.items.dto.ItemDto;

public interface ItemService {
	
	List<ItemDto> allItem();
	
	ItemDto findByItemNum(Integer num);
	
	ItemDto changeQuantity(Integer num, Integer quantity, boolean operation);
	
	boolean addItem(ItemDto newItem);
	
	ItemDto deleteItem(Integer num);
}
