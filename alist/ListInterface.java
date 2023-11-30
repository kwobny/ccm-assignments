public interface ListInterface<T> {
	public int size();
    public boolean isEmpty();

	public T get(int pos) throws ListException;
	public void set(T val, int pos) throws ListException;
    public T[] toArray();
    public int find(T val, int start, int end) throws ListException;

	public void add(T val) throws ListException;
    public void add(T val, int position) throws ListException;
	public T remove(int pos) throws ListException;
    public void clear();
}