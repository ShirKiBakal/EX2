package GIS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class GISLayer implements GIS_layer {


	ArrayList<GIS_element> arr = new ArrayList<>();


	public GISLayer(ArrayList<GISElement> arr2) // gets the whole string from a file using Csv2Kml.readFromCsv()
	{
		for (int i = 0; i < arr2.size(); i++) {
			this.arr.add(arr2.get(i));
		}	

	}


	@Override
	public boolean add(GIS_element e) {
		return arr.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends GIS_element> c) {
		return arr.addAll(c);
	}

	@Override
	public void clear() {
		arr.clear();

	}

	@Override
	public boolean contains(Object o) {
		return arr.contains(o);

	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return arr.containsAll(c);
	}

	@Override
	public boolean isEmpty() {
		return arr.isEmpty();
	}

	@Override
	public Iterator<GIS_element> iterator() {
		return arr.iterator();
	}

	@Override
	public boolean remove(Object o) {
		return arr.remove(o);

	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return arr.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return arr.retainAll(c);
	}

	@Override
	public int size() {
		return arr.size();
	}

	@Override
	public Object[] toArray() {
		return arr.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return arr.toArray(a);
	}

	@Override
	public Meta_data get_Meta_data() {
		//TODO
		return null;
	}

}
