import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class LinkShortener {
private Map<String, String> shortToLongMap;
private Map<String, String> longToShortMap;
public LinkShortener() {
this.shortToLongMap = new HashMap<>();
this.longToShortMap = new HashMap<>();
}
public String shortenUrl(String longUrl) {
if (longToShortMap.containsKey(longUrl)) {
return longToShortMap.get(longUrl);
}
String shortUrl = generateShortUrl();
shortToLongMap.put(shortUrl, longUrl);
longToShortMap.put(longUrl, shortUrl);
return shortUrl;
}
public String expandUrl(String shortUrl) {
if (!shortToLongMap.containsKey(shortUrl)) {
throw new IllegalArgumentException("Invalid short URL");
}
return shortToLongMap.get(shortUrl);
}
private String generateShortUrl() {
// Implement a basic hash function for generating short URLs
return String.valueOf(shortToLongMap.size() + 1);
}
public static void main(String[] args) {
LinkShortener linkShortener = new LinkShortener();
Scanner scanner = new Scanner(System.in);
while (true) {
System.out.println("Enter a long URL to shorten (or 'exit' to quit):");
String input = scanner.nextLine();
if ("exit".equalsIgnoreCase(input)) {
break;
}
String shortUrl = linkShortener.shortenUrl(input);
System.out.println("Shortened URL: " + shortUrl);
System.out.println("Enter a short URL to expand (or 'exit' to quit):");
input = scanner.nextLine();
if ("exit".equalsIgnoreCase(input)) {
break;
}
try {
String expandedUrl = linkShortener.expandUrl(input);
System.out.println("Expanded URL: " + expandedUrl);
} catch (IllegalArgumentException e) {
System.out.println("Error: " + e.getMessage());
}
}
scanner.close();
}
}