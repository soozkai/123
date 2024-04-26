package com.example.cab302_week9;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

public class BrowserController {

    @FXML
    private TabPane browserTabPane;
    @FXML
    private TextField urlTextField;

    @FXML
    private void loadPage() {
        String url = urlTextField.getText();
        addNewTab("New Tab", url);
    }

    @FXML
    private void handleAddTab() {
        // Only add a new tab if the "+" tab is selected
        if (browserTabPane.getSelectionModel().getSelectedItem().getText().equals("+")) {
            addNewTab("New Tab", "http://example.com");
            browserTabPane.getSelectionModel().select(browserTabPane.getTabs().size() - 2);
        }
    }

    private void addNewTab(String title, String url) {
        WebView webView = new WebView();
        webView.getEngine().load(url);

        Tab newTab = new Tab(title);
        newTab.setContent(webView);
        browserTabPane.getTabs().add(browserTabPane.getTabs().size() - 1, newTab);
    }
}
