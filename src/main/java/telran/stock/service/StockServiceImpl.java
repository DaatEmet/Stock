package telran.stock.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import telran.stock.dao.StockRepository;
import telran.stock.dto.ItemDto;
import telran.stock.exceptions.AmountException;
import telran.stock.exceptions.ItemNotFoundException;
import telran.stock.model.Item;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepository repository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public boolean addItem(ItemDto itemDto) {
		if (repository.existsById(itemDto.getItemId())) {
			return false;
		}
		Item item = modelMapper.map(itemDto, Item.class);
		repository.save(item);
		return true;
	}

	@Override
	public ItemDto findItem(Long itemId) {
		Item item = repository.findById(itemId).orElseThrow(()-> new ItemNotFoundException());
		return modelMapper.map(item, ItemDto.class);
	}
	
	@Transactional
	@Override
	public boolean deleteItem(Long itemId) {
		Item item = repository.findById(itemId).orElseThrow(()-> new ItemNotFoundException());
		repository.delete(item);
		return true;
	}
	
	@Transactional(readOnly = true)
	@Override
	public ItemDto depositItem(Long itemId, Integer amount) {
		Item item = repository.findById(itemId).orElseThrow(()-> new ItemNotFoundException());
		item.setAmount(item.getAmount() + amount);
		repository.save(item);
		return modelMapper.map(item, ItemDto.class);
	}
	
	@Transactional(readOnly = true)
	@Override
	public ItemDto withdrawalItem(Long itemId, Integer amount) {
		Item item = repository.findById(itemId).orElseThrow(()-> new ItemNotFoundException());
		item.setAmount(item.getAmount() - amount);
		if(item.getAmount() < 0) throw new AmountException();
		repository.save(item);
		return modelMapper.map(item, ItemDto.class);
	}

}
