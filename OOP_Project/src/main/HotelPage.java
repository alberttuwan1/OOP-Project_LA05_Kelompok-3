package main;

import java.util.Vector;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class HotelPage{
	Vector<Accomodation> tempVector;

	BorderPane bp;
	Scene scene;
	Label desc,price;
	Button leftArr, rightArr;
	Stage ps;

	int index;
	int maxIndex;
	HBox hbox;
	ObservableList<String> options,options2;
	ComboBox<String> comboBox,comboBox2;
	Menu fileMenu;

	MenuItem home,villa;

	VBox vbox,content;

	Image imgCarousel;

	Label contentName,contentAddress,contentPrice,contentGrade;
	ImageView contentImage;
	int size;



	void refreshContent() {
		try {
			contentName.setText(tempVector.get(index).getName());
			contentAddress.setText(tempVector.get(index).getAddress());
			contentPrice.setText("Rp"+Integer.toString(tempVector.get(index).getPrice()));
			contentGrade.setText("Grade: "+Integer.toString(tempVector.get(index).getGrade()));
			contentImage.setImage(tempVector.get(index).getImage());
		} catch (Exception e) {
			System.out.println("refresh error");
		}
	}

	void initializeVector() {
		for(int i=0; i<Main.accomodationsHotel.size(); i++) {
			tempVector.add(Main.accomodationsHotel.get(i));
		}

	}

	void initialize() {
		initializeVector();
		index=0;
		size=tempVector.size();
		//INITIALIZE CONTENT AWAL
		content= new VBox();	
		content.setMaxWidth(600);
		content.setMaxHeight(500);
		
		//NAME
		contentName= new Label(tempVector.get(index).getName());
		contentName.setFont(new Font(30));
		contentName.setMinWidth(700);
		contentName.setTextAlignment(TextAlignment.CENTER);
		contentName.setAlignment(Pos.CENTER);

		//ADDRESS
		contentAddress= new Label(tempVector.get(index).getAddress());
		contentAddress.setWrapText(true);
		contentAddress.setFont(new Font(20));
		contentAddress.setMaxHeight(60);
		contentAddress.setMinHeight(60);
		contentAddress.setTextAlignment(TextAlignment.CENTER);

		//PRICE & GRADE
		contentPrice= new Label("Rp"+Integer.toString(tempVector.get(index).getPrice()));
		contentPrice.setFont(new Font(20));
		contentGrade= new Label("Grade: "+Integer.toString(tempVector.get(index).getGrade()));
		contentGrade.setFont(new Font(20));
		contentImage= new ImageView(tempVector.get(index).getImage());
		contentImage.setFitHeight(350);
		contentImage.setFitWidth(600);

		//BOLD FONT
		contentName.setStyle("-fx-font-weight: bold");
		contentAddress.setStyle("-fx-font-weight: bold");
		contentPrice.setStyle("-fx-font-weight: bold");
		contentGrade.setStyle("-fx-font-weight: bold");

		contentImage= new ImageView(tempVector.get(index).getImage());
		contentImage.setFitHeight(350);
		contentImage.setFitWidth(600);

		//METHOD UNTUK REFRESH CONTENTNYA
		refreshContent();


		leftArr=new Button("<<");
		leftArr.setFont(new Font(20));
		leftArr.setMinWidth(75);

		rightArr=new Button(">>");
		rightArr.setFont(new Font(20));
		rightArr.setMinWidth(75);

		leftArr.setStyle("-fx-background-radius: 45px");
		rightArr.setStyle("-fx-background-radius: 45px");


		MenuBar menuBar = new MenuBar();

		fileMenu = new Menu("Menu");
		home = new MenuItem("Home");
		villa = new MenuItem("Villa");
		fileMenu.getItems().addAll(home, villa);

		menuBar.getMenus().addAll(fileMenu);
		menuBar.setStyle("-fx-background-color: #F5F4FA");

		hbox=new HBox();
		hbox.getChildren().addAll(leftArr,rightArr);
		hbox.setSpacing(450);
		hbox.setAlignment(Pos.CENTER);


		content.getChildren().addAll(contentImage,contentName,contentAddress,contentGrade,contentPrice,hbox);
		content.setAlignment(Pos.CENTER);

		options = FXCollections.observableArrayList("None", "Grade 3", "Grade 4", "Grade 5");
		comboBox= new ComboBox<>(options);
		comboBox.setPromptText("Grade");

		options2 = FXCollections.observableArrayList("None", "Bali", "Jakarta");
		comboBox2= new ComboBox<>(options2);
		comboBox2.setPromptText("Location");

		comboBox.setStyle("-fx-opacity: 0.8");
		comboBox2.setStyle("-fx-opacity: 0.8");

		this.bp= new BorderPane();
		vbox= new VBox();
		HBox filter = new HBox();
		filter.getChildren().addAll(comboBox,comboBox2);
		vbox.getChildren().addAll(menuBar,filter);

		bp.setTop(vbox);
		bp.setCenter(content);

		Image img = new Image("file:src/assets/villaMenu.png");

		BackgroundSize bSize= new BackgroundSize(300, 200, true, true,true,true);
		BackgroundImage vbg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize);
		bp.setBackground(new Background(vbg));
		this.scene=new Scene(this.bp,1200,700);
	}

	void gradeFilter() {
		tempVector.clear();
		String gradeFilter=comboBox.getValue();
		if(gradeFilter==null)gradeFilter="None";
		String locationFilter=comboBox2.getValue();
		if(locationFilter==null)locationFilter="None";

		//MASUKIN ULANG SEMUA DATA
		if(gradeFilter.equalsIgnoreCase("None") && locationFilter.equalsIgnoreCase("None")) {
			for(int i=0; i<Main.accomodationsHotel.size(); i++) {
				tempVector.add(Main.accomodationsHotel.get(i));
			}
		}
		else if(!gradeFilter.equalsIgnoreCase("None") && locationFilter.equalsIgnoreCase("None")){
			for(int i=0; i<Main.accomodationsHotel.size(); i++) {
				if(Main.accomodationsHotel.get(i).getGrade() ==  Integer.parseInt(gradeFilter.substring(6))) {
					tempVector.add(Main.accomodationsHotel.get(i));
				}
			}
		}
		else if(gradeFilter.equalsIgnoreCase("None") && !locationFilter.equalsIgnoreCase("None")){
			for(int i=0; i<Main.accomodationsHotel.size(); i++) {
				if(Main.accomodationsHotel.get(i).getAddress() .contains(locationFilter)) {
					tempVector.add(Main.accomodationsHotel.get(i));
				}
			}
		}
		else {
			for(int i=0; i<Main.accomodationsHotel.size(); i++) {
				if(Main.accomodationsHotel.get(i).getAddress() .contains(locationFilter) && Main.accomodationsHotel.get(i).getGrade() ==  Integer.parseInt(gradeFilter.substring(6))) {
					tempVector.add(Main.accomodationsHotel.get(i));
				}
			}
		}

		size=tempVector.size();
		index=0;
		refreshContent();
	}

	void combo() {
		comboBox.setOnAction(e -> {
			gradeFilter();
		});

		comboBox.setOnMouseEntered(e -> {
			comboBox.setStyle("-fx-opacity: 1");
		});
		comboBox.setOnMouseExited(e -> {
			comboBox.setStyle("-fx-opacity: 0.8");
		});

		comboBox2.setOnAction(e -> {
			gradeFilter();
		});

		comboBox2.setOnMouseEntered(e -> {
			comboBox2.setStyle("-fx-opacity: 1");
		});
		comboBox2.setOnMouseExited(e -> {
			comboBox2.setStyle("-fx-opacity: 0.8");
		});

		home.setOnAction(e->{
			ps.setScene(Main.mainScene);
		});

		villa.setOnAction(e->{
			Main.vp.setScene(ps);
		});

		leftArr.setOnAction(e->{
			if(index-1<0) {
				index=size-1;
				refreshContent();
			}
			else {
				index--;
				refreshContent();
			}
		});

		rightArr.setOnAction(e->{
			if(index+1>=size) {
				index=0;
				refreshContent();
			}
			else {
				index++;
				refreshContent();
			}
		});
	}

	public HotelPage(Stage ps) {
		tempVector=new Vector<>();
		this.ps=ps;
	}

	public void setScene(Stage ps) {
		initialize();
		combo();
		ps.setScene(this.scene);
	} 
}
