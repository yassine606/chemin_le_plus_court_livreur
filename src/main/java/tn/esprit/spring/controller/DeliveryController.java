package tn.esprit.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.City;
import tn.esprit.spring.entities.CoordonneeCity;
import tn.esprit.spring.entities.Delivery;
import tn.esprit.spring.entities.DeliveryMan;
import tn.esprit.spring.service.IDeliveryService;


@RestController

public class DeliveryController {

	@Autowired
	IDeliveryService iDeliveryService;

	@GetMapping("/get-all-deliveries")
	@ResponseBody
	public List<Delivery> getDeliveries() {
		List<Delivery> list = iDeliveryService.getAllDeliveries();
		return list;
	}

	@GetMapping("/get-delivery/{delivery-id}")
	@ResponseBody
	public Delivery getDelivery(@PathVariable("delivery-id") String id) {
		return iDeliveryService.getDelivery(id);
	}

	

	@DeleteMapping("/remove-delivery/{delivery-id}")
	@ResponseBody
	public void removeDeliveryr(@PathVariable("delivery-id") String id) {
		iDeliveryService.deleteDelivery(id);
	}
	
	
	@PostMapping("/add-delivery")
	@ResponseBody
	public Delivery addDelivery(@RequestBody Delivery d) {
		return iDeliveryService.addDelivery(d);
	}
	
	@GetMapping("/get-min-distance")
	@ResponseBody
	public double getMinDistance(@RequestParam("lat1") double lat1,
			@RequestParam("lon1") double lon1) 
	{
		CoordonneeCity c1 = new CoordonneeCity(36.8689216,10.1353404);
		CoordonneeCity c2 = new CoordonneeCity(36.7465169,10.2171373);
		CoordonneeCity c3 = new CoordonneeCity(37.2811363,9.8264848);
		CoordonneeCity c4 = new CoordonneeCity(36.729743,9.1700926);
		CoordonneeCity c5 =  new CoordonneeCity(36.1668945,8.6848115);
	    ArrayList<CoordonneeCity> coords = new ArrayList<CoordonneeCity>();
	    coords.add(c1);
	    coords.add(c2);
	    coords.add(c3);
	    coords.add(c4);
	    coords.add(c5);
	    double minDist = distance(lat1, c1.getLatitude(), lon1, c1.getLongitude(), 0, 0);
		for (CoordonneeCity coordonneeCity : coords) {
			double dist = distance(lat1, coordonneeCity.getLatitude(), lon1, coordonneeCity.getLongitude(), 0, 0);
			if(dist < minDist){
				minDist = dist;
			}
		}
		return minDist/1000;
	}
	
	
	
	/**
	 * Calculate distance between two points in latitude and longitude taking
	 * into account height difference. If you are not interested in height
	 * difference pass 0.0. Uses Haversine method as its base.
	 * 
	 * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
	 * el2 End altitude in meters
	 * @returns Distance in Meters
	 */
	public static double distance(double lat1, double lat2, double lon1,
	        double lon2, double el1, double el2) {

	    final int R = 6371; // Radius of the earth

	    double latDistance = Math.toRadians(lat2 - lat1);
	    double lonDistance = Math.toRadians(lon2 - lon1);
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters

	    double height = el1 - el2;

	    distance = Math.pow(distance, 2) + Math.pow(height, 2);

	    return Math.sqrt(distance);
	}
	
	
	
	
	
	
	
	
	
	
	
}
