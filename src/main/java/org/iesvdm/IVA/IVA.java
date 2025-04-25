package org.iesvdm.IVA;

import java.util.Scanner;

/*
 * Escribe un programa que calcule el precio final de un producto según su  base imponible (precio antes de impuestos), 
 * el tipo de IVA aplicado (general, reducido o superreducido) y el código promocional. Los tipos de IVA general,  
 * reducido y superreducido son del 21%, 10% y 4% respectivamente. Los códigos promocionales pueden ser nopro, mitad, 
 * meno5 o 5porc que significan respectivamente que no se aplica promoción, el precio se reduce a la mitad,    
 * se descuentan 5 euros o se descuenta el 5%. El ejercicio se da por bueno si se muestran los valores correctos, 
 * aunque los números no estén tabulados.

     Ejemplo:
     Introduzca la base imponible: 25
     Introduzca el tipo de IVA (general, reducido o superreducido): reducido
     Introduzca el código promocional (nopro, mitad, meno5 o 5porc): mitad
     Base imponible        25.00
     IVA (10%)              2.50
     Precio con IVA        27.50
     Cód. promo. (mitad): -13.75
     TOTAL                 13.75

 * */

public class IVA {

	public static double baseimponible() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduzca la base imponible: ");
		Double baseImponible = scanner.nextDouble();
		
		return baseImponible;
	}
	
	public static double tipoIVA () {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("¿Que tipo de IVA eliges? (general, reducido o superreducido): ");
		String tipoIVA = scanner.nextLine();
		
		double porcentajeIVA = 0.0; 
		
		if (tipoIVA == "general") {
			porcentajeIVA = 2.10;
		} else if (tipoIVA == "reducido") {
			porcentajeIVA = 1.00;
		} else if (tipoIVA == "general") {
			porcentajeIVA = 0.40;
		}
		
		return 0;
	}
	
}
