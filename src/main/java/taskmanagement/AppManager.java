package taskmanagement;

import taskmanagement.controllers.StatusUpdateService;
import taskmanagement.models.Calendar;
import taskmanagement.models.Day;
import taskmanagement.models.Task;
import javafx.concurrent.Worker;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class AppManager {
    public static Stage stage;
    public static Scene mainWindow;
    public static Calendar calendar;
    public static Day selectedDay;
    public static Task selectedTask;

    // Giữ duy nhất instance service
    private static final StatusUpdateService statusUpdateService = new StatusUpdateService();

    // Khởi động service MỘT LẦN
    public static void startStatusService() {
        if (statusUpdateService.getState() == Worker.State.READY) {
            statusUpdateService.start();
        } else if (statusUpdateService.getState() == Worker.State.CANCELLED) {
            statusUpdateService.reset();
            statusUpdateService.start();
        }
    }

    // Dừng service MỘT LẦN
    public static void stopStatusService() {
        if (statusUpdateService.isRunning()) {
            statusUpdateService.cancel();
        }
    }

    public static void switchToDayWindow() throws IOException {
        startStatusService();
        loadAndSetScene("/Fxml/day-window.fxml");
    }

    public static void switchToPomodoroWindow() throws IOException {
        stopStatusService();
        loadAndSetScene("/Fxml/pomodoro-window.fxml");
    }

    public static void switchToMainWindow() {
        stopStatusService();
        stage.setScene(mainWindow);
        stage.show();
    }

    private static void loadAndSetScene(String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(AppManager.class.getResource(fxmlPath));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
