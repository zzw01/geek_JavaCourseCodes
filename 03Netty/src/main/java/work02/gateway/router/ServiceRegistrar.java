package work02.gateway.router;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class ServiceRegistrar {

    Map<String, LinkedHashSet<String>> serviceUrlMap = new HashMap<>();

    public void registerService(String serviceName, String serviceUrl) {
        LinkedHashSet<String> urls = serviceUrlMap.get(serviceName);
        if (urls == null) {
            urls = new LinkedHashSet<>();
        }
        urls.add(serviceUrl);
        serviceUrlMap.put(serviceName, urls);
    }

    public LinkedHashSet<String> getUrlSet(String serviceName) {
        return serviceUrlMap.get(serviceName);
    }

}