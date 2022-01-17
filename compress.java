import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.io.File;
import java.awt.Component;
import static java.lang.System.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import java.awt.*;
import java.io.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
public class compress extends JFrame
{
	public static void main(String args[]) throws IOException
	{
		File imagefile = new File("3936137.jpg");
		BufferedImage iag = ImageIO.read(imagefile);
		int w = iag.getWidth();
		int h = iag.getHeight();

//		System.out.println(w);

		FastRGB a = new FastRGB(iag);
		//int test;
		//test=a.getRGB(3,9);
		//System.out.println(test);
		ArrayList<ArrayList<ArrayList>>close;
		close=a.noble(iag);
		//number of grids (8x8)
		//System.out.println(close.size());
		//below: initial Y Cb Cr matrices
		//for(int hopper=0;hopper<32400;hopper++){

		double[][]ym=a.YMatrix(iag,3);
		//System.out.println(ym[0].length);
		System.out.println("Y Color Space Values:");
		for (double[] row1 : ym) {
 
            // converting each row as string
            // and then printing in a separate line

            System.out.println(Arrays.toString(row1));
        }
		double[][]cbm=a.YMatrix(iag,0);
		double[][]crm=a.YMatrix(iag,0);
		//below: Y Cb Cr to dct Tables
		System.out.println("\nDCT Values:");
		dctengine dct = new dctengine(ym);
		double[][]dcttabler = dct.dcttable(ym);
		int[][]foutputdct = dct.DiscreteOutput(dcttabler);
		for (int[] row : foutputdct)
 
            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    	
 
		dctengine dct1 = new dctengine(cbm);
		double[][]dct1table = dct1.dcttable(cbm);

		dctengine dct2 = new dctengine(crm);
		double[][]dct2table = dct2.dcttable(crm);
		//DONE DCT
		//below: quantization tables of Y Cb Cr
		System.out.println("\nQuantized Values:");
		quantizer qt = new quantizer(dcttabler);
		double[][]qlt = qt.quantizedL(dcttabler);
		double[][]dequantized = qt.dequantization(qlt);
		quantizer qt1 = new quantizer(dct1table);
		double[][]qcbt = qt1.quantizeC(dct1table);

		quantizer qt2 = new quantizer(dct2table);
		double[][]qcrt = qt2.quantizeC(dct2table);
		for (double[] row : dequantized)
 
            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    	
 
	/*	for(int aaa=0;aaa<7;aaa++) {
			for(int b = 0; b<7; b++){
				System.out.println(qcrt[aaa][b] + " ");
			}
		} */
		double[][] quantizeTable = {
			{16, 11, 10, 16, 24, 40, 51, 61},
			{12, 12, 14, 19, 26, 58, 60, 55},
			{14, 13, 16, 24, 40, 57, 69, 56},
			{14, 17, 22, 29, 51, 87, 80, 62},
			{18, 22, 37, 56, 68, 109, 103, 77},
			{24, 35, 55, 64, 81, 104, 113, 92},
			{49, 64, 78, 87, 103, 121, 120, 101},
			{72, 92, 95, 98, 112, 100, 103, 99}
		};
		zigzag zz = new zigzag(quantizeTable);
		zigzag zz2 = new zigzag(qcbt);
		zigzag zz3 = new zigzag(qcrt);
		int[]zag = zz.array(quantizeTable);
		System.out.println("\nZig Zag Encoding: ");
		
		int[]zag1 = zz.array(qcbt);
		int[]zag2 = zz.array(qcrt);
		//for loop for testing output
		/*for(int v=0;v<ym.length;v++){
			for(int q=0;q<ym[v].length;q++){
				System.out.println(qcrt[v][q] + " ");
			}
			System.out.println();
		} */
		for(int zl=0;zl<zag.length;zl++) {
			System.out.print(zag[zl] + " ");	
		//	System.out.print(zag1[zl] + " ");	
		//	System.out.print(zag2[zl] + " ");	
		}
		
		
	}





}
