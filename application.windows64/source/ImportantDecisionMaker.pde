import javax.swing.*;

float angle;
float jitter;
boolean spinning = true;
int rand = (int)(Math.random() * 1000);
String[] decisions;
int[] colors;
int[] colors1;

void setup() {
  PImage icon = loadImage(dataPath("icon.png"));
  surface.setIcon(icon);
  
  size(500, 500);
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

void draw() {
  background(255);
  ellipse(width/2, height/2, 400, 400);
  for (int i = 0; i < decisions.length; i++) {
    fill(0, colors1[i], colors[i]);
    arc(width/2, height/2, 400, 400, 0, ((decisions.length) - i) * ((2 * PI)/decisions.length));
  }

  drawLegend();
  drawPin();
}

void drawPin() {
  int count = -1;
  if (second() %2==0) {
    count = (int)(Math.random() * 1000);
  }
  if (rand == count) {
    spinning = false;
  }
  if (spinning) {
    angle+=.1;
  }
  fill(255, 0, 0);
  translate(width/2, height/2);
  rotate(angle);
  rect(0, 0, 5, 180);
}

void drawLegend() {
  for (int i = 0; i < decisions.length; i++) {
    fill(0, colors1[i], colors[i]);
    rect(0, 0 +(i * 10), 10, 10);
    fill(0);
    text(decisions[i], 10, 10+(i*10));
  }
}


void mouseClicked(){
 spinning=true; 
}