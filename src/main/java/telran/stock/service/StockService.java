package telran.stock.service;

import telran.stock.dto.ItemDto;

public interface StockService {
	boolean addItem(ItemDto itemDto);
	ItemDto findItem(Long itemId);
	boolean deleteItem(Long itemId);
	ItemDto depositItem(Long itemId, Integer amount);
	ItemDto withdrawalItem(Long itemId, Integer amount);
}
