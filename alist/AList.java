public class AList<T> implements ListInterface<T> {
    private T[] backing;
    private int size;

    public AList() {
        this(0);
    }
    private AList(int size) {
        if (size < 0) {
            throw new RuntimeException();
        }
        if (size >= 1) {
            backing = (T[]) new Object[size];
        }
        this.size = 0;
    } //end of Constructor

    @Override
    public T get(int pos) throws ListException {
        if (size == 0) {
            throw new ListException("Error. Unable to get. List is empty.");
        }
        if (pos < 1 || pos >= size + 1) {
            throw new ListException("Error. Unable to get. Bad position.");
        }
        return backing[pos];
    }
    @Override
    public void set(T val, int pos) throws ListException {
        if (val == null) {
            throw new ListException
        }
        if (pos < 0 || pos >= size) {
            throw new ListException("index out of bounds");
        }
        backing[pos] = val;
    }

    public void add(T m) throws ListException {
        if (m == null) {
            throw new ListException("Cannot add. Null is not allowed.");
        }
        if (backing == null || size == backing.length) {
            resize();
        }
        backing[size] = m;
        size++;
    }//end of add

    // pos is the position of the item after insert.
    public void insert(int pos, T item) throws ListException {
        if (item == null) {
            throw new ListException("Cannot insert. Nulls not allowed");
        }
        if (pos < 0 || pos > size) {
            throw new ListException("Cannot insert. Position invalid.");
        }
        if (backing == null || size == backing.length){
            resize();
        }
        System.arraycopy(backing, pos, backing, pos + 1, size - pos);
        backing[pos] = item;
        size++;
    }//end of insert

    // pos is the position of the item to delete.
    public T delete(int pos) throws ListException{
        if (pos < 0 || pos >= size) {
            throw new ListException("index out of bounds.");
        }
        T temp = backing[pos];
        System.arraycopy(backing, pos + 1, backing, pos, size - pos - 1);
        size--;
        return temp;
    }

    private void resize(){
        int capacity;
        if (backing == null) {
            capacity = 0;
        } else {
            capacity = backing.length;
        }
        try {
            T[] temp = (T[]) new Object[capacity + 10];
            if (backing == null) {
                System.arraycopy(backing, 0, temp, 0, backing.length);
            }
            backing = temp;
        }
        catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
    }//end of resize

    public int size(){
        return size;
    }//end of size

    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("[");
        for (int i = 0; i < size; i++) {
            if (backing[i] == null) {
                continue;
            }
            ret.append(backing[i]);
            if (i != size - 1) {
                ret.append(", ");
            }
        }
        ret.append("]");
        return ret.toString();
    }//end of toString
}