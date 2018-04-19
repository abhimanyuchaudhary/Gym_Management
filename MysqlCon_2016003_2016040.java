import java.sql.*;  
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import java.io.*;
import java.io.Serializable;
import java.lang.Math;
import java.lang.System.*;
import java.util.*;
import javafx.animation.*;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.cell.PropertyValueFactory;
public class MysqlCon_2016003_2016040 extends Application{  
    final int maxrows = 10;
    final String db_password = "0";
    public static class Person {
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
 
        private Person(String fName, String lName) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
        }
        public String getFirstName() {
            return firstName.get();
        }
        public String getLastName() {
            return lastName.get();
        }
    }

    public static class Members {
        private final SimpleStringProperty id;
        private final SimpleStringProperty Name;
        private final SimpleStringProperty Date_Joined;
        private final SimpleStringProperty Tier_Name;
        private final SimpleStringProperty Trainer_id;
    
        private Members(String Id, String Name, String Date_Joined, String Tier_Name, String Trainer_id) {
            this.id = new SimpleStringProperty(Id);
            this.Name = new SimpleStringProperty(Name);
            this.Date_Joined = new SimpleStringProperty(Date_Joined);
            this.Tier_Name = new SimpleStringProperty(Tier_Name);
            this.Trainer_id = new SimpleStringProperty(Trainer_id);
        }
        public String getId() {
            return id.get();
        }
        public String getName() {
            return Name.get();
        }
        public String getDate_Joined() {
            return Date_Joined.get();
        }
        public String getTier_Name() {
            return Tier_Name.get();
        }
        public String getTrainer_id() {
            return Trainer_id.get();
        }
    }
    public static class BigClass {
        private final SimpleStringProperty one;
        private final SimpleStringProperty two;
        private final SimpleStringProperty three;
        private final SimpleStringProperty four;
        private final SimpleStringProperty five;
    
        private BigClass(String one, String two, String three, String four, String five) {
            this.one = new SimpleStringProperty(one);
            this.two = new SimpleStringProperty(two);
            this.three = new SimpleStringProperty(three);
            this.four = new SimpleStringProperty(four);
            this.five = new SimpleStringProperty(five);
        }
        public String getOne() {
            return one.get();
        }
        public String getTwo() {
            return two.get();
        }
        public String getThree() {
            return three.get();
        }
        public String getFour() {
            return four.get();
        }
        public String getFive() {
            return five.get();
        }
    }
    public static class Employees {
        private final SimpleStringProperty id;
        private final SimpleStringProperty Name;
        private final SimpleStringProperty Date_Joined;
        private final SimpleStringProperty Salary;
    
        private Employees(String id, String Name, String Date_Joined, String Salary) {
            this.id = new SimpleStringProperty(id);
            this.Name = new SimpleStringProperty(Name);
            this.Date_Joined = new SimpleStringProperty(Date_Joined);
            this.Salary = new SimpleStringProperty(Salary);
        }
        public String getId() {
            return id.get();
        }
        public String getName() {
            return Name.get();
        }
        public String getDate_Joined() {
            return Date_Joined.get();
        }
        public String getSalary() {
            return Salary.get();
        }
    }
    public static class Trainers {
        private final SimpleStringProperty Emp_id;
        private final SimpleStringProperty Specialization;
    
        private Trainers(String Emp_id, String Specialization) {
            this.Emp_id = new SimpleStringProperty(Emp_id);
            this.Specialization = new SimpleStringProperty(Specialization);

        }
        public String getEmp_id() {
            return Emp_id.get();
        }
        public String getSpecialization() {
            return Specialization.get();
        }

    }
    public static class Payments {
        private final SimpleStringProperty id;
        private final SimpleStringProperty Date;
        private final SimpleStringProperty Member_id;
        private final SimpleStringProperty Amount;
    
        private Payments(String id, String Date, String Member_id, String Amount) {
            this.id = new SimpleStringProperty(id);
            this.Date = new SimpleStringProperty(Date);
            this.Member_id = new SimpleStringProperty(Member_id);
            this.Amount = new SimpleStringProperty(Amount);
        }
        public String getId() {
            return id.get();
        }
        public String getDate() {
            return Date.get();
        }
        public String getMember_id() {
            return Member_id.get();
        }
        public String getAmount() {
            return Amount.get();
        }
    }
    public static class Tiers {
        private final SimpleStringProperty Name;
        private final int Cost;
        private Tiers(String Name, int Cost) {
            this.Name = new SimpleStringProperty(Name);
            this.Cost = Cost;
        }
        public String getName() {
            return Name.get();
        }
        public int getCost() {
            return Cost;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    public void displayAddMember() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Result");
        window.setMinWidth(300);
        window.setMinHeight(275);
            
        Label idLabel = new Label("ID: ");
        TextField idText = new TextField();
        Label NameLabel = new Label("Name: ");
        TextField NameText = new TextField();
        Label Date_JoinedLabel = new Label("Date Joined: ");
        TextField Date_JoinedText = new TextField();
        Label Tier_NameLabel = new Label("Tier Name: ");
        TextField Tier_NameText = new TextField();
        Label Trainer_idLabel = new Label("Trainer ID: ");
        TextField Trainer_idText = new TextField();

        Button btn = new Button();
        btn.setText("Add member");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{  
                    Class.forName("com.mysql.jdbc.Driver");  
                    Connection con=DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/sonoo?useSSL=false","root",db_password);  
                    //here sonoo is database name, root is username and password  
                    Statement stmt=con.createStatement(); 
                    String idvalue = idText.getText(); 
                    String Namevalue = NameText.getText(); 
                    String Date_Joinedvalue = Date_JoinedText.getText(); 
                    String Tier_Namevalue = Tier_NameText.getText(); 
                    String Trainer_idvalue = Trainer_idText.getText(); 

                    String q = "INSERT INTO Members VALUES (" + "'" + idvalue + "'" + ", " + "'"+ Namevalue + "'" + ", " + "'" + Date_Joinedvalue+ "'" + ", " + "'" + Tier_Namevalue + "'"+ ", " + "'" + Trainer_idvalue + "'"+ ");";
                    try{
                       stmt.executeUpdate(q);  
                    }
                    catch(Exception e){
                        // System.out.println(e);
                        showPopup(e.getMessage());
                        // showPopup("Incorrect values. Try again");
                    }
                    con.close(); 
                }
                catch(Exception e){ System.out.println(e);}  
                window.close(); 
            }
        });

        VBox root = new VBox();
        root.getChildren().addAll(idLabel, idText, NameLabel, NameText, Date_JoinedLabel, Date_JoinedText, Tier_NameLabel, 
            Tier_NameText, Trainer_idLabel, Trainer_idText, btn);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root);


        window.setScene(scene);
        window.show();
    }
    public void displayAddEmployee() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Result");
        window.setMinWidth(300);
        window.setMinHeight(275);
            
        Label idLabel = new Label("ID: ");
        TextField idText = new TextField();
        Label NameLabel = new Label("Name: ");
        TextField NameText = new TextField();
        Label Date_JoinedLabel = new Label("Date Joined: ");
        TextField Date_JoinedText = new TextField();
        Label SalaryLabel = new Label("Salary: ");
        TextField SalaryText = new TextField();

        Button btn = new Button();
        btn.setText("Add Employee");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{  
                    Class.forName("com.mysql.jdbc.Driver");  
                    Connection con=DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/sonoo?useSSL=false","root",db_password);  
                    //here sonoo is database name, root is username and password  
                    Statement stmt=con.createStatement(); 
                    String idvalue = idText.getText(); 
                    String Namevalue = NameText.getText(); 
                    String Date_Joinedvalue = Date_JoinedText.getText(); 
                    String Salaryvalue = SalaryText.getText(); 

                    String q = "INSERT INTO Employees VALUES (" + "'" + idvalue + "'" + ", " + "'"+ Namevalue + "'" + ", " + "'" + Date_Joinedvalue + "'" + ", "  + Salaryvalue + ");";
                    try{
                       stmt.executeUpdate(q);  
                    }
                    catch(Exception e){showPopup(e.getMessage());};
                    con.close(); 
                }
                catch(Exception e){ System.out.println(e);}  
                window.close(); 
            }
        });

        VBox root = new VBox();
        root.getChildren().addAll(idLabel, idText, NameLabel, NameText, Date_JoinedLabel, Date_JoinedText, SalaryLabel, SalaryText, btn);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root);


        window.setScene(scene);
        window.show();
    }
    public void displayAddPayment() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Result");
        window.setMinWidth(300);
        window.setMinHeight(275);
            
        Label idLabel = new Label("ID: ");
        TextField idText = new TextField();
        Label Date_PaidLabel = new Label("Date Paid: ");
        TextField Date_PaidText = new TextField();
        Label Member_idLabel = new Label("Member_id: ");
        TextField Member_idText = new TextField();
        Label AmountLabel = new Label("Amount: ");
        TextField AmountText = new TextField();

        Button btn = new Button();
        btn.setText("Record Payment");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{  
                    Class.forName("com.mysql.jdbc.Driver");  
                    Connection con=DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/sonoo?useSSL=false","root",db_password);  
                    //here sonoo is database name, root is username and password  
                    Statement stmt=con.createStatement(); 
                    String idvalue = idText.getText(); 
                    String Date_Paidvalue = Date_PaidText.getText(); 
                    String Member_idvalue = Member_idText.getText(); 
                    String Amountvalue = AmountText.getText(); 

                    String q = "INSERT INTO Payments VALUES (" + "'" + idvalue + "'" + ", " + "'"+ Date_Paidvalue + "'" + ", " + "'" + Member_idvalue + "'" + ", "  + Amountvalue + ");";
                    try{
                       stmt.executeUpdate(q);  
                    }
                    catch(Exception e){showPopup(e.getMessage());};
                    con.close(); 
                }
                catch(Exception e){ System.out.println(e);}  
                window.close(); 
            }
        });

        VBox root = new VBox();
        root.getChildren().addAll(idLabel, idText, Date_PaidLabel, Date_PaidText, Member_idLabel, Member_idText, AmountLabel, 
            AmountText, btn);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root);


        window.setScene(scene);
        window.show();
    }
    public void displayAddTier() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Result");
        window.setMinWidth(300);
        window.setMinHeight(275);
            
        Label NameLabel = new Label("Name: ");
        TextField NameText = new TextField();
        Label CostLabel = new Label("Cost: ");
        TextField CostText = new TextField();

        Button btn = new Button();
        btn.setText("Add Tier");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{  
                    Class.forName("com.mysql.jdbc.Driver");  
                    Connection con=DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/sonoo?useSSL=false","root",db_password);  
                    //here sonoo is database name, root is username and password  
                    Statement stmt=con.createStatement(); 
                    String Namevalue = NameText.getText(); 
                    String Costvalue = CostText.getText(); 

                    String q = "INSERT INTO Tiers VALUES (" + "'" + Namevalue + "'" + ", " + Costvalue + ")" + ";";
                    try{
                       stmt.executeUpdate(q);  
                    }
                    catch(Exception e){showPopup(e.getMessage());};
                    con.close(); 
                }
                catch(Exception e){ System.out.println(e);}  
                window.close(); 
            }
        });

        VBox root = new VBox();
        root.getChildren().addAll(NameLabel, NameText, CostLabel, CostText, btn);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root);

        window.setScene(scene);
        window.show();
    }
    public void displayAddTrainer() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Result");
        window.setMinWidth(300);
        window.setMinHeight(275);
            
        Label Emp_idLabel = new Label("Emp ID: ");
        TextField Emp_idText = new TextField();
        Label SpecializationLabel = new Label("Specialization: ");
        TextField SpecializationText = new TextField();

        Button btn = new Button();
        btn.setText("Add Trainer");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{  
                    Class.forName("com.mysql.jdbc.Driver");  
                    Connection con=DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/sonoo?useSSL=false","root",db_password);  
                    //here sonoo is database name, root is username and password  
                    Statement stmt=con.createStatement(); 
                    String Emp_idvalue = Emp_idText.getText(); 
                    String Specializationvalue = SpecializationText.getText(); 

                    String q = "INSERT INTO Trainers VALUES (" + "'" + Emp_idvalue + "'" + ", " + "'"+ Specializationvalue + "' )" + ";";
                    try{
                       stmt.executeUpdate(q);  
                    }
                    catch(Exception e){showPopup(e.getMessage());};
                    con.close(); 
                }
                catch(Exception e){ System.out.println(e);}  
                window.close(); 
            }
        });

        VBox root = new VBox();
        root.getChildren().addAll(Emp_idLabel, Emp_idText, SpecializationLabel, SpecializationText, btn);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root);

        window.setScene(scene);
        window.show();
    }

    public void displaySpecific(ResultSet rs, String TableName) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Result");
        window.setMinWidth(300);
        window.setMinHeight(275);
        VBox root = new VBox();
        if(TableName.equals("Trainers")) {
            TableView<Trainers> table = new TableView<>();
            table.setMaxHeight(275);
            TableColumn idCol = new TableColumn("ID");
            // firstNameCol.setMinWidth(100);
            idCol.setCellValueFactory(
                    new PropertyValueFactory<>("Emp_id"));
            
            TableColumn specCol = new TableColumn("Specialization");
            // lastNameCol.setMinWidth(100);
            specCol.setCellValueFactory(
                    new PropertyValueFactory<>("Specialization"));
            
            table.getColumns().addAll(idCol, specCol);        

            try{
                while(rs.next()) {
                    table.getItems().add(new Trainers(rs.getString(1), rs.getString(2)));
                }
            }
            catch(Exception e){ System.out.println(e);} 
            root.getChildren().add(table);
            root.setAlignment(Pos.CENTER);
        }
        else if(TableName.equals("Employees")) {
            TableView<Employees> table = new TableView<>();
            table.setMaxHeight(275);
            TableColumn idCol = new TableColumn("ID");
            // firstNameCol.setMinWidth(100);
            idCol.setCellValueFactory(
                    new PropertyValueFactory<Employees,String>("id"));
            
            TableColumn NameCol = new TableColumn("Name");
            // lastNameCol.setMinWidth(100);
            NameCol.setCellValueFactory(
                    new PropertyValueFactory<>("Name"));

            TableColumn Date_JoinedCol = new TableColumn("Date Joined");
            // firstNameCol.setMinWidth(100);
            Date_JoinedCol.setCellValueFactory(
                    new PropertyValueFactory<>("Date_Joined"));
            
            TableColumn SalaryCol = new TableColumn("Salary");
            // lastNameCol.setMinWidth(100);
            SalaryCol.setCellValueFactory(
                    new PropertyValueFactory<>("Salary"));
            table.getColumns().addAll(idCol, NameCol, Date_JoinedCol, SalaryCol);   
     
            try{
                while(rs.next()) {
                    Employees e = new Employees(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));

                    // System.out.println(e.getid() +" "+ e.getName() +" "+ e.getDate_Joined() +" "+ e.getSalary());
                    table.getItems().add(e);
                }
            }
            catch(Exception e){ System.out.println(e);} 
            root.getChildren().add(table);
            root.setAlignment(Pos.CENTER);
        }
        else if(TableName.equals("Payments")) {
            TableView<Payments> table = new TableView<>();
            table.setMaxHeight(275);
            TableColumn idCol = new TableColumn("ID");
            // firstNameCol.setMinWidth(100);
            idCol.setCellValueFactory(
                    new PropertyValueFactory<Payments,String>("id"));
            
            TableColumn Date_PaidCol = new TableColumn("Date");
            // lastNameCol.setMinWidth(100);
            Date_PaidCol.setCellValueFactory(
                    new PropertyValueFactory<>("Date"));

            TableColumn Member_idCol = new TableColumn("Member ID");
            // lastNameCol.setMinWidth(100);
            Member_idCol.setCellValueFactory(
                    new PropertyValueFactory<>("Member_id"));

            TableColumn AmountCol = new TableColumn("Amount");
            // lastNameCol.setMinWidth(100);
            AmountCol.setCellValueFactory(
                    new PropertyValueFactory<>("Amount"));
            
            table.getColumns().addAll(idCol, Date_PaidCol, Member_idCol, AmountCol); 
       
            try{
                while(rs.next()) {
                    table.getItems().add(new Payments(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                }
            }
            catch(Exception e){ System.out.println(e);} 
            root.getChildren().add(table);
            root.setAlignment(Pos.CENTER);
        }
        else if(TableName.equals("Members")) {
            TableView<Members> table = new TableView<>();
            table.setMaxHeight(275);
            TableColumn idCol = new TableColumn("ID");
            // firstNameCol.setMinWidth(100);
            idCol.setCellValueFactory(
                    new PropertyValueFactory<Members,String>("id"));

            TableColumn NameCol = new TableColumn("Name");
            // lastNameCol.setMinWidth(100);
            NameCol.setCellValueFactory(
                    new PropertyValueFactory<>("Name"));

            TableColumn Date_JoinedCol = new TableColumn("Date Joined");
            // lastNameCol.setMinWidth(100);
            Date_JoinedCol.setCellValueFactory(
                    new PropertyValueFactory<>("Date_Joined"));


            TableColumn TierCol = new TableColumn("Tier");
            // lastNameCol.setMinWidth(100);
            TierCol.setCellValueFactory(
                    new PropertyValueFactory<>("Tier_Name"));

            TableColumn TrainerCol = new TableColumn("Trainer ID");
            // lastNameCol.setMinWidth(100);
            TrainerCol.setCellValueFactory(
                    new PropertyValueFactory<Members,String>("Trainer_id"));
            
            table.getColumns().addAll(idCol, NameCol, Date_JoinedCol, TierCol, TrainerCol);        

            try{
                while(rs.next()) {
                    table.getItems().add(new Members(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
                }
            }
            catch(Exception e){ System.out.println(e);} 
            root.getChildren().add(table);
            root.setAlignment(Pos.CENTER);
            
        }


        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }
    public void displaySpecificX() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Result");
        window.setMinWidth(300);
        window.setMinHeight(275);
            
        Label TableLabel = new Label("Table: ");
        TextField TableText = new TextField();

        Label KeyLabel = new Label("Key: ");
        TextField KeyText = new TextField();

        Button btn = new Button();
        btn.setText("Show");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{  
                    Class.forName("com.mysql.jdbc.Driver");  
                    Connection con=DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/sonoo?useSSL=false","root",db_password);  
                    //here sonoo is database name, root is username and password  
                    Statement stmt=con.createStatement(); 
                    String KeyValue = KeyText.getText(); 
                    String TableValue = TableText.getText();
                    String PrKey = "Emp_id";
                    if(TableValue.equals("Trainers"))
                        PrKey = "Emp_id";
                    else if(TableValue.equals("Tiers"))
                        PrKey = "Name";
                    else 
                        PrKey = "id";
                    String w = "SELECT * FROM " +  TableValue + " WHERE " +  PrKey  + " = '"  +  KeyValue + "';";
                    ResultSet rs;
                    try{
                       rs = stmt.executeQuery(w);  
                       displaySpecific(rs, TableValue);
                    }
                    catch(Exception e){
                        // System.out.println(e);
                        // showPopup("Incorrect values. Try again");
                        showPopup(e.getMessage());
                    }
                    con.close(); 
                }
                catch(Exception e){ System.out.println(e);}  
                window.close(); 
            }
        });

        VBox root = new VBox();
        root.getChildren().addAll(TableLabel, TableText, KeyLabel, KeyText , btn);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root);

        window.setScene(scene);
        window.show();
    }
    public void deleteSpecificX() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Result");
        window.setMinWidth(300);
        window.setMinHeight(275);
            
        Label TableLabel = new Label("Table: ");
        TextField TableText = new TextField();

        Label KeyLabel = new Label("Key: ");
        TextField KeyText = new TextField();

        Button btn = new Button();
        btn.setText("Delete");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{  
                    Class.forName("com.mysql.jdbc.Driver");  
                    Connection con=DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/sonoo?useSSL=false","root",db_password);  
                    //here sonoo is database name, root is username and password  
                    Statement stmt=con.createStatement(); 
                    String KeyValue = KeyText.getText(); 
                    String TableValue = TableText.getText();
                    String PrKey = "Emp_id";
                    if(TableValue.equals("Trainers"))
                        PrKey = "Emp_id";
                    else if(TableValue.equals("Tiers"))
                        PrKey = "Name";
                    else 
                        PrKey = "id";
                    String w = "DELETE FROM " +  TableValue + " WHERE " +  PrKey  + " = '"  +  KeyValue + "';";
                    try{
                       stmt.executeUpdate(w);  
                    }
                    catch(Exception e){
                        // System.out.println(e);
                        showPopup(e.getMessage());
                        // showPopup("Incorrect values. Try again");
                    }
                    con.close(); 
                }
                catch(Exception e){ System.out.println(e);}  
                window.close(); 
            }
        });

        VBox root = new VBox();
        root.getChildren().addAll(TableLabel, TableText, KeyLabel, KeyText , btn);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root);

        window.setScene(scene);
        window.show();
    }
    public void processXY(int type, int size) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Result");
        window.setMinWidth(300);
        window.setMinHeight(275);
        VBox root = new VBox();

        if(size == 1){
            Label xLabel = new Label("X: ");
            TextField xText = new TextField();

            Button btn = new Button();
            btn.setText("Compute");

            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try{  
                        Class.forName("com.mysql.jdbc.Driver");  
                        Connection con=DriverManager.getConnection(  
                        "jdbc:mysql://localhost:3306/sonoo?useSSL=false","root",db_password);  
                        //here sonoo is database name, root is username and password  
                        Statement stmt=con.createStatement(); 
                        String xValue = xText.getText(); 
                        String w="";
                        ResultSet rs;
                        if(type == 2){
                            w = "SELECT * FROM Members WHERE Members.id NOT IN (SELECT Members.id FROM Members, Payments WHERE Members.id = "+
                                "Member_id AND Date_Paid >= '" + xValue + "');";

                        }
                        try{
                           rs = stmt.executeQuery(w);  
                           displaySpecificComplex(rs, type);

                        }
                        catch(Exception e){
                            // System.out.println(e);
                            showPopup(e.getMessage());
                            // showPopup("Incorrect values. Try again");
                        }
                        con.close(); 
                    }
                    catch(Exception e){ System.out.println(e);}  
                    window.close(); 
                }
            });

            root.getChildren().addAll(xLabel, xText , btn);
            root.setAlignment(Pos.CENTER);
        }
        else if(size == 2){

            Label xLabel = new Label("X: ");
            TextField xText = new TextField();
            Label yLabel = new Label("Y: ");
            TextField yText = new TextField();

            Button btn = new Button();
            btn.setText("Compute");

            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try{  
                        Class.forName("com.mysql.jdbc.Driver");  
                        Connection con=DriverManager.getConnection(  
                        "jdbc:mysql://localhost:3306/sonoo?useSSL=false","root",db_password);  
                        //here sonoo is database name, root is username and password  
                        Statement stmt=con.createStatement(); 
                        String xValue = xText.getText(); 
                        String yValue = yText.getText(); 
                        String w = "";
                        ResultSet rs;
                        if(type == 1){
                            w = "SELECT id, Members.Name, Date_Joined, Cost as Tier_Cost FROM Members, Tiers WHERE Tier_Name = "+
                                "Tiers.Name AND Cost >= " +yValue+ " AND Date_Joined >= '" + xValue +"';";
                                System.out.println(w);
                        }
                        else if(type == 3){
                            w = "Select id, Name, Specialization, Salary FROM Trainers, Employees WHERE Emp_id = id AND Specialization " +
                                " = '" +xValue+"' AND Salary >= " + yValue +";";
                        }
                        try{
                           rs = stmt.executeQuery(w);  
                           displaySpecificComplex(rs, type);
                        }
                        catch(Exception e){
                            // System.out.println(e);
                            showPopup(e.getMessage());
                            // showPopup("Incorrect values. Try again");
                        }
                        con.close(); 
                    }
                    catch(Exception e){ System.out.println(e);}  
                    window.close(); 
                }
            });

            root.getChildren().addAll(xLabel, xText, yLabel, yText , btn);
            root.setAlignment(Pos.CENTER);
        }
        Scene scene = new Scene(root);

        window.setScene(scene);
        window.show();

    }
    public void showPopup(String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Result");
        window.setMinWidth(300);
        window.setMinHeight(275);
        
        Label m = new Label(message);

        VBox root = new VBox(m);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root);


        window.setScene(scene);
        window.show();
    }
    // public void displayDefaultWithPages(ResultSet rs) {
    //     Stage window = new Stage();
    //     window.initModality(Modality.APPLICATION_MODAL);
    //     window.setTitle("Result");
    //     window.setMinWidth(300);
    //     window.setMinHeight(275);
        
    //     TableView<Person> table = new TableView<>();
    //     table.setMaxHeight(275);
    //     TableColumn firstNameCol = new TableColumn("First Name");
    //     // firstNameCol.setMinWidth(100);
    //     firstNameCol.setCellValueFactory(
    //             new PropertyValueFactory<>("firstName"));
 
    //     TableColumn lastNameCol = new TableColumn("Last Name");
    //     // lastNameCol.setMinWidth(100);
    //     lastNameCol.setCellValueFactory(
    //             new PropertyValueFactory<>("lastName"));
        
    //     table.getColumns().addAll(firstNameCol, lastNameCol);

    //     Button Nextbtn = new Button();
    //     Nextbtn.setText("Next");
    //     Nextbtn.setOnAction(event -> {
    //         for(int i = 0; i < maxrows; i++){
    //             if(table.getItems().size() == 0)
    //                 break;
    //             Person selectedItem = table.getItems().get(0);
    //             table.getItems().remove(selectedItem);

    //         }
    //     });
        
    //     try{
    //         while(rs.next()) {
    //             table.getItems().add(new Person(rs.getString(1), rs.getString(2)));
    //         }
    //     }
    //     catch(Exception e){ System.out.println(e);} 



    //     VBox root = new VBox(table);
    //     root.getChildren().add(Nextbtn);
    //     root.setAlignment(Pos.CENTER);
    //     Scene scene = new Scene(root);


    //     window.setScene(scene);
    //     window.show();
    // }
    public void displaySpecificComplex(ResultSet rs, int type) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Result");
        window.setMinWidth(300);
        window.setMinHeight(275);
        VBox root = new VBox();
        //I'm so sorry I have to do this. But it's late and I'm going to have some hotdogs.
        if(type == 1){
            TableView<BigClass> table = new TableView<>();
            table.setMaxHeight(275);
            TableColumn oneCol = new TableColumn("ID");
            // firstNameCol.setMinWidth(100);
            oneCol.setCellValueFactory(
                    new PropertyValueFactory<BigClass, String>("one"));
            
            TableColumn twoCol = new TableColumn("Name");
            // firstNameCol.setMinWidth(100);
            twoCol.setCellValueFactory(
                    new PropertyValueFactory<BigClass, String>("two"));

            TableColumn threeCol = new TableColumn("Date Joined");
            // firstNameCol.setMinWidth(100);
            threeCol.setCellValueFactory(
                    new PropertyValueFactory<BigClass, String>("three"));

            TableColumn fourCol = new TableColumn("Cost");
            // firstNameCol.setMinWidth(100);
            fourCol.setCellValueFactory(
                    new PropertyValueFactory<BigClass, String>("four"));
            
            table.getColumns().addAll(oneCol, twoCol, threeCol, fourCol);        
            Button Nextbtn = new Button();
            Nextbtn.setText("Next");
            Nextbtn.setOnAction(event -> {
                for(int i = 0; i < maxrows; i++){
                    if(table.getItems().size() == 0)
                        break;
                    BigClass selectedItem = table.getItems().get(0);
                    table.getItems().remove(selectedItem);

                }
            });
            try{
                while(rs.next()) {
                    table.getItems().add(new BigClass(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), " "));
                }
            }
            catch(Exception e){ System.out.println(e);} 
            root.getChildren().addAll(table, Nextbtn);
            root.setAlignment(Pos.CENTER);
        }
        if(type == 2){
            TableView<BigClass> table = new TableView<>();
            table.setMaxHeight(275);
            TableColumn oneCol = new TableColumn("ID");
            // firstNameCol.setMinWidth(100);
            oneCol.setCellValueFactory(
                    new PropertyValueFactory<BigClass, String>("one"));
            
            TableColumn twoCol = new TableColumn("Name");
            // firstNameCol.setMinWidth(100);
            twoCol.setCellValueFactory(
                    new PropertyValueFactory<BigClass, String>("two"));

            TableColumn threeCol = new TableColumn("Date Joined");
            // firstNameCol.setMinWidth(100);
            threeCol.setCellValueFactory(
                    new PropertyValueFactory<BigClass, String>("three"));

            TableColumn fourCol = new TableColumn("Tier Name");
            // firstNameCol.setMinWidth(100);
            fourCol.setCellValueFactory(
                    new PropertyValueFactory<BigClass, String>("four"));
            TableColumn fiveCol = new TableColumn("Trainer ID");
            // firstNameCol.setMinWidth(100);
            fiveCol.setCellValueFactory(
                    new PropertyValueFactory<BigClass, String>("five"));
            
            table.getColumns().addAll(oneCol, twoCol, threeCol, fourCol);  
            Button Nextbtn = new Button();
            Nextbtn.setText("Next");
            Nextbtn.setOnAction(event -> {
                for(int i = 0; i < maxrows; i++){
                    if(table.getItems().size() == 0)
                        break;
                    BigClass selectedItem = table.getItems().get(0);
                    table.getItems().remove(selectedItem);

                }
            });      
            try{
                while(rs.next()) {
                    table.getItems().add(new BigClass(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                                                        rs.getString(5)));
                }
            }
            catch(Exception e){ System.out.println(e);} 
            root.getChildren().addAll(table, Nextbtn);
            root.setAlignment(Pos.CENTER);
        }
        if(type == 3){
            TableView<BigClass> table = new TableView<>();
            table.setMaxHeight(275);
            TableColumn oneCol = new TableColumn("ID");
            // firstNameCol.setMinWidth(100);
            oneCol.setCellValueFactory(
                    new PropertyValueFactory<BigClass, String>("one"));
            
            TableColumn twoCol = new TableColumn("Name");
            // firstNameCol.setMinWidth(100);
            twoCol.setCellValueFactory(
                    new PropertyValueFactory<BigClass, String>("two"));

            TableColumn threeCol = new TableColumn("Specialization");
            // firstNameCol.setMinWidth(100);
            threeCol.setCellValueFactory(
                    new PropertyValueFactory<BigClass, String>("three"));

            TableColumn fourCol = new TableColumn("Salary");
            // firstNameCol.setMinWidth(100);
            fourCol.setCellValueFactory(
                    new PropertyValueFactory<BigClass, String>("four"));
            
            table.getColumns().addAll(oneCol, twoCol, threeCol, fourCol);  
            Button Nextbtn = new Button();
            Nextbtn.setText("Next");
            Nextbtn.setOnAction(event -> {
                for(int i = 0; i < maxrows; i++){
                    if(table.getItems().size() == 0)
                        break;
                    BigClass selectedItem = table.getItems().get(0);
                    table.getItems().remove(selectedItem);

                }
            });
            try{
                while(rs.next()) {
                    table.getItems().add(new BigClass(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), " "));
                }
            }
            catch(Exception e){ System.out.println(e);} 
            root.getChildren().addAll(table, Nextbtn);
            root.setAlignment(Pos.CENTER);
        }
        if(type == 4){
            TableView<BigClass> table = new TableView<>();
            table.setMaxHeight(275);
            TableColumn oneCol = new TableColumn("ID");
            // firstNameCol.setMinWidth(100);
            oneCol.setCellValueFactory(
                    new PropertyValueFactory<BigClass, String>("one"));
            
            TableColumn twoCol = new TableColumn("Name");
            // firstNameCol.setMinWidth(100);
            twoCol.setCellValueFactory(
                    new PropertyValueFactory<BigClass, String>("two"));

            table.getColumns().addAll(oneCol, twoCol);     
            Button Nextbtn = new Button();
            Nextbtn.setText("Next");
            Nextbtn.setOnAction(event -> {
                for(int i = 0; i < maxrows; i++){
                    if(table.getItems().size() == 0)
                        break;
                    BigClass selectedItem = table.getItems().get(0);
                    table.getItems().remove(selectedItem);

                }
            });   
            try{
                while(rs.next()) {
                    table.getItems().add(new BigClass(rs.getString(1), rs.getString(2), " ", " ", " "));
                }
            }
            catch(Exception e){ System.out.println(e);} 
            root.getChildren().addAll(table, Nextbtn);
            root.setAlignment(Pos.CENTER);
        }
        if(type == 5){
            TableView<BigClass> table = new TableView<>();
            table.setMaxHeight(275);
            TableColumn oneCol = new TableColumn("Tier Name");
            // firstNameCol.setMinWidth(100);
            oneCol.setCellValueFactory(
                    new PropertyValueFactory<BigClass, String>("one"));
            
            TableColumn twoCol = new TableColumn("Count(id)");
            // firstNameCol.setMinWidth(100);
            twoCol.setCellValueFactory(
                    new PropertyValueFactory<BigClass, String>("two"));

            table.getColumns().addAll(oneCol, twoCol); 
            Button Nextbtn = new Button();
            Nextbtn.setText("Next");
            Nextbtn.setOnAction(event -> {
                for(int i = 0; i < maxrows; i++){
                    if(table.getItems().size() == 0)
                        break;
                    BigClass selectedItem = table.getItems().get(0);
                    table.getItems().remove(selectedItem);

                }
            });       
            try{
                while(rs.next()) {
                    table.getItems().add(new BigClass(rs.getString(1), rs.getString(2), " ", " ", " "));
                }
            }
            catch(Exception e){ System.out.println(e);} 
            root.getChildren().addAll(table, Nextbtn);
            root.setAlignment(Pos.CENTER);
        }
        

        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }
    @Override
    public void start(Stage primaryStage) {
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306","root",db_password);  
            //here sonoo is database name, root is username and password  
            Statement stmt=con.createStatement(); 
            String create_database = "CREATE DATABASE sonoo;";
            stmt.executeUpdate(create_database);
            String usedb = "USE sonoo;";
            stmt.executeUpdate(usedb);


            String members = "CREATE TABLE IF NOT EXISTS Members ("+
                            "id varchar(10)," + 
                            "Name varchar(40),"+ 
                            "Date_Joined Date," +  
                             "Tier_Name varchar(40)," +
                             "Trainer_id varchar(40)," + 
                             "PRIMARY KEY(id)," + 
                             "FOREIGN KEY(Tier_Name) REFERENCES Tiers(Name)," +
                             "FOREIGN Key(Trainer_id) REFERENCES Trainers(Emp_id));" ;
            String tiers = "CREATE TABLE IF NOT EXISTS Tiers (" +
                                "Name varchar(40)," +
                                "Cost int," +
                                "CHECK(Cost > 0),"+
                                "PRIMARY KEY(Name)"+
                                ");";
            String employees = "CREATE TABLE IF NOT EXISTS Employees("+
                                "id varchar(20),"+
                                "Name varchar(20),"+
                                "Date_Joined Date,"+
                                "Salary Int,"+
                                "PRIMARY KEY(id),"+
                                "CHECK(Salary > 0)"+
                                ");";
            String payments = "CREATE TABLE IF NOT EXISTS Payments("+
                                "id varchar(20),"+
                                "Date_Paid Date,"+
                                "Member_id varchar(20),"+
                                "Amount int,"+
                                "PRIMARY KEY(id),"+
                                "FOREIGN KEY(Member_id) REFERENCES Members(id),"+
                                "CHECK(Amount > 0)"+
                                ");";
            String trainers = "CREATE TABLE IF NOT EXISTS Trainers (" +
                                "Emp_id varchar(20),"+
                                "Specialization varchar(20),"+
                                "PRIMARY KEY(Emp_id),"+
                                "FOREIGN KEY(Emp_id) REFERENCES Employees(id));";
            try{
               stmt.executeUpdate(employees);
            }
            catch(Exception e){
                System.out.println(e);
                // showPopup(e.getMessage());
                // showPopup("Incorrect values. Try again");
            }
            try{
                stmt.executeUpdate(tiers) ;
            }
            catch(Exception e){
                System.out.println(e);
            }
            try{
                stmt.executeUpdate(trainers);
            }
            catch(Exception e){
                System.out.println(e);
            }
            try{
                stmt.executeUpdate(members); 
            }
            catch(Exception e){
                System.out.println(e);
            }
            try{
                stmt.executeUpdate(payments);
            }
            catch(Exception e){
                System.out.println(e);
            }
            con.close(); 
        }
        catch(Exception e){ System.out.println(e);}  
        primaryStage.setTitle("Gym Managment");
        Label MainLabel = new Label("Gym Managment");
        MainLabel.setFont(Font.font("Cambria", 32));
        // MainLabel.setX
        Button btnAddMember = new Button("Add member");
        Button btnAddTrainer = new Button("Add Trainer");
        Button btnAddEmployee = new Button("Add Employee");
        Button btnAddPayment = new Button("Add Payment");
        Button btnAddTier = new Button("Add Tier");

        btnAddMember.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{  
                    displayAddMember();
                }
                catch(Exception e){ System.out.println(e);}  
            }
        });
        btnAddTrainer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{  
                    displayAddTrainer();
                }
                catch(Exception e){ System.out.println(e);}  
            }
        });
        btnAddEmployee.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{  
                    displayAddEmployee();
                }
                catch(Exception e){ System.out.println(e);}  
            }
        });
        btnAddPayment.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{  
                    displayAddPayment();
                }
                catch(Exception e){ System.out.println(e);}  
            }
        });
        btnAddTier.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // System.out.println("Hello World!");
                try{  
                    displayAddTier();
                }
                catch(Exception e){ System.out.println(e);}  
            }
        });

        Button btnShowX = new Button("Show x");

        btnShowX.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{  
                    displaySpecificX();
                }
                catch(Exception e){ System.out.println(e);}  
            }
        });

        Button btnDeleteX = new Button("Delete x");

        btnDeleteX.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{  
                    deleteSpecificX();
                }
                catch(Exception e){ System.out.println(e);}  
            }
        });

        //------//
        Button btnC1 = new Button("All members since X who are paying more than Y");
        btnC1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{  
                    processXY(1, 2);
                }
                catch(Exception e){ System.out.println(e);}  
            }
        });

        Button btnC2= new Button("Members who haven't paid since X");
        btnC2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{  
                    processXY(2, 1);
                }
                catch(Exception e){ System.out.println(e);}  
            }
        });

        Button btnC3 = new Button("Trainers specializing in X and have salary >= Y");
        btnC3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{  
                    processXY(3, 2);
                }
                catch(Exception e){ System.out.println(e);}  
            }
        });

        Button btnC4 = new Button("Get the average salary for each trainer specialization");
        btnC4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{  
                    Class.forName("com.mysql.jdbc.Driver");  
                    Connection con=DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/sonoo?useSSL=false","root",db_password);  
                    //here sonoo is database name, root is username and password  
                    Statement stmt=con.createStatement(); 
                    String w;
                    ResultSet rs;
                    w = "SELECT Specialization, AVG(Salary) FROM Trainers, Employees WHERE Emp_id = id GROUP BY Specialization;";
                    try{
                       rs = stmt.executeQuery(w);  
                       displaySpecificComplex(rs, 4);

                    }
                    catch(Exception e){
                        // System.out.println(e);
                        showPopup(e.getMessage());
                        // showPopup("Incorrect values. Try again");
                    }
                    con.close(); 
                }
                catch(Exception e){ System.out.println(e);}             }
        });

        Button btnC5 = new Button("Show the number of members in each tier");
        btnC5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{  
                    Class.forName("com.mysql.jdbc.Driver");  
                    Connection con=DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/sonoo?useSSL=false","root",db_password);  
                    //here sonoo is database name, root is username and password  
                    Statement stmt=con.createStatement(); 
                    String w;
                    ResultSet rs;
                    w = "SELECT Tier_Name, COUNT(id) FROM Members, Tiers WHERE Tier_Name = Tiers.Name GROUP BY Tier_Name;";
                    try{
                       rs = stmt.executeQuery(w);  
                       displaySpecificComplex(rs, 5);

                    }
                    catch(Exception e){
                        // System.out.println(e);
                        showPopup(e.getMessage());
                        // showPopup("Incorrect values. Try again");
                    }
                    con.close(); 
                }
                catch(Exception e){ System.out.println(e);} 
            }
        });
        VBox te = new VBox();
        
        FlowPane add = new FlowPane();
        add.getChildren().addAll(btnAddMember, btnAddEmployee, btnAddPayment, btnAddTrainer, btnAddTier);
        FlowPane small = new FlowPane();
        small.getChildren().addAll(btnShowX, btnDeleteX);
        te.getChildren().addAll(btnC1, btnC2, btnC3, btnC4, btnC5);
        MainLabel.setTranslateX(350);
        add.setTranslateX(250);
        small.setTranslateX(400);
        VBox root = new VBox();
        te.setTranslateX(300);
        te.setSpacing(10);
        root.setSpacing(10);
        root.getChildren().addAll(MainLabel, add, small, te);
        primaryStage.setScene(new Scene(root, 1000, 400));
        primaryStage.show();
    }
}  