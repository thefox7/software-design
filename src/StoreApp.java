import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.geometry.Pos;

import java.util.Map;
import java.util.HashMap;

import models.Product;
import models.ProductFactory;
import models.Cart;

public class StoreApp extends Application {

    private Cart cart;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Initialize the cart instance
        cart = Cart.getInstance();

        // Initialize product factory
        ProductFactory productFactory = new ProductFactory();

        // Create main store window layout (centered content)
        VBox mainLayout = new VBox(20);
        mainLayout.setAlignment(Pos.CENTER);  // Center everything in the VBox

        // Title
        Label storeTitle = new Label("Welcome to the Online Store!");
        storeTitle.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;"); // Styling title

        // Create buttons for the products
        Button buyLaptopButton = new Button("Buy Laptop - $999");
        Button buySmartphoneButton = new Button("Buy Smartphone - $499");
        Button viewCartButton = new Button("View Cart");

        // Styling buttons
        buyLaptopButton.setStyle("-fx-font-size: 16px; -fx-padding: 10px;");
        buySmartphoneButton.setStyle("-fx-font-size: 16px; -fx-padding: 10px;");
        viewCartButton.setStyle("-fx-font-size: 16px; -fx-padding: 10px;");

        // Set action for product buttons to add products to the cart
        buyLaptopButton.setOnAction(event -> {
            Product laptop = productFactory.createLaptop();
            cart.addItem(laptop.getName());
            System.out.println(laptop.getName() + " added to cart!");
        });

        buySmartphoneButton.setOnAction(event -> {
            Product smartphone = productFactory.createSmartphone();
            cart.addItem(smartphone.getName());
            System.out.println(smartphone.getName() + " added to cart!");
        });

        // Set action for View Cart button to show cart details in a popup
        viewCartButton.setOnAction(event -> openCartPopup(primaryStage));

        // Add title and buttons to the main layout
        mainLayout.getChildren().addAll(storeTitle, buyLaptopButton, buySmartphoneButton, viewCartButton);

        // Create the main scene with a bigger window size
        Scene mainScene = new Scene(mainLayout, 600, 400); // Adjust window size (width, height)
        primaryStage.setTitle("Online Store");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    // Method to open the Cart popup window
    private void openCartPopup(Stage primaryStage) {
        // Create a new stage (window) for the cart
        Stage cartPopupStage = new Stage();
        cartPopupStage.initModality(Modality.APPLICATION_MODAL);  // Makes sure the popup is modal
        cartPopupStage.setTitle("Your Cart");

        // Create a layout for the cart popup
        VBox cartLayout = new VBox(10);
        cartLayout.setAlignment(Pos.CENTER);  // Center elements in the cart popup

        // Label for cart title
        Label cartTitle = new Label("Items in Your Cart:");
        cartTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Create a list view to show items and their quantities
        VBox cartDetails = new VBox(5);

        // Populate cart details
        for (Map.Entry<String, Integer> entry : cart.getItems().entrySet()) {
            // Create a row for each item with a label and a remove button
            HBox itemRow = new HBox(10);
            Label itemLabel = new Label(entry.getKey() + " x" + entry.getValue());
            Button removeButton = new Button("Remove");
            removeButton.setStyle("-fx-font-size: 12px; -fx-padding: 5px;");

            // Set action for remove button
            removeButton.setOnAction(event -> {
                cart.removeItem(entry.getKey()); // Remove the product from the cart
                cartPopupStage.close(); // Close the current popup
                openCartPopup(primaryStage); // Refresh and open the cart again
            });

            itemRow.getChildren().addAll(itemLabel, removeButton);
            cartDetails.getChildren().add(itemRow);
        }

        // Create a scroll pane to hold the cart details
        ScrollPane scrollPane = new ScrollPane(cartDetails);
        scrollPane.setPrefHeight(250);  // Set the preferred height for the scroll pane
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        // Button to close the cart popup
        Button closeButton = new Button("Close");
        closeButton.setStyle("-fx-font-size: 14px; -fx-padding: 10px;");
        closeButton.setOnAction(event -> cartPopupStage.close()); // Close the popup

        // Add all elements to the cart layout
        cartLayout.getChildren().addAll(cartTitle, scrollPane, closeButton);

        // Create and set the scene for the cart popup window
        Scene cartPopupScene = new Scene(cartLayout, 400, 500); // Adjust popup window size
        cartPopupStage.setScene(cartPopupScene);

        // Show the cart popup window
        cartPopupStage.show();
    }
}
