package arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Exemplos {

	public static void main(String[] args) {
		List<Long> lista = new ArrayList<>();
		 
		lista.add(1L);
		lista.add(2L);
		lista.add(1, 3L);
		
		List<Integer> list = new ArrayList<>(
				  IntStream.range(0, 10).boxed().collect(toCollection(ArrayList::new))
				);
				ListIterator<Integer> it = list.listIterator(list.size());
				List<Integer> result = new ArrayList<>(list.size());
				while (it.hasPrevious()) {
				    result.add(it.previous());
				}
				 
				Collections.reverse(list);	
				
				List<String> list = LongStream.range(0, 16)
						  .boxed()
						  .map(Long::toHexString)
						  .collect(toCollection(ArrayList::new));
						List<String> stringsToSearch = new ArrayList<>(list);
						stringsToSearch.addAll(list);

						List<String> copy = new ArrayList<>(stringsToSearch);
						Collections.sort(copy);
						int index = Collections.binarySearch(copy, "f");
						
						
						List<Integer> list = new ArrayList<>(
								  IntStream.range(0, 10).boxed().collect(toCollection(ArrayList::new))
								);
								Collections.reverse(list);
								 
								list.remove(0);
								assertThat(list.get(0), equalTo(8));
								 
								list.remove(Integer.valueOf(0));
						
	}

}
