package br.albatross.open.vnc;

import br.albatross.open.vnc.connections.Connection;
import br.albatross.open.vnc.builders.ConnectionBuilder;
import br.albatross.open.vnc.builders.SsVncConnectionBuilder;
import br.albatross.open.vnc.builders.VncConnectionBuilder;
import br.albatross.open.vnc.starters.ConnectionStarter;
import br.albatross.open.vnc.starters.VNCConnectionStarter;

import static java.awt.Desktop.getDesktop;

import java.io.IOException;

import java.net.URI;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;

public class MainController {

    /**
     * Represents the text field in the GUI, where users type the IP or
     * Hostname.
     */
    @FXML
    private TextField host;

    /**
     * Represents the Host-Radio-Button group in the GUI. This group of radio
     * buttons is used so that users can select only ONE button.
     */
    @FXML
    private ToggleGroup host_radio_button;

    /**
     * Represents connect button in the GUI's.
     */
    @FXML
    private Button connectBtn;

    /**
     * Represents the github hyperlink in the left conner of the GUI.
     */
    @FXML
    private Hyperlink githubLink;

    /**
     * Represents connection user name, that is recovered by the "user.name"
     * System Property. Basically, the current logged user.
     */
    private final String userName = System.getenv("VNC_USER");
    private final String password = System.getenv("domain_password");

    private static final String OS_NAME = System.getProperty("os.name");

    private ConnectionBuilder builder;
    
    /**
     * Triggers the startConnection() when "Connect" button is clicked or ENTER
     * key is pressed.
     *
     * @param btnClicked
     */
    @FXML
    private void connectBtnClicked(ActionEvent btnClicked) {
        startConnection();
    }

    /**
     * Triggers the Builder and Starter components to build and start a VNC
     * Connection.
     * 
     * If the target platform is Windows® VncConnection Builder will be created.
     * IF it's a Linux, a SSVNC will be created.
     * 
     */
    private void startConnection() {

        builder = (OS_NAME.contains("Windows")) ? builder = new VncConnectionBuilder() : new SsVncConnectionBuilder();

        Connection connection = builder.createConnection(host.getText(), userName, password);
        ConnectionStarter starter = new VNCConnectionStarter(builder);

        starter.startConnection(connection);

    }

    /**
     * Triggers the startConnection() when ENTER key is pressed.
     *
     * @param keyPressed
     */
//    private void hostConnectWhenEnterKeyPressed(KeyEvent keyPressed) {
//        if (keyPressed.getCode().equals(KeyCode.ENTER)) {
//            startConnection();
//        }
//
//    }
    /**
     * Re enables the Connect button, in the GUI, if the host text field is not
     * empty.
     *
     * @param keyType
     */
//    private void enableConnectBtn(KeyEvent keyType) {
//        if (host.getText().length() > 0) {
//            host.setDisable(false);
//        }
//    }
    /**
     * Redirects the user to the Github Project Creator's page.
     *
     * @param mouseClick when the link gets clicked by the user.
     * @throws IOException if URI is wrong or inacessible.
     * @throws URISyntaxException if URI os wrong.
     */
    @FXML
    private void githubLinkClicked(ActionEvent mouseClick) throws IOException, URISyntaxException {
        getDesktop().browse(new URI("https://github.com/brenoyure"));
        githubLink.setVisited(false);
        host.requestFocus();
        host.forward();

    }

    /**
     * If host/ip text field is empty, this method will disable the Connect
     * Button in the GUI.
     *
     * @param keyType keys being typed.
     */
    @FXML
    private void hostBeingTyped(KeyEvent keyType) {
        if (host.getText().isEmpty() || host.getText().trim() == "") {
            connectBtn.setDisable(true);
        } else {
            connectBtn.setDisable(false);
        }
    }

    @FXML
    private void andarTerroRadioBtnClicked(ActionEvent event) {
        host.setText("10.40.10.");
        host.requestFocus();
        host.forward();

    }

    @FXML
    private void primeiroAndarRadioBtnClicked(ActionEvent event) {
        host.setText("10.40.1.");
        host.requestFocus();
        host.forward();
    }

    @FXML
    private void quartoAndarRadioBtnClicked(ActionEvent event) {
        host.setText("10.40.4.");
        host.requestFocus();
        host.forward();
    }

    @FXML
    private void quintoAndarRadioBtnClicked(ActionEvent event) {
        host.setText("10.40.5.");
        host.requestFocus();
        host.forward();
    }

    @FXML
    private void sextoAndarRadioBtnClicked(ActionEvent event) {
        host.setText("10.40.6.");
        host.requestFocus();
        host.forward();
    }

    @FXML
    private void setimoAndarRadioBtnClicked(ActionEvent event) {
        host.setText("10.40.7.");
        host.requestFocus();
        host.forward();
    }

    @FXML
    private void oitavoAndarRadioBtnClicked(ActionEvent event) {
        host.setText("10.40.8.");
        host.requestFocus();
        host.forward();
    }

    @FXML
    private void nonoAndarRadioBtnClicked(ActionEvent event) {
        host.setText("10.40.9.");
        host.requestFocus();
        host.forward();
    }

    @FXML
    private void maquinaDellRadioBtnClicked(ActionEvent event) {
        host.setText("W142");
        host.requestFocus();
        host.forward();
    }

    @FXML
    private void maquinaSpaceBRRadioBtnClicked(ActionEvent event) {
        host.setText("W145");
        host.requestFocus();
        host.forward();
    }

    @FXML
    private void maquinaHPRadioBtnClicked(ActionEvent event) {
        host.setText("W200");
        host.requestFocus();
        host.forward();
    }

    @FXML
    private void maquinaDatenRadioBtnClicked(ActionEvent event) {
        host.setText("W204");
        host.requestFocus();
        host.forward();
    }

}
