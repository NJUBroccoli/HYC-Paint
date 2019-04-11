package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import main.GP;

public class LeftConfig {

    public static ListView<Integer> listView = new ListView<>();

    public static void config(BorderPane root){
        listView.setEditable(false);
        listView.setCellFactory((ListView<Integer> l) -> new GraphView());
        listView.setItems(GP.graphList);
        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (listView.getSelectionModel() != null){
                    GP.drawing = false;
                    GP.chosenPoints.clear();
                    ToolConfig.chooseButton.setSelected(true);
                }
            }
        });
        root.setLeft(listView);
    }
}