// LA05 - Project Akhir OOP
// 2502014841 - Mario Iskandar 
// 2502001353 - Albert Gabriel Tuwan
// 2540131374 - Alexander Ryan Wijaya

package main;


import java.util.Vector;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application{
	static Vector<Accomodation> accomodationsHotel = new Vector<>();
	static Vector<Accomodation> accomodationsVilla= new Vector<>();

	Label title;
	
	Button Button1;
	Button Button2;
	Button Button3;
	static Scene mainScene;
	VBox layout;

	BorderPane bp;
	static HotelPage hp; 
	static VillaPage vp; 
	Image imgView;
	Image img;
	int widthButton=350;
	int heightButton=80;

	public static void main(String[] args) {
		launch(args);
	}

	void initializeVector() {
		try {
			//HOTEL
			accomodationsHotel.clear();
			imgView= new Image("File:src/assets/Jakarta/hotel_jkt_1_Pinangsia Hotel.jpg");
			accomodationsHotel.add(new Hotel("Pinangsia Hotel","Jl. Pinangsia I No.55, Kec. Taman Sari, Kota Jakarta Barat, Daerah Khusus Ibukota Jakarta",3,700000,imgView));
			
			imgView= new Image("File:src/assets/Jakarta/hotel_jkt_2_Ibis Budget Jakarta Daan Mogot.jpg");
			accomodationsHotel.add(new Hotel("Ibis Budget Hotel","Jl. Raya Daan Mogot No.50 B, Kec. Grogol petamburan, Kota Jakarta Barat, DKI Jakarta",3,800000,imgView));

			imgView= new Image("File:src/assets/Jakarta/hotel_jkt_3_MaxOneHotels.jpg");
			accomodationsHotel.add(new Hotel("Max One Hotels","Jl. Ps. Glodok Sel. No.8-10, Glodok, Kec. Taman Sari, Kota Jakarta Barat, DKI Jakarta",4,1300000,imgView));

			imgView= new Image("File:src/assets/Jakarta/hotel_jkt_4_ASTON Kartika Grogol Hotel & Conference.jpg");
			accomodationsHotel.add(new Hotel("ASTON Kartika Grogol Hotel & Conference","Jl. Kyai Tapa No.101, Kec. Grogol petamburan, Kota Jakarta Barat, DKI Jakarta",4,4000000,imgView));

			imgView= new Image("File:src/assets/Jakarta/hotel_jkt_5_Fairmont Hotel Jakarta.jpg");
			accomodationsHotel.add(new Hotel("Fairmont Hotel Jakarta","Jl. Asia Afrika No.8, Senayan, Kecamatan Tanah Abang, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta",5,10000000,imgView));


			imgView= new Image("File:src/assets/Bali/HOTEL BALI/hotel_bali_3_Mars City Hotel.jpg");
			accomodationsHotel.add(new Hotel("Mars City Hotel","Jl. Kerta Dalem, Sidakarya, Denpasar Selatan, Kota Denpasar, Bali",3,1000000,imgView));

			imgView= new Image("File:src/assets/Bali/HOTEL BALI/hotel_bali_4_Fairfield by Marriott Bali Kuta Sunset Road.jpg");
			accomodationsHotel.add(new Hotel("Fairfield by Marriott Bali Kuta Sunset Road","Jalan Merdeka Raya No.Vii, Abianbase, Kecamatan Kuta, Kabupaten Badung, Bali",4,6000000,imgView));

			imgView= new Image("File:src/assets/Bali/HOTEL BALI/hotel_bali_5_Double Six Luxury Hotel.jpg");
			accomodationsHotel.add(new Hotel("Double Six Luxury Hotel","Jl. Pantai Legian Jl. Double Six No.66, Seminyak, Kec. Kuta, Kabupaten Badung, Bali",5,12000000,imgView));


			//VILLA
			imgView= new Image("/assets/Bali/VILLA BALI/villa_bali_3_Agung Villa Ubud.jpg");
			accomodationsVilla.add(new Villa("Agung Villa Ubud","Jalan subak br sala, pejeng, Gianyar, 80571 Ubud, Bali, Indonesia",3,5000000,imgView));

			imgView= new Image("/assets/Bali/VILLA BALI/villa_bali_4_D'Legon Luxury Villas.jpg");
			accomodationsVilla.add(new Villa("D'Legon Luxury Villas","Jl Tirta tawar, Kutuh Kaja Petulu Ubud Bali, 80571 Ubud, Indonesia",4,8500000,imgView));

			imgView= new Image("/assets/Bali/VILLA BALI/villa_bali_5_Ubud Syailendra Heritage Villas by EPS.jpg");
			accomodationsVilla.add(new Villa("Ubud Syailendra Heritage Villas by EPS","Jl. Tirta Tawar, Utara Ds Junjungan, Ubud, 80571 Ubud, Indonesia",5,15000000,imgView));


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	void initialize(Stage ps) {
		initializeVector();
		hp = new HotelPage(ps); 
		vp = new VillaPage(ps); 

		//BUTTON
		Button1= new Button("Villa");
		Button2= new Button("Hotel");
		Button3= new Button("Exit");
		
		//WIDTH
		Button1.setMinWidth(widthButton);
		Button1.setMaxWidth(widthButton);
		
		Button2.setMinWidth(widthButton);
		Button2.setMaxWidth(widthButton);
		
		Button3.setMinWidth(widthButton);
		Button3.setMaxWidth(widthButton);
		
		Button1.setAlignment(Pos.CENTER);
		Button2.setAlignment(Pos.CENTER);
		Button3.setAlignment(Pos.CENTER);

		Button1.setFont(new Font(50));
		Button2.setFont(new Font(50));
		Button3.setFont(new Font(50));

		Button1.setStyle("-fx-font-weight: bold");
		Button1.setStyle("-fx-background-radius: 45px");
	    
		Button2.setStyle("-fx-font-weight: bold");
		Button2.setStyle("-fx-background-radius: 45px");
		
		Button3.setStyle("-fx-font-weight: bold");
		Button3.setStyle("-fx-background-radius: 45px");
		
		Button1.setTextFill(Color.BLACK);
		Button2.setTextFill(Color.BLACK);
		Button3.setTextFill(Color.BLACK);


		layout = new VBox();
		layout.getChildren().addAll(Button1,Button2,Button3);
		layout.setAlignment(Pos.CENTER);
		layout.setSpacing(10);
		layout.setPadding(new Insets(150,0,0,0));
		bp = new BorderPane(layout);


		Image img = new Image("file:src/assets/Main Menu.png");

		BackgroundSize bSize= new BackgroundSize(300, 200, true, true,true,true);
		BackgroundImage vbg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize);
		bp.setBackground(new Background(vbg));
	}

	void mouseClick(Stage PrimaryStage) {
		Button1.setOnMouseClicked(e->{
			vp.setScene(PrimaryStage);
		});

		Button2.setOnMouseClicked(e->{
			hp.setScene(PrimaryStage);
		});

		Button3.setOnMouseClicked(e->{
			PrimaryStage.close();
		});
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		initialize(primaryStage);
		mouseClick(primaryStage);
		mainScene = new Scene(bp,1200,700);
		primaryStage.setScene(mainScene);
		
		primaryStage.setTitle("GOcation");
		primaryStage.setResizable(false);
		primaryStage.setMaximized(false);
		primaryStage.show();
	}

}
