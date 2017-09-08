import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.*;

public class USFlag extends JFrame {
	Color blue = new Color(0, 40, 104);
	Color red = new Color(191, 10, 48);
	// flag size
	int A = 1000;// width of flag
	int B = 1900;// length of flag
	int C = 539;// width of union
	int D = 760;// length of union
	int E = 54;// row: length from botton line of union to star's center
	int F = 54;// row: length from star's center to other star's center
	int G = 63;	// colum: length from union's two side to star's center
	int H = 63;	// colum: length from star's center to star's center
	int K = 62;	// Diameter of star
	int L = 77;// width of stripe

	public USFlag() {
		init();
	}

	public void init() {
		setSize(190, 100);
		setBackground(Color.BLACK);
		repaint();
	}

	public void paint(Graphics g) {
		int width =  this.getWidth();
		int adjustHeight = width*A/B;
		//black init
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, this.getHeight());
		// red background
		g.setColor(red);
		g.fillRect(0, 22, width, width*A/B);
		// white strip
		g.setColor(Color.WHITE);
		for (int k = 0; k < 6; k++) {
			g.fillRect(0, k*2*adjustHeight*L/A+22+adjustHeight*L/A, width, adjustHeight*L/A);
		}
		// union
		g.setColor(blue);
		g.fillRect(0, 22, width*D/B, adjustHeight*C/A);
		// star
		g.setColor(Color.WHITE);
		int xpoints[] = new int[5];
		int ypoints[] = new int[5];
		int x2[] = new int[5];
		int y2[] = new int[5];
		
		for (int k = 0; k<5; k++){
			//create spikes
			xpoints[k] = (int)((Math.cos(4*k*Math.PI/5 - Math.PI/2))*width*K/B/2+ G*width/B);
			ypoints[k] = (int)((Math.sin(4*k*Math.PI/5 - Math.PI/2))*width*K/B/2+ E*adjustHeight/A + 22);
			//create polygon inside the spikes. Because the convertion between decimal and int, 
			//a empty line would appear if rotate the polygon clockwise - therefore
			//rotate the polygon counterclockwise,set its size a bigger than demanded perfect polygon
			//but smaller than range of spikes, and let it overlop with spikes 
			x2[k] = (int)((Math.cos(2*k*Math.PI/5 - Math.PI/2))*width*K/B/4+ G*width/B);
			y2[k] = (int)((Math.sin(2*k*Math.PI/5 - Math.PI/2))*width*K/B/4+ E*adjustHeight/A + 22);
		}

		//for 6 colum
		for (int j = 0; j < 6; j++) {
			//draw first colum
			for (int k = 0; k < 5; k++) {
				g.fillPolygon(xpoints, ypoints, 5);
				g.fillPolygon(x2, y2, 5);
				for (int i = 0; i < 5; i++) {
					ypoints[i] += 2*F*adjustHeight/A;
					y2[i] += 2*F*adjustHeight/A;
				}
			}
			//reset y value
			for (int i = 0; i < 5; i++) {
				ypoints[i] = (int)((Math.sin(4*i*Math.PI/5 - Math.PI/2))*width*K/B/2+ E*adjustHeight/A + 22);
				y2[i] = (int)((Math.sin(2*i*Math.PI/5 - Math.PI/2))*width*K/B/4+ E*adjustHeight/A + 22);
			}
			//draw 5 more colum
			for (int l = 0; l < 5; l++) {
				xpoints[l] += 2*width*H/B;
				x2[l] += 2*width*H/B;
			}
		}
		
		//reset x and y value and adjust them to the 1st row of 2nd colum
		for (int k = 0; k<5; k++){
			xpoints[k] = (int)((Math.cos(4*k*Math.PI/5 - Math.PI/2))*width*K/B/2+ G*width/B + H*width/B);
			ypoints[k] = (int)((Math.sin(4*k*Math.PI/5 - Math.PI/2))*width*K/B/2+ E*adjustHeight/A + 22 + F*adjustHeight/A);
			x2[k] = (int)((Math.cos(2*k*Math.PI/5 - Math.PI/2))*width*K/B/4+ G*width/B + H*width/B);
			y2[k] = (int)((Math.sin(2*k*Math.PI/5 - Math.PI/2))*width*K/B/4+ E*adjustHeight/A + 22 + F*adjustHeight/A);
		}
		
		//5 colum
		for (int j = 0; j < 5; j++) {
			//draw 2nd colum
			for (int k = 0; k < 4; k++) {
				g.fillPolygon(xpoints, ypoints, 5);
				g.fillPolygon(x2, y2, 5);
				for (int i = 0; i < 5; i++) {
					ypoints[i] += 2*F*adjustHeight/A;
					y2[i] += 2*F*adjustHeight/A;
				}
			}
			//reset y value
			for (int i = 0; i < 5; i++) {
				ypoints[i] = (int)((Math.sin(4*i*Math.PI/5 - Math.PI/2))*width*K/B/2+ E*adjustHeight/A + 22 + F*adjustHeight/A);
				y2[i] = (int)((Math.sin(2*i*Math.PI/5 - Math.PI/2))*width*K/B/4+ E*adjustHeight/A + 22 + F*adjustHeight/A);
			}
			//draw 4 more colum
			for (int l = 0; l < 5; l++) {
				xpoints[l] += 2*width*H/B;
				x2[l] += 2*width*H/B;
			}
		}
		
	}
	
}