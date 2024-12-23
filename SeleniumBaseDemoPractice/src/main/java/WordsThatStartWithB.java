import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class WordsThatStartWithB {
	
	public static void main(String args[]) {
		List<String> listOfNames = List.of("Benny", "Bob", "Kathy", "Benny", "Chris", "Tom", "Harry");
		TreeMap<String, Long> countOfNames = listOfNames.stream().filter(x -> x.startsWith("B")).collect(Collectors.groupingBy(i->i,TreeMap::new,Collectors.counting()));

		for (Map.Entry<String, Long> e : countOfNames.entrySet()) {
			System.out.println(e.getKey() + "  " + e.getValue());
		}
		
	}
	
}
