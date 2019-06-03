package com.techandsolve.prueba.pruebatechandsolve.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.techandsolve.prueba.pruebatechandsolve.models.Line;
import com.techandsolve.prueba.pruebatechandsolve.models.Travel;

@Component
public class CalculateTravelsUtil {
	int totalTravels=0;
	
	public ArrayList<Travel> getTravels(List<Line> lines){
	   ArrayList<Travel> travels=new ArrayList<Travel>();
	   for(Line line : lines) {
		   int [] sublines=line.getSublines();
		   int totalTravelsInSubLines=this.calculateTravels(sublines,sublines.length);
		   travels.add(new Travel(line.getDay(),totalTravelsInSubLines));
		   totalTravels=0;
	   }
	   return travels;
	}
	
	
	private int calculateTravels(int[] array, int totalElements) {
		int	elementsInBag=0;
		for(int i=0; i<=array.length-1; i++){
			if(array[i]>=50){
				totalTravels++;
				totalElements--;
			}else{
				if(elementsInBag<=totalElements){
					elementsInBag=calculateElementsInBag(array[i], totalElements);
					totalElements=totalElements-elementsInBag;
				}else{
					break;
				}
		   }
		}
		return totalTravels;
	}
	
	private int calculateElementsInBag(int weight, int totalElements){
		int elements=2;
		while(elements<=totalElements){
			if((weight*elements)>=50){
				totalTravels++;
				break;
			}
			elements++;
		}
		return elements;
	}
}
