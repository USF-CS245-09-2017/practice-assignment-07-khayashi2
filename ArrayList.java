
public class ArrayList<T> implements List<T>{
	private int maxSize;
	private int currSize;
	private ArrayList<T> data;
	
	private Object[] array;
	public static final int DEFAULT_SIZE = 20;
	private int size = 0;
	
	public ArrayList(){
	    this(DEFAULT_SIZE);
	}

	
	public ArrayList(int maxSize) {
		array = new Object[maxSize];
	}

	@Override
	public void add(T item) {
		ensureCapacity();
	    array[size++] = item;
	}

	@Override
	public void add(int pos, T item) {
		Assert.notFalse(pos <= currSize, "Can't insert outside bounds of array");
		ensureCapacity();
	    array[size++] = item;
		
		
	}

	@Override
	public T get(int pos) {
		Assert.notFalse(pos >= 0 && pos < currSize, "Index not in list");
	    @SuppressWarnings("unchecked")
		T element = (T) array[pos];
	    return element;
	}

	@Override
	public T remove(int pos) {
		Assert.notFalse(pos >= 0 && pos < currSize, "Index not in list");
		@SuppressWarnings("unchecked")
		T element = (T) array[pos];
	    --size;
	    System.arraycopy(array, pos + 1, array, pos, size - pos);
	    array[size] = null;
	    return element;
	}

	@Override
	public int size() {
		return currSize;
	}
	
	private void ensureCapacity(){
	    if(size < array.length){ return;}
	    resize();
	}

	private void resize(){
	    Object[] temp = new Object[array.length*2];
	    copy(array,temp);
	    array = temp;
	}
	
	private void copy(Object[] src, Object[] dest){
	    if(dest.length< src.length){throw new RuntimeException(src+ " cannot be copied into "+dest);}
	    for(int i=0;i<src.length; i++){
	        dest[i] = src[i];
	    }   
	}


}
