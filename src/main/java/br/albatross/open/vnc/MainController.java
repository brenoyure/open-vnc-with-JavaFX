package br.albatross.open.vnc;

import static br.albatross.open.vnc.configurations.AvailableProperties.IS_LINUX_OS;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;

import br.albatross.open.vnc.builders.ConnectionBuilder;
import br.albatross.open.vnc.builders.VncConnectionBuilder;
import br.albatross.open.vnc.configurations.AvailableHosts;
import br.albatross.open.vnc.services.GuiService;
import br.albatross.open.vnc.services.configurations.Configuration;
import br.albatross.open.vnc.services.configurations.VncConfigurationService;
import br.albatross.open.vnc.starters.ConnectionStarter;
import br.albatross.open.vnc.starters.VncConnectionStarter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;

public class MainController {

    private ConnectionBuilder connectionBuilder;
    private ConnectionStarter connectionStarter;

    private Configuration configuration;

    private GuiService service;

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

    @FXML
    private Hyperlink changePasswordLink;

    public MainController() {

    	if (service == null) {
    		service = new GuiService();
    	}

    	if (configuration == null) {

    		configuration = new VncConfigurationService();

    	}
    	
    }

    /**
     * Triggers the Builder and Starter components to build and start a VNC
     * Connection.
     * 
     * If the target platform is Windows® VncConnection Builder will be created.
     * IF it's a Linux, a SSVNC will be created.
     *
     * @param btnClicked
     */
    @FXML
    public void connectBtnClicked(ActionEvent btnClicked) {

    	if (connectionBuilder == null) {
    		connectionBuilder = new VncConnectionBuilder();
    	}
    	
    	if (connectionStarter == null) {
    		connectionStarter = new VncConnectionStarter();
    	}

        connectionStarter
        	.startConnection(connectionBuilder
        			.createConnection(host.getText(), configuration.getUser(), configuration.getPassword()));

    }

    @FXML
    private void changePasswordLinkClicked(ActionEvent event) throws IOException {

       if (IS_LINUX_OS) {
           changePasswordLink.setDisable(true);
           changePasswordLink.setVisited(false);
           JOptionPane.showMessageDialog(null, "Opção ainda não disponível no Linux.", "Opção Não Disponivel", JOptionPane.WARNING_MESSAGE);
           changePasswordLink.setText("Opção Atualmente Indisponível");
           return;
       }

       App.setRoot("configurations");

    }

    /**
     * Redirects the user to the Github Project Creator's page.
     *
     * @param mouseClickEvent when the link gets clicked by the user.
     * @throws IOException if URI is wrong or inacessible.
     * @throws URISyntaxException if URI os wrong.
     */
    @FXML
    private void githubLinkClicked(ActionEvent mouseClickEvent) throws IOException, URISyntaxException {

       service.handleGitHubClickEvent(mouseClickEvent, host);

    }

    /**
     * If host/ip text field is empty, this method will disable the Connect
     * Button in the GUI.
     *
     * @param keyType keys being typed.
     */
    @FXML
    private void hostBeingTyped(KeyEvent keyType) {

        if (host.getText().isBlank()) {
            connectBtn.setDisable(true);
            return;

        }

        connectBtn.setDisable(false);

    }

    private void handleHostRadioButtonClick(ActionEvent event, String hostnameOrIp) {
        service.handleHostRadioButtonClick(host, event, hostnameOrIp);
        connectBtn.setDisable(true);
    }

    @FXML
    private void andarTerroRadioBtnClicked(ActionEvent event) {
        handleHostRadioButtonClick(event, AvailableHosts.HOST_ANDAR_TERREO_TEMPLATE);
    }

    @FXML
    private void primeiroAndarRadioBtnClicked(ActionEvent event) {
        handleHostRadioButtonClick(event, AvailableHosts.HOST_PRIMEIRO_ANDAR_TEMPLATE);
    }

    @FXML
    private void segundoAndarRadioBtnClicked(ActionEvent event) {
        handleHostRadioButtonClick(event, AvailableHosts.HOST_SEGUNDO_ANDAR_TEMPLATE);
    }

    @FXML
    private void terceiroAndarRadioBtnClicked(ActionEvent event) {
        handleHostRadioButtonClick(event, AvailableHosts.HOST_TERCEIRO_ANDAR_TEMPLATE);
    }

    @FXML
    private void quartoAndarRadioBtnClicked(ActionEvent event) {
        handleHostRadioButtonClick(event, AvailableHosts.HOST_QUARTO_ANDAR_TEMPLATE);
    }

    @FXML
    private void quintoAndarRadioBtnClicked(ActionEvent event) {
        handleHostRadioButtonClick(event, AvailableHosts.HOST_QUINTO_ANDAR_TEMPLATE);
    }

    @FXML
    private void sextoAndarRadioBtnClicked(ActionEvent event) {
        handleHostRadioButtonClick(event, AvailableHosts.HOST_SEXTO_ANDAR_TEMPLATE);
    }

    @FXML
    private void setimoAndarRadioBtnClicked(ActionEvent event) {
        handleHostRadioButtonClick(event, AvailableHosts.HOST_SETIMO_ANDAR_TEMPLATE);
    }

    @FXML
    private void oitavoAndarRadioBtnClicked(ActionEvent event) {
        handleHostRadioButtonClick(event, AvailableHosts.HOST_OITAVO_ANDAR_TEMPLATE);
    }

    @FXML
    private void nonoAndarRadioBtnClicked(ActionEvent event) {
        handleHostRadioButtonClick(event, AvailableHosts.HOST_NONO_ANDAR_TEMPLATE);
    }

    @FXML
    private void maquinaDellRadioBtnClicked(ActionEvent event) {
        handleHostRadioButtonClick(event, AvailableHosts.HOST_MAQUINA_DELL_TEMPLATE);
    }

    @FXML
    private void maquinaSpaceBRRadioBtnClicked(ActionEvent event) {
        handleHostRadioButtonClick(event, AvailableHosts.HOST_MAQUINA_SPACEBR_TEMPLATE);
    }

    @FXML
    private void maquinaHPRadioBtnClicked(ActionEvent event) {
        handleHostRadioButtonClick(event, AvailableHosts.HOST_MAQUINA_HP_TEMPLATE);
    }

    @FXML
    private void maquinaDatenRadioBtnClicked(ActionEvent event) {
        handleHostRadioButtonClick(event, AvailableHosts.HOST_MAQUINA_DATEN_TEMPLATE);
    }

    @FXML
    private void casaAmarelaTransporteRadioBtnClicked(ActionEvent event) {
        handleHostRadioButtonClick(event, AvailableHosts.HOST_CASA_AMARELA_TRANSPORTE_TEMPLATE);
    }

    @FXML
    private void suporteRadioBtnClicked(ActionEvent event) {
        handleHostRadioButtonClick(event, AvailableHosts.HOST_REDE_50_TEMPLATE);
    }

}
