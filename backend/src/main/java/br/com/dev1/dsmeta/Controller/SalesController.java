package br.com.dev1.dsmeta.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev1.dsmeta.Services.SaleService;
import br.com.dev1.dsmeta.entity.Sale;

@RestController
@RequestMapping(value="/sales")
public class SalesController {

	@Autowired
	private SaleService ss;
	
	@GetMapping
	public Page<Sale> findSales(
			@RequestParam(value="minDate", defaultValue = "") String minDate,
			@RequestParam(value="maxDate", defaultValue = "") String maxDate,
			Pageable pageable){
		return ss.findSales(minDate, maxDate, pageable);
	}
}
