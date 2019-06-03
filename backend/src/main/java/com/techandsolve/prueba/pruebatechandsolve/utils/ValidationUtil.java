package com.techandsolve.prueba.pruebatechandsolve.utils;

import java.util.List;

import org.springframework.stereotype.Component;

import com.techandsolve.prueba.pruebatechandsolve.models.Line;

@Component
public class ValidationUtil {
	int MAX_WEIGHT = 100;
	int MIN_WEIGHT = 1;

	int MAX_DAYS = 500;
	int MIN_DAYS = 1;

	int MAX_ITEMS = 100;
	int MIN_ITEMS = 1;
	
	public String LIMIT_ITEMS_EXCEEDED="number items upper to 100 in case #";
	public String DIFERENT_LINES="number of lines different from the one indicated in case #";
	public String LIMIT_WEIGHT_EXCEEDED="Limit weight is exceeded in case #";
	public String LIMIT_DAYS_EXCEEDED="limit of days exceeded";
	

	private boolean validateWeight(int weight) {
		return weight <= MAX_WEIGHT && weight >= MIN_WEIGHT;
	}

	public boolean validateDays(int days) {
		return days <= MAX_DAYS && days >= MIN_DAYS;
	}

	private boolean validateItems(int items) {
		return items <= MAX_ITEMS && items >= MIN_ITEMS;
	}

	public String validateLines(List<Line> lines) {
		String err = "";
		for (Line line : lines) {
			if(!this.validateItems(line.getLinesIndicated())) {
				err = LIMIT_ITEMS_EXCEEDED+line.getDay();
				break;
			}
			
			if (line.getLinesIndicated()>line.getSublines().length||line.getLinesIndicated()<line.getSublines().length) {
				err = DIFERENT_LINES+line.getDay();
				break;
			}
			for (int item : line.getSublines()) {
				if (!this.validateWeight(item)) {
					err = LIMIT_WEIGHT_EXCEEDED+line.getDay();
					break;
				}
			}
		}
		return err;
	}

}
