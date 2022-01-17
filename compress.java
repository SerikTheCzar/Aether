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
import java.util.PriorityQueue;
import java.util.HashMap;
import javax.swing.ImageIcon;
import java.awt.*;
import java.io.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
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
		File imagefile = new File("a.png");
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
		System.out.println(close.size());
		//below: initial Y Cb Cr matrices
		//for(int hopper=0;hopper<32400;hopper++){

		double[][]ym=a.YMatrix(iag,100);
		/*for(int iii=0;iii<8;iii++) {
			for(int bbb=0;bbb<8;bbb++) {
			System.out.print(ym[iii][bbb] + " ");
			}
		}*/
		double[][]cbm=a.cBMatrix(iag,0);
		double[][]crm=a.cRMatrix(iag,0);
		//below: Y Cb Cr to dct Tables
		dctengine dct = new dctengine(ym);
		double[][]dcttabler = dct.dcttable(ym);
		dctengine dct1 = new dctengine(cbm);
		double[][]dct1table = dct1.dcttable(cbm);
		dctengine dct2 = new dctengine(crm);
		double[][]dct2table = dct2.dcttable(crm);
		//below: quantization tables of Y Cb Cr
		quantizer qt = new quantizer(dcttabler);
		double[][]qlt = qt.quantizedL(dcttabler);
		quantizer qt1 = new quantizer(dct1table);
		double[][]qcbt = qt1.quantizeC(dct1table);
		quantizer qt2 = new quantizer(dct2table);
		double[][]qcrt = qt2.quantizeC(dct2table);
		zigzag zz = new zigzag(qlt);
		int[]zag = zz.array(qlt);
		int[] ziggity = new int[]{11, 12, 14, 12, 10, 16, 14, 13, 14, 18, 17, 16, 
                        19, 24, 40, 26, 24, 22, 22, 24, 49, 35, 37, 29, 40, 58, 51, 61, 
                        60, 57, 51, 56, 55, 64, 72, 92, 78, 64, 68, 87, 69, 55, 56, 80, 
                        109, 81, 87, 95, 98, 103, 104, 103, 62, 77, 113, 121, 112, 100, 
                        120, 92, 101, 103, 99};
        HuffmanEncoder test = new HuffmanEncoder(ziggity);
        HashMap<Integer, Integer> output = test.frequency(ziggity);
		//for loop for testing output
		/*for(int v=0;v<ym.length;v++){
			for(int q=0;q<ym[v].length;q++){
				System.out.println(qcrt[v][q] + " ");
			}
			System.out.println();
		}*/
		//for(int zl=0;zl<zag.length;zl++) {
		//	System.out.print(zag[zl] + " ");	
		//}
		
		
	}





}
