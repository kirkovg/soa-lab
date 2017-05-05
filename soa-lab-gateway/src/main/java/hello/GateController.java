package hello;

//import com.netflix.discovery.DiscoveryClient;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;


@RestController
public class GateController {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;


    @RequestMapping("/clients")
    public List<ServiceInstance> clients(@RequestParam(value = "name") String name) {
        return this.discoveryClient.getInstances(name);
    }


    @RequestMapping(value = "/findScoresAndLeagues", method = RequestMethod.GET)
    public String findScoresAndLeagues() {
        Random rnd = new Random();

        //141021-score-app
        List<ServiceInstance> services1 = discoveryClient.getInstances("141021-score-app");
        EurekaDiscoveryClient.EurekaServiceInstance service1 = (EurekaDiscoveryClient.EurekaServiceInstance) services1.get(rnd.nextInt(services1.size()));
        String ip1 = service1.getInstanceInfo().getIPAddr();
        List<String> scores = this.restTemplate.getForObject("http://" + ip1 + ":8080/api/findAllScores", List.class);

        //141021-sports-app
        List<ServiceInstance> services2 = discoveryClient.getInstances("141021-sports-app");
        EurekaDiscoveryClient.EurekaServiceInstance service2 = (EurekaDiscoveryClient.EurekaServiceInstance) services2.get(rnd.nextInt(services2.size()));
        String ip2 = service2.getInstanceInfo().getIPAddr();
        List<String> leagues = this.restTemplate.getForObject("http://" + ip2 + ":8080/api/findAllLeagues", List.class);

        return String.format("Got my answer: %s from ip %s, and my second answer: %s from ip %s", scores, ip1, leagues, ip2);
    }


    @RequestMapping(value = "/addScore", method = RequestMethod.POST)
    public String addScore(@RequestParam(value = "hostTeam") String hostTeam,
                           @RequestParam(value = "guestTeam") String guestTeam,
                           @RequestParam(value = "leagueName") String leagueName,
                           @RequestParam(value = "hostScore") Integer hostScore,
                           @RequestParam(value = "guestScore") Integer guestScore) {

        Random rnd = new Random();
        List<ServiceInstance> services1 = discoveryClient.getInstances("141021-score-app");
        EurekaDiscoveryClient.EurekaServiceInstance service1 = (EurekaDiscoveryClient.EurekaServiceInstance) services1.get(rnd.nextInt(services1.size()));
        String ip1 = service1.getInstanceInfo().getIPAddr();

        String url = "http://" + ip1 + ":8080/api/addScore";        //testing with new ports
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("hostTeam", hostTeam);
        map.add("guestTeam", guestTeam);
        map.add("leagueName", leagueName);
        map.add("hostScore", hostScore + "");
        map.add("guestScore", guestScore + "");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        return String.format("Added score with response: %s", response);
    }


    @RequestMapping(value = "/addLeague", method = RequestMethod.POST)
    public String addLeague(
            @RequestParam(value = "sportId") Long sportId,
            @RequestParam(value = "leagueName") String leagueName
    ) {

        Random rnd = new Random();
        List<ServiceInstance> services1 = discoveryClient.getInstances("141021-score-app");
        EurekaDiscoveryClient.EurekaServiceInstance service1 = (EurekaDiscoveryClient.EurekaServiceInstance) services1.get(rnd.nextInt(services1.size()));
        String ip1 = service1.getInstanceInfo().getIPAddr();

        String url = "http://" + ip1 + ":8080/api/addLeague";        //testing with new ports
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("sportId", sportId + "");
        map.add("leagueName", leagueName);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        return String.format("Added league with response: %s", response);
    }


    @RequestMapping(value = "/addSport", method = RequestMethod.POST)
    public String addSport(
            @RequestParam(value = "sportName") String sportName
    ) {

        Random rnd = new Random();
        List<ServiceInstance> services1 = discoveryClient.getInstances("141021-score-app");
        EurekaDiscoveryClient.EurekaServiceInstance service1 = (EurekaDiscoveryClient.EurekaServiceInstance) services1.get(rnd.nextInt(services1.size()));
        String ip1 = service1.getInstanceInfo().getIPAddr();

        String url = "http://" + ip1 + ":8080/api/addSport";        //testing with new ports
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("sportName", sportName);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        return String.format("Added sport with response: %s", response);
    }
}
