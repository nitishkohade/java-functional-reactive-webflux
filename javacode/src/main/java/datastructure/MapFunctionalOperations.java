package datastructure;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MapFunctionalOperations {

	public static void main(String[] args) {
		
		Map<String, String> contacts = new HashMap<String, String>();
		
		contacts.put("123444454", "John");
		contacts.put("1233445984", "John");
		contacts.put("1896433354", "Neal");
		contacts.put("125683454", "Mayank");
		contacts.put("1115634454", "Abhra");
		contacts.put("1076544554", "Jane");
		
		for(Map.Entry<String, String> entry: contacts.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		contacts.forEach((k, v) -> System.out.println(k + " " + v));
		
		Map<String, String> filteredContacts = contacts.entrySet().stream()
		.filter(contact -> "John".equals(contact.getValue()))
		.collect(Collectors.toMap(c -> c.getKey(), c -> c.getValue()));
		
		contacts.entrySet().stream()
		.distinct()
		.map(c -> c.getValue())
		.collect(Collectors.joining(","));
		
		LinkedHashMap<String, String> sortedMap = contacts.entrySet().stream()
		.sorted(Entry.comparingByValue())
		.collect(Collectors.toMap(
				c -> c.getKey(), 
				c -> c.getValue(), 
				(v1, v2) -> v1, 
				LinkedHashMap::new)
		);
		
		Map<String, Double> marks = new HashMap<>();
		
		marks.values().stream()
			.mapToDouble(m -> m)
			.average();
		

	}

}
