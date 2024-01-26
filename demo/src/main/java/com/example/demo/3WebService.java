import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CarAvailabilityService {

    @Autowired
    private RestTemplate restTemplate;

    private final String carRentalServiceUrl = "http://localhost:8080"; // Remplacez l'URL par celle de votre service

    @GetMapping("/voitures")
    public List<Car> getAvailableCars() {
        String url = carRentalServiceUrl + "/cars";
        Car[] cars = restTemplate.getForObject(url, Car[].class);
        return Arrays.asList(cars);
    }

    /**
	 * http://localhost:8080/voitures/11AA22
	 * @param plateNumber
	 * @return
	 */

    @DeleteMapping("/voitures/{plateNumber}")
	public void delete(@PathVariable String plateNumber) {
        String url = carRentalServiceUrl + "/voitures/" + plateNumber;
        restTemplate.delete(url);
	}
}