public class MaxHeap<T extends Comparable<? super T>> implements
		MaxHeapInterface<T>, java.io.Serializable {	
	/**
	 * @author Gavin Fennelly
	 * @version 1 Created: 01/005/2016
	 * @Last edited: 10/05/2016
	 */
	
	private static final long serialVersionUID = 1L;
	private T[] heap; // array of heap entries
	private int lastIndex; // index of last entry
	private static final int DEFAULT_INITIAL_CAPACITY = 100;

	public MaxHeap() {
		this(DEFAULT_INITIAL_CAPACITY); // call next constructor
	} // end default constructor

	public MaxHeap(T[] entries) {
		heap = (T[]) new Comparable[entries.length + 1];
		lastIndex = entries.length;
		// copy given array to data field
		for (int index = 0; index < entries.length; index++)
			heap[index + 1] = entries[index];
		// create heap
		for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)
			reheap(heap, rootIndex, entries.length);
	} // end constructor

	public MaxHeap(int initialCapacity) {
		heap = (T[]) new Comparable[initialCapacity + 1];
		lastIndex = 0;
	} // end constructor

	public void add(T newEntry) {
		lastIndex++;

		int newIndex = lastIndex;
		int parentIndex = newIndex / 2;
		while ((parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0) {
			heap[newIndex] = heap[parentIndex];
			newIndex = parentIndex;
			parentIndex = newIndex / 2;
		} // end while
		heap[newIndex] = newEntry;
	} // end add

	public T removeMax() {
		T root = null;
		if (!isEmpty()) {
			root = heap[1]; // return value
			heap[1] = heap[lastIndex]; // form a semi-heap
			lastIndex--; // decrease size
			reheap(heap, 1, lastIndex); // transform to a heap
		} // end if
		return root;
	} // end removeMax

	public T getMax() {
		T root = null;
		if (!isEmpty())
			root = heap[1];
		return root;
	} // end getMax

	public boolean isEmpty() {
		return lastIndex < 1;
	} // end isEmpty

	public int getSize() {
		return lastIndex;
	} // end getSize

	public void clear() {
		for (; lastIndex > -1; lastIndex--)
			heap[lastIndex] = null;
		lastIndex = 0;
	} // end clear


	// end MaxHeap

	private static <T extends Comparable<? super T>> void reheap(T[] heap,
			int rootIndex, int lastIndex) {
		boolean done = false;
		T orphan = heap[rootIndex];
		int leftChildIndex = 2 * rootIndex + 1;
		while (!done && (leftChildIndex <= lastIndex)) {
			int largerChildIndex = leftChildIndex;
			int rightChildIndex = leftChildIndex + 1;
			if ((rightChildIndex <= lastIndex)
					&& heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0) {
				largerChildIndex = rightChildIndex;
			} // end if
			if (orphan.compareTo(heap[largerChildIndex]) < 0) {
				heap[rootIndex] = heap[largerChildIndex];
				rootIndex = largerChildIndex;
				leftChildIndex = 2 * rootIndex + 1;
			} else
				done = true;
		} // end while

		heap[rootIndex] = orphan;
	} // end reheap

	private static <T extends Comparable<? super T>> void swap(T[] heap, int i,
			int j) {
		T t = heap[i];
		heap[i] = heap[j];
		heap[j] = t;
	}

	public static <T extends Comparable<? super T>> void heapSort(T[] array,
			int n) {
		// create first heap
		for (int rootIndex = n / 2 - 1; rootIndex >= 0; rootIndex--)
			reheap(array, rootIndex, n - 1);
		swap(array, 0, n - 1);
		for (int lastIndex = n - 2; lastIndex > 0; lastIndex--) {
			reheap(array, 0, lastIndex);
			swap(array, 0, lastIndex);
		} // end for
	} // end heapSort

	// Searches for the word by searching for Spanish only.
	//Temporary variable in array
	public T search(T t) {
		for (int i = 1; i <= lastIndex; i++) {
			T s = heap[i];
			if (s.equals(t)) {
				return s;
			}
		}
		return null;
	}

	public T get(int i) {
		return heap[i];
	}
}
	