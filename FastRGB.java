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

import java.awt.image.DataBufferByte;

public class FastRGB
{

    private int width;
    private int height;
    private boolean hasAlphaChannel;
    private int pixelLength;
    private byte[] pixels;

    FastRGB(BufferedImage image)
    {

        pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        width = image.getWidth();
        height = image.getHeight();
        hasAlphaChannel = image.getAlphaRaster() != null;
        pixelLength = 3;
        if (hasAlphaChannel)
        {
            pixelLength = 4;
        }

    }

  /*  int getRGB(int x, int y)
    {
        int pos = (y * pixelLength * width) + (x * pixelLength);

        int argb = -16777216; // 255 alpha
        if (hasAlphaChannel)
        {
            argb = (((int) pixels[pos++] & 0xff) << 24); // alpha
        }

        argb += ((int) pixels[pos++] & 0xff); // blue
        argb += (((int) pixels[pos++] & 0xff) << 8); // green
        argb += (((int) pixels[pos++] & 0xff) << 16); // red
        return argb;
    }*/
    public ArrayList<Integer>pixel(int indigo, int vertigo, int hawk) {

    	ArrayList<Integer>pixelC = new ArrayList<Integer>();
    	int r = 16 + (int)(((65.738*indigo)/256) + ((129.057*vertigo)/256) + ((25.064*hawk)/256)); 
    	pixelC.add(r);
    	//pixelC.add(indigo);
    	//pixelC.add(vertigo);
    	//pixelC.add(hawk);
    	pixelC.add((int)(128-0.169*indigo-0.331*vertigo+0.500*hawk));
    	pixelC.add((int)(128+0.500*indigo-0.419*vertigo-0.081*hawk));
    	return pixelC;
    }
    public ArrayList<ArrayList>not(BufferedImage bi, int xt, int yt){
    	ArrayList<ArrayList>ant = new ArrayList<ArrayList>();
    	for(int j=xt; j<xt+8;j++){
    		for(int ib=yt;ib<yt+8;ib++){
    			Color cloud = new Color(bi.getRGB(ib,j));
    			int redd=cloud.getRed();
    			int greenn=cloud.getGreen();
    			int bluee=cloud.getBlue();
    			ant.add(pixel(redd,greenn,bluee));

    		}
    	}
    	return ant;


    }
    public ArrayList<ArrayList<ArrayList>>noble(BufferedImage c) {
    	int wi = c.getWidth();
    	int he = c.getHeight();
    	ArrayList<ArrayList<ArrayList>> man = new ArrayList<ArrayList<ArrayList>>();
    	int theta = wi/8;
    	int phi = he/8;
    	
    	for(int rowHop=0;rowHop<1080;rowHop+=8)
    	{
	    	for(int colHop=0;colHop<1920;colHop+=8)
	    	{
    			man.add(not(c,rowHop,colHop));
    		}
		}

    	return man;
    }

   public double[][]YMatrix(BufferedImage dd, int blackbird) {
    
    	int sr=blackbird;
    	ArrayList<ArrayList<ArrayList>>raptor=noble(dd);

    	int a = dd.getWidth();
    	int b = dd.getHeight();

    	int aa=a/8;
    	int bb=b/8;

    	int cc = aa*bb;
    	double[][] trouble = new double[8][8];
    	int counter =0;
    	for(int i=0;i<8;i++){
    		for(int j=0;j<8;j++){
    			int mav=(Integer) raptor.get(blackbird).get(counter).get(0);
    			trouble[i][j] = Double.valueOf(mav);
    			counter++;

    		}

    	}
    	return trouble;


    }
    public double[][]cBMatrix(BufferedImage dd, int blackbird) {
    
    	int sr=blackbird;
    	ArrayList<ArrayList<ArrayList>>raptor=noble(dd);

    	int a = dd.getWidth();
    	int b = dd.getHeight();

    	int aa=a/8;
    	int bb=b/8;

    	int cc = aa*bb;
    	double[][] trouble = new double[8][8];
    	int counter =0;
    	for(int i=0;i<8;i++){
    		for(int j=0;j<8;j++){
    			int mav=(Integer) raptor.get(blackbird).get(counter).get(1);
    			trouble[i][j] = Double.valueOf(mav);
    			counter++;

    		}

    	}
    	return trouble;


    }
    public double[][]cRMatrix(BufferedImage dd, int blackbird) {
    
    	int sr=blackbird;
    	ArrayList<ArrayList<ArrayList>>raptor=noble(dd);

    	int a = dd.getWidth();
    	int b = dd.getHeight();

    	int aa=a/8;
    	int bb=b/8;

    	int cc = aa*bb;
    	double[][] trouble = new double[8][8];
    	int counter =0;
    	for(int i=0;i<8;i++){
    		for(int j=0;j<8;j++){
    			int mav=(Integer) raptor.get(blackbird).get(counter).get(2);
    			trouble[i][j] = Double.valueOf(mav);
    			counter++;

    		}

    	}
    	return trouble;


    }


}