package geometrie;
/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

/* 
 * This is like the FontDemo applet in volume 1, except that it 
 * uses the Java 2D APIs to define and render the graphics and text.
 */

public class ShapesDemo extends JApplet {


    final static Color bg = Color.white;
    final static Color fg = Color.black;
  
    public ShapesDemo() {
		super();
		//setSize(700,700);
	}
    
    public void init() {
        //Initialize drawing colors
        setBackground(bg);
        setForeground(fg);
    }

    public void paint(Graphics g) {
    	this.setSize(new Dimension(900,900));
    	g.setColor(Color.red);
    	g.drawString("Gerade", 10, 10);
    	Gerade gerade = new Gerade(new Punkt(20,20), new Punkt(700,20));
    	gerade.zeichnen(g, 0);
    	
    	g.setColor(Color.BLUE);
    	Dreieck dreieck = new Dreieck(new Punkt[] {new Punkt(20,55), new Punkt(700, 55), new Punkt(70,100)});
    	dreieck.zeichnen(g, 0);
    	
    	g.setColor(Color.GREEN);
    	Viereck viereck = new Viereck(new Punkt[] {new Punkt(20,105), new Punkt(700, 105), new Punkt(650,130), new Punkt(30, 140)});
    	viereck.zeichnen(g, 0);
    	g.setColor(Color.CYAN);
    	Ellipse elips = new Ellipse(new Punkt(220, 150), 540, 40);
    	elips.zeichnen(g, 0);
    	
    	g.setColor(Color.RED);
    	Rechteck rechteck = new Rechteck(new Punkt(220, 250), 500, 100);
    	rechteck.zeichnen(g, 0);
    	Ellipse eli = new Ellipse(new Punkt(220, 250), 500, 100);
    	eli.zeichnen(g,0);
    }

    public static void main(String s[]) {
        JFrame f = new JFrame("ShapesDemo2D");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        
        JApplet applet = new ShapesDemo();
        f.getContentPane().add("Center", applet);
        applet.init();
        f.pack();
        f.setVisible(true);
    }

}

