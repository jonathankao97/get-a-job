import java.io.*;
import java.util.*;

public class SubdomainVisits811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> visits = new HashMap<>();
        for (String domain : cpdomains) {
            String[] split = domain.split(" ");
            int count = Integer.parseInt(split[0]);
            List<String> subDomains = generateSubdomains(split[1].split("\\."));
            for (String subDomain : subDomains) {
                visits.put(subDomain, visits.getOrDefault(subDomain, 0) + count);
            }
        }
        List<String> soln = new ArrayList<>();
        for (String visited : visits.keySet()) {
            soln.add(visits.get(visited) + " " + visited);
        }
        return soln;
    }

    public List<String> generateSubdomains(String[] subDomains) {
        List<String> soln = new ArrayList<>();
        for (int i = 0; i < subDomains.length; i++) {
            String s = subDomains[i];
            for (int j = i + 1; j < subDomains.length; j++) {
                s += "." + subDomains[j];
            }
            soln.add(s);
        }
        return soln;
    }
}