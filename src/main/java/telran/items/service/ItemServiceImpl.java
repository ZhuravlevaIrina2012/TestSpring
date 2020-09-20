package telran.items.service;

import java.util.List;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import telran.items.dto.ItemDto;
import telran.items.exception.ForbiddenException;
import telran.items.exception.ItemNotFoundException;
import telran.items.model.Item;
import telran.items.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<ItemDto> allItem() {
		return itemRepository.findAll().stream()
					.map(i -> modelMapper.map(i, ItemDto.class))
					.collect(Collectors.toList());
	}

	@Override
	public ItemDto findByItemNum(Integer num) {
		Item item = itemRepository.findById(num).orElseThrow(() -> new ItemNotFoundException(num));
		return modelMapper.map(item, ItemDto.class);
	}

	@Override
	@Transactional
	public ItemDto changeQuantity(Integer num, Integer quantity, boolean operation) {
		Item item = itemRepository.findById(num).orElseThrow(() -> new ItemNotFoundException(num));
		if (operation) {
			item.setAmount(item.getAmount() + quantity);
		}else {
			Integer amount = item.getAmount();
			if (amount > quantity) {
				item.setAmount(amount - quantity);
			}else {
				throw new ForbiddenException();
			}
		}
		return modelMapper.map(item, ItemDto.class);
	}

	@Override
	@Transactional
	public boolean addItem(ItemDto newItem) {
		if (itemRepository.existsById(newItem.getNum())) {
			return false;
		}
		Item item = modelMapper.map(newItem, Item.class);
		itemRepository.save(item);
		return true;
	}

	@Override
	@Transactional
	public ItemDto deleteItem(Integer num) {
		Item item = itemRepository.findById(num).orElseThrow(() -> new ItemNotFoundException(num));
		itemRepository.delete(item);
		return modelMapper.map(item, ItemDto.class);
	}

}
