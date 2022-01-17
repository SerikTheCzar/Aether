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

public class dctengine {
	private double[][] jump;

	public dctengine(double[][] falling) {

		jump=falling;
	}

	
	public double[][]dcttable(double[][] xyz) {
		double[][]input = xyz;
		double[][]output = new double[8][8];
		double pi=3.1415926535897;
		double sum;
		double Cu;
		double Cv;
		int x, y, u, v;
		for(u=0;u<8;u++){
			for(v=0;v<8;v++){
				sum=0.0;
				for(x=0;x<8;x++){
					for(y=0;y<8;y++){
						sum=sum+input[x][y]*Math.cos(((2.0*x+1)*u*pi)/16.0)*Math.cos(((2.0*y+1.0)*v*pi)/16.0);
					}
					if(u==0){
						Cu=1/Math.sqrt(2);
					} else {
						Cu=1.0;
					}
					if(v==0){
						Cv=1/Math.sqrt(2);
					} else {
						Cv=1.0;
					}
					output[u][v]=1/4.0*Cu*Cv*sum;

				}
			}
		}
		return output;
		
	}
	public int[][]DiscreteOutput(double[][] dct) {
		double[][] changetoInt = dct;
		int[][] output = new int[8][8];

		for(int i=0;i<8;i++) {
			for(int a=0;a<8;a++) {
				Double newData = new Double(changetoInt[i][a]);
				output[i][a] = newData.intValue();
			}
		}
		return output;
	}

}
