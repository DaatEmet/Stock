package telran.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import telran.stock.dto.ItemDto;
import telran.stock.service.StockService;

@RestController
@RequestMapping("/item")
public class ItemController  {
	
	@Autowired
	StockService service;
	
	@PostMapping("/")
	public boolean addItem(@RequestBody ItemDto itemDto) {
		return service.addItem(itemDto);
	}
	
	@GetMapping("/{itemId}")
	public ItemDto findItem(@PathVariable Long itemId) {
		return service.findItem(itemId);
	}
	
	@DeleteMapping("/{itemId}")
	public boolean deleteItem(@PathVariable Long itemId) {
		return service.deleteItem(itemId);
	}
	
	@PutMapping("/add")
	public ItemDto depositItem(@RequestParam Long itemId,@RequestParam Integer amount) {
		return service.depositItem(itemId, amount);
	}
	
	@PutMapping("/delete")
	public ItemDto withdrawalItem(@RequestParam Long itemId,@RequestParam Integer amount) {
		return service.withdrawalItem(itemId, amount);
	}

}
