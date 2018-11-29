package GIS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GISProject implements GIS_project {

	ArrayList<GIS_layer> arr = new ArrayList<>();
	
	public void print()
	{
		System.out.println(arr.toString());
	}
	
	public boolean add(GIS_layer arg0) {
	return	arr.add(arg0);
	}

	public boolean addAll(Collection<? extends GIS_layer> arg0) {
		return arr.addAll(arg0);
	}

	@Override
	public void clear() {
		arr.clear();
		
	}

	@Override
	public boolean contains(Object arg0) {
		return arr.contains(arg0);
		
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		
		return arr.containsAll(arg0);
	}

	@Override
	public boolean isEmpty() {
return arr.isEmpty();
	}

	@Override
	public Iterator<GIS_layer> iterator() {
return arr.iterator();
	}

	@Override
	public boolean remove(Object arg0) {
		return arr.remove(arg0);
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
return arr.removeAll(arg0);
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
return arr.retainAll(arg0);
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
	public <T> T[] toArray(T[] arg0) {
return arr.toArray(arg0);
	}

	@Override
	public Meta_data get_Meta_data() {
		// TODO Auto-generated method stub
		return null;
	}

}
