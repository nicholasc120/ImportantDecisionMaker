import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import javax.swing.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class ImportantDecisionMaker extends PApplet {



float angle;
float jitter;
boolean spinning = true;
int rand = (int)(Math.random() * 1000);
String[] decisions;
int[] colors;
int[] colors1;

public void setup() {
  PImage icon = loadImage(dataPath("icon.png"));
  surface.setIcon(icon);
  
  
  noStroke();
  int n = Integer.parseInt(JOptionPane.showInputDialog("How many decisions?"));
  while (n < 2) {
    n = Integer.parseInt(JOptionPane.showInputDialog("How many decisions?"));
  }
  decisions = new String[n];
  colors = new int[n];
  colors1 = new int[n];
  for (int i = 0; i < decisions.length; i++) {
    decisions[i] = JOptionPane.showInputDialog("Input decision " + (i + 1));
    colors[i] = (int)(Math.random() * 255);
    colors1[i] = (int)(Math.random() * 255);
  }
}

public void draw() {
  background(255);
  ellipse(width/2, height/2, 400, 400);
  for (int i = 0; i < decisions.length; i++) {
    fill(0, colors1[i], colors[i]);
    arc(width/2, height/2, 400, 400, 0, ((decisions.length) - i) * ((2 * PI)/decisions.length));
  }

  drawLegend();
  drawPin();
}

public void drawPin() {
  int count = -1;
  if (second() %2==0) {
    count = (int)(Math.random() * 1000);
  }
  if (rand == count) {
    spinning = false;
  }
  if (spinning) {
    angle+=.1f;
  }
  fill(255, 0, 0);
  translate(width/2, height/2);
  rotate(angle);
  rect(0, 0, 5, 180);
}

public void drawLegend() {
  for (int i = 0; i < decisions.length; i++) {
    fill(0, colors1[i], colors[i]);
    rect(0, 0 +(i * 10), 10, 10);
    fill(0);
    text(decisions[i], 10, 10+(i*10));
  }
}


public void mouseClicked(){
 spinning=true; 
}
  public void settings() {  size(500, 500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "ImportantDecisionMaker" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
