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

	public static void main() throws Exception {
		
		double baseImponible = baseimponible();
		double ivaFinal = tipoIVA(baseImponible);
		double precioFinal = precioConIva(baseImponible, ivaFinal);
		double codigoPromocional = calcularDescuento(precioFinal);
		
		double descuento = calcularDescuento(precioFinal);
		double total = precioFinal - descuento;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Base imponible: " + baseImponible);
		System.out.println("IVA aplicado: " + ivaFinal);
		System.out.println("Precio con IVA: " + precioFinal);
		System.out.println("Código promocional (" + codigoPromocional + "): -" + descuento);
		System.out.println("TOTAL: " + total);

	}

	public static double baseimponible() throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduzca la base imponible: ");
		Double baseImponible = scanner.nextDouble();
		
		if (baseImponible < 0) {
			throw new Exception("Esta base Imponible esta mal no puede ser negativo");
		} 
		
		return baseImponible;
	}
	
	public static double tipoIVA (double baseImponible) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("¿Que tipo de IVA eliges? (general, reducido o superreducido): ");
		String tipoIva = scanner.nextLine();
		
		double porcentajeIVA = 0.0; 
		
		if (tipoIva == "general") {
			porcentajeIVA = 2.10;
		} else if (tipoIva == "reducido") {
			porcentajeIVA = 1.00;
		} else if (tipoIva == "general") {
			porcentajeIVA = 0.40;
		} else {
			System.out.println("Ninguno de estos tipo de IVA es valido");
		}
		
		double ivaFinal = (baseImponible*porcentajeIVA);
		
		return ivaFinal;
	}
	
	public static double precioConIva(double baseImponible, double ivaFinal) throws Exception {
		
		double precioFinal = (baseImponible * ivaFinal);
		
		return precioFinal;
	}
	
	public static double calcularDescuento(double precioFinal) throws Exception {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduzca el código promocional (nopro, mitad, meno5 o 5porc): ");
		String codigoPromocional = scanner.nextLine();
		
		double descuento = 0.0;

		if (codigoPromocional == "nopro") {
			descuento = 0.0;
		} else if (codigoPromocional == "mitad") {
			descuento = precioFinal / 2.0;
		} else if (codigoPromocional == "meno5") {
			descuento = 5.0;
		} else if (codigoPromocional == "5porc") {
			descuento = precioFinal * 0.05;
		} else {
			throw new Exception ("Codigo promocional no valido");
		}

		return descuento;
	}
}
