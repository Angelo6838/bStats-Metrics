import com.google.inject.Inject;
import org.bstats.sponge.Metrics2;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;

@Plugin(id = "10177", name = "WorldX", version = "1.0")
public class WorldX {

    private final Metrics2 metrics;

    // The metricsFactory parameter gets injected using @Inject :)
    // Check out https://docs.spongepowered.org/master/en/plugin/injection.html if you don't know what @Inject does
    @Inject
    public WorldX(Metrics2.Factory metricsFactory) {
        // You can find the plugin ids of your plugins on the page https://bstats.org/what-is-my-plugin-id
        int pluginId = 10177; // <-- Replace with the id of your plugin!
        metrics = metricsFactory.make(pluginId);
    }

    // Optional: Add custom charts
    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        metrics.addCustomChart(new Metrics2.SimplePie("chart_id", () -> "My value"));
    }

}
