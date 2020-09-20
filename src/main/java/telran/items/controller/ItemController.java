package telran.items.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telran.items.dto.ItemDto;
import telran.items.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@PostMapping("/item")
	public boolean addItem(@RequestBody ItemDto newItem) {
		return itemService.addItem(newItem);
	}
	
	@DeleteMapping("/item/{num}")
	public ItemDto deleteItem(@PathVariable Integer num) {
		return itemService.deleteItem(num);
	}
	
	@GetMapping("/items")
	public List<ItemDto> allItem(){
		return itemService.allItem();
	}
	
	@GetMapping("/item/{num}")
	public ItemDto findByItemNum(@PathVariable Integer num) {
		return itemService.findByItemNum(num);
	}
	
	@PostMapping("/item/{num}/quantity/{quantity}")
	public ItemDto withdrawalQuantity(Integer num, Integer quantity) {
		return itemService.changeQuantity(num, quantity, true);
	}
	
	@PutMapping("/item/{num}/quantity/{quantity}")
	public ItemDto depositQuantity(Integer num, Integer quantity) {
		return itemService.changeQuantity(num, quantity, false);
	}
	
}
