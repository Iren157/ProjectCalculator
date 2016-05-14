package com.gluonapplication;


import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.application.Platform;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
public class GluonApplication extends Application {
	Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
	 boolean operatorAlreadyPressed = false;
		TextField t = new TextField();
		Label l=new Label();
		double []text=new double[5];
		String []sym= new String[5];
		static int ii=0;
		HBox r6 =new HBox();
		double result=0;
public void start(Stage primaryStage) {
	
	// --------------- Animation -----------------
StackPane pane = new StackPane();
Circle circle1 = new Circle(1);
circle1.setStroke(Color.BLACK);
circle1.centerXProperty().bind(pane.widthProperty().divide(2));
circle1.centerYProperty().bind(pane.heightProperty().divide(2));

//-----------------------Listview -----------------------------
String[] flagTitles = {"Alaa Ali  \n kkfjfkbj fkgjfgjkfgj", "Ereeny Anwer \n jfghkjfghfgjfghkjh", "Eva Magdy \n fjghfkjghfkjghkj",
"Monica Adel \n fhgkjfdghkjfdgh", "Engy Kamil \n jfkghgh"};
// Declare an ImageView array for the national flags of 9 countries
ImageView[] ImageViews = {
new ImageView("1.png"),
new ImageView("2.png"),
new ImageView("3.png"),
new ImageView("4.png"),
new ImageView("5.png"),

};


ListView<String> lv = new ListView<>
(FXCollections.observableArrayList(flagTitles));
lv.setPrefSize(300, 480);
lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
// Create a pane to hold image views
FlowPane imagePane = new FlowPane(5, 5);

BorderPane pane3 = new BorderPane();
pane3.setLeft(new ScrollPane(lv));
pane3.setCenter(imagePane);
lv.getSelectionModel().selectedItemProperty().addListener(
ov -> {
imagePane.getChildren().clear();
for (Integer i: lv.getSelectionModel().getSelectedIndices()) {
imagePane.getChildren().add(ImageViews[i]);
}
});



Button back = new Button("Back");
back.setMaxWidth(Double.MAX_VALUE);
back.setMaxHeight(100);
pane3.setBottom(back);

// Create a scene and place it in the stage
Stage Liststage = new Stage();
Scene listcene = new Scene(pane3,470, 480);
Liststage.setScene(listcene);
Liststage.setResizable(false);
back.setOnAction(e->{
	Liststage.close();
	primaryStage.show();
});

//------------------------- Calculator Stage --------------------
VBox panee = new VBox();
HBox r1 =new HBox();
t.setPrefWidth(480);
t.setPrefHeight(150);
t.setEditable(false);
HBox r2 =new HBox();
HBox r6 =new HBox();
r6.getChildren().add(l);
r6.setAlignment(Pos.CENTER);
Button n1 = new Button("1");
n1.setPrefWidth(80);
n1.setPrefHeight(130);
n1.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-background-color: brown");
n1.setTextFill(Color.WHITE);
Button n2 = new Button("2");
n2.setPrefWidth(80);
n2.setPrefHeight(130);
n2.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-background-color: brown");
n2.setTextFill(Color.WHITE);
Button n3 = new Button("3");
n3.setPrefWidth(80);
n3.setPrefHeight(130);
n3.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-background-color: brown");
n3.setTextFill(Color.WHITE);
Button s1 = new Button("%");
s1.setPrefWidth(80);
s1.setPrefHeight(130);
s1.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-background-color: FEDCBA");
s1.setTextFill(Color.BROWN);
Button s2 = new Button("CE");
s2.setPrefWidth(80);
s2.setPrefHeight(130);
s2.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-background-color: FEDCBA");
s2.setTextFill(Color.BROWN);
Button s3 = new Button("CL");
s3.setPrefWidth(80);
s3.setPrefHeight(130);
s3.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-background-color: FEDCBA");
s3.setTextFill(Color.BROWN);
HBox r3 =new HBox();
Button n4 = new Button("4");
n4.setPrefWidth(80);
n4.setPrefHeight(130);
n4.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-background-color: brown");
n4.setTextFill(Color.WHITE);
Button n5 = new Button("5");
n5.setPrefWidth(80);
n5.setPrefHeight(130);
n5.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-background-color: brown");
n5.setTextFill(Color.WHITE);
Button n6 = new Button("6");
n6.setPrefWidth(80);
n6.setPrefHeight(130);
n6.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-background-color: brown");
n6.setTextFill(Color.WHITE);
Button s4 = new Button("*");
s4.setPrefWidth(80);
s4.setPrefHeight(130);
s4.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-background-color: FEDCBA");
s4.setTextFill(Color.BROWN);
Button s5 = new Button("(");
s5.setPrefWidth(80);
s5.setPrefHeight(130);
s5.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-background-color: FEDCBA");
s5.setTextFill(Color.BROWN);
Button s6 = new Button(")");
s6.setPrefWidth(80);
s6.setPrefHeight(130);
s6.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-background-color: FEDCBA");
s6.setTextFill(Color.BROWN);
HBox r4 =new HBox();
Button n7 = new Button("7");
n7.setPrefWidth(80);
n7.setPrefHeight(130);
n7.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-background-color: brown");
n7.setTextFill(Color.WHITE);
Button n8 = new Button("8");
n8.setPrefWidth(80);
n8.setPrefHeight(130);
n8.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-background-color: brown");
n8.setTextFill(Color.WHITE);
Button n9 = new Button("9");
n9.setPrefWidth(80);
n9.setPrefHeight(130);
n9.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-background-color: brown");
n9.setTextFill(Color.WHITE);
Button s7 = new Button("-");
s7.setPrefWidth(80);
s7.setPrefHeight(130);
s7.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-background-color: FEDCBA");
s7.setTextFill(Color.BROWN);
Button s8 = new Button("x\u00B2");
s8.setPrefWidth(80);
s8.setPrefHeight(130);
s8.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-background-color: FEDCBA");
s8.setTextFill(Color.BROWN);
Button s9 = new Button("\u221A");
s9.setPrefWidth(80);
s9.setPrefHeight(130);
s9.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-background-color: FEDCBA");
s9.setTextFill(Color.BROWN);
HBox r5 =new HBox();
Button n0 = new Button("0");
n0.setPrefWidth(160);
n0.setPrefHeight(130);
n0.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-background-color: brown");
n0.setTextFill(Color.WHITE);
Button n11 = new Button(".");
n11.setPrefWidth(80);
n11.setPrefHeight(130);
n11.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-background-color: FEDCBA");
n11.setTextFill(Color.BROWN);
Button s0 = new Button("+");
s0.setPrefWidth(80);
s0.setPrefHeight(130);
s0.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-background-color: FEDCBA");
s0.setTextFill(Color.BROWN);
Button s11 = new Button("=");
s11.setPrefWidth(160);
s11.setPrefHeight(130);
s11.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-background-color: FEDCBA");
s11.setTextFill(Color.BROWN);
r1.getChildren().add(t);
r2.getChildren().addAll(n1,n2,n3,s1,s2,s3);
r3.getChildren().addAll(n4,n5,n6,s4,s5,s6);
r4.getChildren().addAll(n7,n8,n9,s7,s8,s9);
r5.getChildren().addAll(n0,n11,s0,s11);
r1.setAlignment(Pos.CENTER);
r2.setAlignment(Pos.CENTER);
r3.setAlignment(Pos.CENTER);
r4.setAlignment(Pos.CENTER);
r5.setAlignment(Pos.CENTER);
n1.setOnAction(e -> setnum(n1.getText()));
n2.setOnAction(e -> setnum(n2.getText()));
n3.setOnAction(e -> setnum(n3.getText()));
n4.setOnAction(e -> setnum(n4.getText()));
n5.setOnAction(e -> setnum(n5.getText()));
n6.setOnAction(e -> setnum(n6.getText()));
n7.setOnAction(e -> setnum(n7.getText()));
n8.setOnAction(e -> setnum(n8.getText()));
n9.setOnAction(e -> setnum(n9.getText()));
n11.setOnAction(e ->setnum(n11.getText()));
n0.setOnAction(e -> setnum(n0.getText()));
s0.setOnAction(e -> setnum(s0.getText()));
s1.setOnAction(e -> setnum(s1.getText()));
s2.setOnAction(e ->  clear() );
s3.setOnAction(e -> clearall());
s4.setOnAction(e -> setnum(s4.getText()));
s5.setOnAction(e -> setnum(s5.getText()));
s6.setOnAction(e -> setnum(s6.getText()));
s7.setOnAction(e -> setnum(s7.getText()));
s8.setOnAction(e -> power(t.getText()));
s9.setOnAction(e -> squr(t.getText()));
t.setFont(Font.font("Times", 40));
l.setFont(Font.font("Times", 20));
s11.setOnAction(e -> {new Thread(new Runnable(){
	
	@Override
	public void run(){
	try {
		stack solver = new stack();
        String infix = t.getText();
        String postfix= solver.convertToPostfix4(infix);
        try{
         result =solver.solvePostfix(postfix);
        }
        catch(Exception e)
    	{
        	Platform.runLater(new Runnable() { // Run from JavaFX GUI
        		 @Override
        		 public void run() {
        			 l.setText("Invaild operation");
 		        		 }
        	 });
    	}
        Platform.runLater(new Runnable() { // Run from JavaFX GUI
    		 @Override
    		 public void run() {
    			 String res=String.format("%.3f", result);
 		        t.setText(res);
    		 }
    	 });
         Thread.sleep(200);
		}
		catch (Exception ex) {
			 l.setText("Invaild operation");
	        	
		}
		}}).start();
});
   panee.getChildren().addAll(r1,r2,r3,r4,r5,r6);
  Scene scene = new Scene(panee,visualBounds.getWidth(),visualBounds.getHeight());
  Stage calc = new Stage();
    calc.setTitle("Calculator"); // Set the stage title
    calc.setScene(scene); // Place the scene in the stage
    primaryStage.setResizable(false);
  

//------------------------First stage ----------------------------

    
    HBox fp = new HBox(16);    
   	Image image1 = new Image(GluonApplication.class.getResource("/plus.png").toExternalForm());
   	ImageView imageView1 = new ImageView(image1);
   	imageView1.setFitHeight(50);
   	imageView1.setFitWidth(50);
   	Image image2 = new Image(GluonApplication.class.getResource("/-.png").toExternalForm());
   	ImageView imageView2 = new ImageView(image2);
   	imageView2.setFitHeight(50);
   	imageView2.setFitWidth(50);
   	Image image3 = new Image(GluonApplication.class.getResource("/m.png").toExternalForm());
   	ImageView imageView3 = new ImageView(image3);
   	imageView3.setFitHeight(50);
   	imageView3.setFitWidth(50);
   	Image image4 = new Image(GluonApplication.class.getResource("/dv.png").toExternalForm());
   	ImageView imageView4 = new ImageView(image4);
   	imageView4.setFitHeight(50);
   	imageView4.setFitWidth(50);

       Line l1 = new Line(0,0,0,250);
       Line l2 = new Line(0,0,0,250);
       Line l3 = new Line(0,0,0,250);
       Line l4 = new Line(0,0,0,250);

       fp.setPadding(new Insets(40));
       fp.getChildren().addAll(imageView2,imageView1,imageView3,imageView4);
       
       
       PathTransition pt1 = new PathTransition();
       pt1.setDuration(Duration.millis(4000));
       pt1.setPath(l1);
       pt1.setNode(imageView1);
       pt1.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
       pt1.setCycleCount(Timeline.INDEFINITE);
       pt1.play(); 

       PathTransition pt2 = new PathTransition();
       pt2.setDuration(Duration.millis(4000));
       pt2.setPath(l2);
       pt2.setNode(imageView2);
       pt2.setAutoReverse(true);
       pt2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
       pt2.setCycleCount(Timeline.INDEFINITE);
       pt2.play();
     
       PathTransition pt3 = new PathTransition();
       pt3.setDuration(Duration.millis(4000));
       pt3.setPath(l3);
       pt3.setNode(imageView3);
       pt3.setAutoReverse(true);
       pt3.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
       pt3.setCycleCount(Timeline.INDEFINITE);
       pt3.play();
       
   	PathTransition pt4 = new PathTransition();
   	pt4.setDuration(Duration.millis(4000));
   	pt4.setPath(l4);
   	pt4.setNode(imageView4);
   	pt4.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
   	pt4.setCycleCount(Timeline.INDEFINITE);
   	pt4.play(); 
   	
Button abtus = new Button("contact Us");
abtus.setOnAction(e->{
	primaryStage.close();
	Liststage.show();
});

Button strtclc = new Button ("Calculator");
strtclc.setOnAction(e->{
	primaryStage.close();
	calc.show();
});

VBox vbox= new VBox(20);
vbox.getChildren().addAll(strtclc,abtus);
vbox.setAlignment(Pos.CENTER);
vbox.setPadding(new Insets(20));

BorderPane border = new BorderPane();
border.setBottom(vbox);
border.setTop(fp);
Scene primaryscene = new Scene(border,visualBounds.getWidth(),visualBounds.getHeight());
primaryStage.setTitle("Calculator"); // Set the stage title
primaryStage.setScene(primaryscene); // Place the scene in the stage
primaryStage.show(); // Display the stage
}


public void power (String a)
{
	try {
		double s=Double.parseDouble(a);
		double r=( Math.pow(s, 2));
		t.setText(String.format("%.3f",r));}
		catch(Exception e)
    	{
    		l.setText("Invaild Operation");
    	}}
public void squr (String a)
{// try / catch here
	try{double s=Double.parseDouble(a);
	double r= Math.sqrt(s);
	t.setText(String.format("%.3f",r));}
	catch(Exception e)
	{
		l.setText("Invaild Operation");
	}
}
public void clear ()
{
	if (t.getLength()>0)
	t.setText(t.getText().substring( 0, t.getText().length()-1));
	
}
public void clearall()
{
	t.clear();
    l.setText("");
}
public void setnum (String a)
{
	 String s=t.getText()+a;
	 t.setText(s);
}
public static void main(String[] args) {
    launch(args);
  }

    
    


}