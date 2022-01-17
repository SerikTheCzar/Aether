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

//Either machine learning options
//optimize quantize table
//or add in fake data to important parts of image so that compression knows not to touchie NO TOUCH
public class quantizer{
	private double[][] no;
	public quantizer(double[][]fall) {
		no=fall;
	}
	public double[][]quantizedL(double[][] die){
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
		double[][]lumen = die;
		double[][]output = new double[8][8];
		//System.out.println("This is quantized L: ");
		for(int i=0;i<8;i++){
			for(int j=0; j<8;j++){
				output[i][j]=java.lang.Math.round((lumen[i][j]/quantizeTable[i][j]));
				
			}
		} 

		return output;
	}
	public double[][] dequantization(double[][]input) {
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
		double[][]lumen = input;
		double[][]output = new double[8][8];
		//System.out.println("This is quantized L: ");
		for(int i=0;i<8;i++){
			for(int j=0; j<8;j++){
				output[i][j]=java.lang.Math.round((lumen[i][j]*quantizeTable[i][j]));
				
			}
		} 

		return output;
	}
	public double[][]quantizeC(double[][]shoot) {
		double[][]quantizeChroma= {
			{17,18,24,47,99,99,99,99},
			{18,21,26,66,99,99,99,99},
			{24,26,56,99,99,99,99,99},
			{47,66,99,99,99,99,99,99},
			{99,99,99,99,99,99,99,99},
			{99,99,99,99,99,99,99,99},
			{99,99,99,99,99,99,99,99},
			{99,99,99,99,99,99,99,99}
		};
		double[][]chroma=shoot;
		double[][]op=new double[8][8];
		
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				op[i][j]=java.lang.Math.round(chroma[i][j]/quantizeChroma[i][j]);
	
		//		System.out.println(op[i][j] +" ");
			}
		}
		return op;
	}
	public double[][]dequantizedChroma(double[][]input){
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
		double[][]lumen = input;
		double[][]output = new double[8][8];
		//System.out.println("This is quantized L: ");
		for(int i=0;i<8;i++){
			for(int j=0; j<8;j++){
				output[i][j]=java.lang.Math.round((lumen[i][j]*quantizeTable[i][j]));
				
			}
		} 

		return output;
	}

}