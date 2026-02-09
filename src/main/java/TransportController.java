import com.google.gson.Gson;
import static spark.Spark.*;

public class TransportController {
    public static void main(String[] args) {
        BusDAO busDAO = new BusDAO();
        Gson gson = new Gson();

        port(4567);

        get("/api/buses", (req, res) -> {
            res.type("application/json");
            return busDAO.getAllBuses();
        }, gson::toJson);

        get("/api/buses/:plate", (req, res) -> {
            String plate = req.params(":plate");
            Bus bus = busDAO.searchByPlate(plate);
            res.type("application/json");
            if (bus != null) {
                return bus;
            } else {
                res.status(404);
                return "{\"error\": \"Bus not found\"}";
            }
        }, gson::toJson);

        post("/api/buses", (req, res) -> {
            res.type("application/json");

            Bus newBus = gson.fromJson(req.body(), Bus.class);

            boolean success = busDAO.insertBus(newBus);

            if (success) {
                res.status(201);
                return "{\"status\": \"success\", \"message\": \"Bus " + newBus.getPlate_num() + " added!\"}";
            } else {
                res.status(400);
                return "{\"status\": \"error\", \"message\": \"Failed to add bus\"}";
            }
        });

        delete("/api/buses/:plate", (req, res) -> {
            String plate = req.params(":plate");
            boolean success = busDAO.deleteBus(plate);
            res.type("application/json");
            if (success) {
                return "{\"status\": \"success\", \"message\": \"Bus " + plate + " deleted!\"}";
            } else {
                res.status(404);
                return "{\"status\": \"error\", \"message\": \"Bus not found\"}";
            }
        });

        put("/api/buses/:plate", (req, res) -> {
            String plate = req.params(":plate");
            Bus updatedBus = gson.fromJson(req.body(), Bus.class);
            updatedBus.setPlate_num(plate);

            Bus existingBus = busDAO.searchByPlate(plate);
            if (existingBus == null) {
                res.status(404);
                return "{\"status\": \"error\", \"message\": \"Bus not found\"}";
            }

            boolean success = busDAO.updateBus(updatedBus);
            res.type("application/json");

            if (success) {
                return "{\"status\": \"success\", \"message\": \"Bus " + plate + " updated!\"}";
            } else {
                res.status(500);
                return "{\"status\": \"error\", \"message\": \"Failed to update bus\"}";
            }
        });

        System.out.println("API is live! Visit: http://localhost:4567/api/buses");
    }
}
