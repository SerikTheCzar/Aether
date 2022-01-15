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

public class zigzag {
	private double [][] zig;

	public zigzag(double[][] zag) {
		zig=zag;
	}
	public int[]array(double[][]oneD){
		if(oneD == null || oneD.length == 0) {
			return null;
		}
		int m = oneD.length;
		int n = oneD[0].length;
		int[] result = new int [m*n];
		int t = 0;

		for(int i=0;i<n+m-1; i++){
			if(i%2==1){
				int x = i < n ? 0 : i - n + 1;
				int y = i < n ? i : n - 1;
				while(x<m&&y>=0){
					result[t++] = (int)oneD[x++][y--];
				}
			} else {
				int x = i < m ? i : m - 1;
				int y = i < m ? 0 : i - m + 1;
				while(x >= 0 && y < n){
					result[t++] = (int)oneD[x--][y++];
				}
			}
		}
		return result;


	}


}
