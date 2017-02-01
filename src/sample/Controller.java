package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    private ChatClient client;

    @FXML
    private TextArea incoming;

    @FXML
    private Button sendBtn;

    @FXML
    private TextField outgoing;
    @FXML
    private void sendBtnClick(ActionEvent event){
        if (!outgoing.getText().equals("")) {
            client.sendMessage(outgoing.getText());
            outgoing.setText("");
        }
            outgoing.requestFocus();



    }

    public TextArea getIncomingTextArea(){
        return incoming;
    }

    public void setClient(ChatClient client) {
        this.client = client;
    }

}
