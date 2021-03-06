package Photo_shop;
//an image
//filler code by Mr. David

import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class Photo_shop extends Component {

	// the name of the output file. will be determined by which methods are called
 private String outputName;
 
 // the 2d array of colors representing the image
 private Color[][] pixels;
 
 // the width and height of the image 
 private int w,h;
 

 // this method increases each color's rgb value by a given amount.
 // don't forget that rgb values are limited to the range [0,255]
 public void brighten(int amount) {
     outputName = "brightened_" + outputName;
     
     // for loop that runs through the program
     for (int i = 0; i < pixels.length; i++) {
     	for(int j = 0; j < pixels[i].length; j++) {
     		
     		Color c = pixels[i][j];
     		// getting the rgb values and adding them to amount to brighten the image
     		int r = c.getRed() + amount;
     		int g = c.getGreen() + amount;
     		int b = c.getBlue() + amount;
     		
     		// setting boundaries so value would not excess 255
     		if(r > 255) {
        		r = 255;
        	}
        	if(g > 255) {
        		g = 255;
        	}
        	if(b > 255) {
        		b = 255;
        	}
        	if(amount < 0) {
        		if(r < 0) {
        			r = 0;
        		}
        		if(g < 0) {
        			g = 0;
        		}
        		if(b < 0) {
        			b = 0;
        		}
        	}
     		
     		// setting new rgb value
     		pixels[i][j] = new Color(r, g,  b);
     	}
     }
     
     // your code here
 }
 
 // flip an image either horizontally or vertically.
 public void flip(boolean horizontally) {
     outputName = (horizontally?"h":"v") + "_flipped_" + outputName;
     
     // horizontally
		if (horizontally == true) {
			for (int i = 0; i < pixels.length; i++) {
				// making another reverse variable for horizontal
	        	for(int j = 0, k = pixels[i].length-1; j < pixels[i].length/2; j++, k--) {
	        	// setting a temp for swap 
	        		Color temp = pixels[i][j];
	        		
	        		// swapping to make horizontal flip
	        		pixels[i][j] = pixels[i][k];
	        		pixels[i][k] = temp;
	        		
	        		
	        	}
			}
     }
     // vertically
     
     else {
     	
     	// setting a reverse variable for vertical
     	for (int i = 0,  k = pixels.length-1; i < pixels.length/2; i++, k--) {
	        	for(int j = 0; j < pixels[i].length; j++) {
	        		
	        		// setting a temp for swap
	        		Color temp = pixels[i][j];
	        		
	        		// swapping to make vertical flip
	        		pixels[i][j] = pixels[k][j];
	        		pixels[k][j] = temp;
	        		
	        		
	        	}
			}
     	
     	
     }
     	
     
 }
 
 // negates an image
 // to do this: subtract each pixel's rgb value from 255 
 // and use this as the new value
 public void negate() {
    outputName = "negated_" + outputName;
        
        for(int i = 0; i < pixels.length; i++) {
        	for(int j = 0; j < pixels[i].length; j++) {
        		Color c = pixels[i][j];
                pixels[i][j] = new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
                
        	}
        }
    
 }
 
 // this makes the image 'simpler' by redrawing it using only a few colors
 // to do this: for each pixel, find the color in the list that is closest to
 // the pixel's rgb value. 
 // use this predefined color as the rgb value for the changed image.
 public void simplify() {
 
	// the list of colors to compare to. Feel free to change/add colors
		Color[] colorList = {Color.BLUE, Color.RED,Color.ORANGE, Color.MAGENTA,
         Color.BLACK, Color.WHITE, Color.GREEN, Color.YELLOW, Color.CYAN};
 outputName = "simplified_" + outputName;
 
 for(int i = 0; i < pixels.length; i++) {
 	for(int j = 0; j < pixels[i].length; j++) {
 		Color c = pixels[i][j];
 		int r = c.getRed();
 		int g = c.getGreen();
 		int b = c.getBlue();
 		
 		
 		Color similar = colorList[0];
 		double difference1 = Math.sqrt(3*Math.pow(255, 2));
 		
 		
 		for(int x = 0; x < colorList.length; x++) {
 			Color test = colorList[x];
 			int testR = test.getRed();
 			int testG = test.getGreen();
 			int testB = test.getBlue();
 			double difference = Math.sqrt(Math.pow(testR-r, 2) + Math.pow(testG-g, 2) + Math.pow(testB-b, 2));
 			if(difference < difference1) {
 				difference1 = difference;
 				similar = colorList[x];
 			}
 			
 		}
 		pixels[i][j] = similar;
 	}
 }
  
      
 }
 
 // optional helper method (recommended) that finds the 'distance' 
 // between two colors.
 // use the 3d distance formula to calculate


 
 public String distance(Color c1, Color c2) {
 	
	 return " ";
 }
 
 // this blurs the image
 // to do this: at each pixel, sum the 8 surrounding pixels' rgb values 
 // with the current pixel's own rgb value. 
 // divide this sum by 9, and set it as the rgb value for the blurred image
 
 public void blur() {
		outputName = "blurred_" + outputName;
		// variables for sums
		int sumr = 0;
		int sumg = 0;
		int sumb = 0;
		
		for (int i = 1; i < pixels.length-1; i ++) {
     	for(int j = 1; j < pixels[i].length-1; j ++) {
     	
     		// getting values of the pixel and its eight surrounding pixels.
     		Color c = pixels[i-1][j-1];
     		int r1 = c.getRed();
     		int g1 = c.getGreen();
     		int b1 = c.getBlue();
     		Color c2 = pixels[i-1][j];
     		int r2 = c2.getRed();
     		int g2 = c2.getGreen();
     		int b2 = c2.getBlue();
     		Color c3 = pixels[i-1][j+1];
     		int r3 = c3.getRed();
     		int g3 = c3.getGreen();
     		int b3 = c3.getBlue();		
     		Color c4 = pixels[i][j-1];
     		int r4 = c4.getRed();
     		int g4 = c4.getGreen();
     		int b4 = c4.getBlue();
     		Color c5 = pixels[i][j];
     		int r5 = c5.getRed();
     		int g5 = c5.getGreen();
     		int b5 = c5.getBlue();
     		Color c6 = pixels[i][j+1];
     		int r6 = c6.getRed();
     		int g6 = c6.getGreen();
     		int b6 = c6.getBlue();
     		Color c7 = pixels[i+1][j-1];
     		int r7 = c7.getRed();
     		int g7 = c7.getGreen();
     		int b7 = c7.getBlue();
     		Color c8 = pixels[i+1][j];
     		int r8 = c8.getRed();
     		int g8 = c8.getGreen();
     		int b8 = c8.getBlue();
     		Color c9 = pixels[i+1][j+1];
     		int r9 = c9.getRed();
     		int g9 = c9.getGreen();
     		int b9 = c9.getBlue();
     		
     		//sums of the pixel and its surrounding pixels
     		sumr = r1 + r2 + r3 + r4 + r5 + r6 + r7 + r8 + r9;
     		sumg = g1 + g2 + g3 + g4 + g5 + g6 + g7 + g8 + g9;
     		sumb = b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8 + b9;
     		
     		
     		//set the sum of pixels divided by nine and use as new rgb value
     		pixels[i][j] = new Color(sumr/9, sumg/9,  sumb/9); 
     		
     	}
		}
		
		
		// your code here
	}
 
 // this highlights the edges in the image, turning everything else black. 
 // to do this: at each pixel, sum the 8 surrounding pixels' rgb values. 
 // now, multiply the current pixel's rgb value by 8, then subtract the sum.
 // this value is the rgb value for the 'edged' image
 public void edge() {
     outputName = "edged_" + outputName;
     
     // similar to previous, setting sum values
     	int sumofr = 0;
		int sumofb = 0;
		int sumofg = 0;
		
		//a new blank canvas to relocate the pixels on to avoid error
		Color[][] finaledge = new Color[pixels.length][pixels[0].length];
		
     for (int i = 1; i < pixels.length-1; i ++) {
     	for (int j = 1; j < pixels[i].length-1; j ++) {
     		
     		// getting the pixel and its surrounding pixels values
     		Color c = pixels[i-1][j-1];
     		int r1 = c.getRed(),g1 = c.getGreen(),b1 = c.getBlue();
     		
     		
     		Color c2 = pixels[i-1][j];
     		int r2 = c2.getRed(),g2 = c2.getGreen(),b2 = c2.getBlue();

     		Color c3 = pixels[i-1][j+1];
     		int r3 = c3.getRed(),g3 = c3.getGreen(),b3 = c3.getBlue();

     		Color c4 = pixels[i][j-1];
     		int r4 = c4.getRed(),g4 = c4.getGreen(),b4 = c4.getBlue();
     		
     		Color c5 = pixels[i][j];
     		int r5 = c5.getRed(),g5 = c5.getGreen(),b5 = c5.getBlue();
     		
     		Color c6 = pixels[i][j+1];
     		int r6 = c6.getRed(),g6 = c6.getGreen(),b6 = c6.getBlue();
     		
     		Color c7 = pixels[i+1][j-1];
     		int r7 = c7.getRed(),g7 = c7.getGreen(),b7 = c7.getBlue();
     		
     		Color c8 = pixels[i+1][j];
     		int r8 = c8.getRed(),g8 = c8.getGreen(),b8 = c8.getBlue();
     		
     		Color c9 = pixels[i+1][j+1];
     		int r9 = c9.getRed(),g9 = c9.getGreen(),b9 = c9.getBlue();
     		// the pixel times eight and minus the surrounding pixels to get edge effect
     		sumofr = (r5 * 8) - (r1 + r2 + r3 + r4 + r6 + r7 + r8 + r9);
     		sumofg = (g5 * 8) - (g1 + g2 + g3 + g4 + g6 + g7 + g8 + g9);
     		sumofb = (b5 * 8) - (b1 + b2 + b3 + b4 + b6 + b7 + b8 + b9);
     		
     		// setting boundaries so the pixel would not exceed 255
     		if (sumofr > 255) {
     			sumofr = 255;
     		}
     		if (sumofg > 255) {
     			sumofg = 255;
     		}
     		if (sumofb > 255) {
     			sumofb = 255;
     		}
     		// setting boundaries so the pixel would not be negative
     		if (sumofr < 0) {
     			sumofr = 0;
     		}
     		if (sumofg < 0) {
     			sumofg = 0;
     		}
     		if (sumofb < 0) {
     			sumofb = 0;
     		}
     		//setting new values as new rgb or putting pixels onto finaledge
     		finaledge[i][j] = new Color(sumofr, sumofg, sumofb); 
     	
     	}
		}
     
     for (int i = 1; i < pixels.length-1; i ++) {
     	for (int j = 1; j < pixels[i].length-1; j ++) {
     		// filling in the canvas and making it complete
     		pixels[i][j] = finaledge[i][j];
     		
     	}
     }
     // your code here
 }
 
 public void greyscale() {
 	
 	for (int i = 0; i < pixels.length; i ++) {
     	for (int j = 0; j < pixels[i].length; j ++) {
     		
     		// getting rgb values
     		Color c = pixels[i][j];
     		int r = c.getRed();
     		int g = c.getGreen();
     		int b = c.getBlue();
     		
     		// getting the average
     		int sum = (r+g+b)/3;
     		
     		// using the averages as the new rgb value so would be greyscale.
     		pixels[i][j] = new Color(sum, sum, sum); 
 	
     	}
 	}
 	
 }
 
 
 // *************** DON'T MESS WITH THE BELOW CODE **************** //
 
 // feel free to check it out, but don't change it unless you've consulted 
 // with Mr. David and understand what the code's doing
 
 

 public void run() {
 	JFileChooser fc = new JFileChooser();
		File workingDirectory = new File(System.getProperty("user.dir")+System.getProperty("file.separator")+ "Images");
		//fc.setCurrentDirectory(workingDirectory);
		fc.showOpenDialog(null);
		File my_file = fc.getSelectedFile();
		if (my_file == null)
			System.exit(-1);
		
		// reads the image file and creates our 2d array
     BufferedImage image;
		try {
			image = ImageIO.read(my_file);
		
	        BufferedImage new_image = new BufferedImage(image.getWidth(),
	                        image.getHeight(), BufferedImage.TYPE_INT_ARGB);
	        create_pixel_array(image);
			outputName = my_file.getName();
			
			// runs the manipulations determined by the user
			System.out.println("Enter the manipulations you would like to run on the image.\nYour "
					+ "choices are: brighten, flip, negate, blur, edge, or simplify.\nEnter each "
					+ "manipulation you'd like to run, then type in 'done'.");
			Scanner in = new Scanner(System.in);
			String action = in.next().toLowerCase();
			while (!action.equals("done")) {
	    			try {
		    			if (action.equals("brighten")) {
		    				System.out.println("enter an amount to increase the brightness by");
		    				int brightness = in.nextInt();
		        			Method m = getClass().getDeclaredMethod(action, int.class);
		        			m.invoke(this, brightness);
		    			}
		    			else if (action.equals("flip")) {
		    				System.out.println("enter \"h\" to flip horizontally, anything else to flip vertically.");
		        			Method m = getClass().getDeclaredMethod(action, boolean.class);
		        			m.invoke(this, in.next().equals("h"));
		    			}
		    			else {
		        			Method m = getClass().getDeclaredMethod(action);
		        			m.invoke(this, new Object[0]);
		    			}
		    			System.out.println("done. enter another action, or type 'done'");
	    			}
	    			catch (NoSuchMethodException e) {
	    				System.out.println("not a valid action, try again");
	    			} catch (IllegalAccessException e) {e.printStackTrace();System.exit(1);} 
	    			catch (IllegalArgumentException e) {e.printStackTrace();System.exit(1);}
	    			catch (InvocationTargetException e) {e.printStackTrace();System.exit(1);}
	    			
	    			action = in.next().toLowerCase();
	    		} 
	        in.close();
	        
	        // turns our 2d array of colors into a new png file
	        create_new_image(new_image);
	        File output_file = new File("Images/" + outputName);
	        ImageIO.write(new_image, "png", output_file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
 }
		
 
 public void create_pixel_array(BufferedImage image) {
     w = image.getWidth();
     h = image.getHeight();
     pixels = new Color[h][];
     for (int i = 0; i < h; i++) {
         pixels[i] = new Color[w];
         for (int j = 0; j < w; j++) {
             pixels[i][j] = new Color(image.getRGB(j,i));
         }
     }
 }

 public void create_new_image(BufferedImage new_image) {
     for (int i = 0; i < h; i++) {
         for (int j = 0; j < w; j++) {
         		new_image.setRGB(j, i, pixels[i][j].getRGB());
         }
     }
 }

 public static void main(String[] args) {
		new Photo_shop();
	}

 public Photo_shop() {
		run();
 }
}