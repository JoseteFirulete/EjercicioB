package org.iesvdm.IVa;

import org.junit.Test;

import org.iesvdm.IVA.IVA;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;


public class IVATest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    public void testBaseImponibleValida() throws Exception {
        provideInput("100");
        double base = IVA.baseimponible();
        Assert.assertEquals(100.0, base, 0.01);
    }

    @Test(expected = Exception.class)
    public void testBaseImponibleNegativa() throws Exception {
        provideInput("-50");
        IVA.baseimponible();
    }

    @Test
    public void testTipoIVA_general() {
        provideInput("general");
        double iva = IVA.tipoIVA(100);
        Assert.assertEquals(21.0, iva, 0.01);
    }

    @Test
    public void testTipoIVA_reducido() {
        provideInput("reducido");
        double iva = IVA.tipoIVA(100);
        Assert.assertEquals(10.0, iva, 0.01);
    }

    @Test
    public void testTipoIVA_superreducido() {
        provideInput("superreducido");
        double iva = IVA.tipoIVA(100);
        Assert.assertEquals(4.0, iva, 0.01);
    }

    @Test
    public void testPrecioConIVA() throws Exception {
        double precioFinal = IVA.precioConIva(100, 21);
        Assert.assertEquals(121.0, precioFinal, 0.01);
    }

    @Test
    public void testCodigoPromocional_mitad() throws Exception {
        provideInput("mitad");
        double descuento = IVA.calcularDescuento(100);
        Assert.assertEquals(50.0, descuento, 0.01);
    }

    @Test
    public void testCodigoPromocional_nopro() throws Exception {
        provideInput("nopro");
        double descuento = IVA.calcularDescuento(100);
        Assert.assertEquals(0.0, descuento, 0.01);
    }

    @Test
    public void testCodigoPromocional_meno5() throws Exception {
        provideInput("meno5");
        double descuento = IVA.calcularDescuento(100);
        Assert.assertEquals(5.0, descuento, 0.01);
    }

    @Test
    public void testCodigoPromocional_5porc() throws Exception {
        provideInput("5porc");
        double descuento = IVA.calcularDescuento(100);
        Assert.assertEquals(5.0, descuento, 0.01);
    }

    @Test(expected = Exception.class)
    public void testCodigoPromocional_invalido() throws Exception {
        provideInput("descuento10");
        IVA.calcularDescuento(100);
    }
}


