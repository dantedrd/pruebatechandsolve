/**
 * 
 */
package com.techandsolve.prueba.pruebatechandsolve.utils;

import java.util.ArrayList;

/**
 * @author DANTEDRD
 *
 */
public class ArrayUtil {
	public static int[] convertToArray(ArrayList<Integer> sublines) {
		int[] lines=new int[sublines.size()];
	    for (int i = 0; i < sublines.size(); i++) {
	    	lines[i]=sublines.get(i);
	    }
	    return lines;
	} 
	public static int[] orderByBubbleSort(ArrayList<Integer> sublines) {
		int[] array=ArrayUtil.convertToArray(sublines);
	    int auxiliar;
	    for (int i = 0; i < array.length - 1; i++) {
	        for (int x = i + 1; x < array.length; x++) {
	            if (array[x] > array[i]) {
	                auxiliar = array[i];
	                array[i] = array[x];
	                array[x] = auxiliar;
	            }
	        }
	    }
	    return array;
	} 
}
