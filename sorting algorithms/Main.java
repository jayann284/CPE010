import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter size of array: ");
		int size = scanner.nextInt();
		int[] arr = new int[size];
		
		System.out.println("Enter array elements: ");
		for (int i = 0; i < size; i++) {
			arr[i] = scanner.nextInt();
		}
		
		ArrayListInput arrayListInput = new ArrayListInput(arr);
		arrayListInput.createArrayList();
		scanner.close();
	}
}

class ArrayListInput {
	private int[] arr;
	
	public ArrayListInput(int[] arr) {
		this.arr = arr;
	}
	
	public void createArrayList() {
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (int value : arr) {
			arrayList.add(value);
		}
		
		SortingAlgorithms sortingAlgorithms = new SortingAlgorithms(arrayList);
		sortingAlgorithms.displayArrays();
		sortingAlgorithms.mergeSort();
		sortingAlgorithms.quickSort();
		sortingAlgorithms.bucketSort();
		sortingAlgorithms.radixSort();
		sortingAlgorithms.bubbleSort();
	}
}

class SortingAlgorithms {
    private ArrayList<Integer> arrayList;
    
    public SortingAlgorithms(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }
    
    public void mergeSort() {
        System.out.println("Merge Sort");
        mergeSort(arrayList, 0, arrayList.size() - 1);
        System.out.println("Sorted ArrayList: " + arrayList);
    }

    private void mergeSort(ArrayList<Integer> list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Recursively sort the left and right halves
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);

            // Merge the sorted halves
            merge(list, left, mid, right);
        }
    }

    private void merge(ArrayList<Integer> list, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        ArrayList<Integer> leftArray = new ArrayList<>();
        ArrayList<Integer> rightArray = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            leftArray.add(list.get(left + i));
        }
        for (int j = 0; j < n2; j++) {
            rightArray.add(list.get(mid + 1 + j));
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray.get(i) <= rightArray.get(j)) {
                list.set(k, leftArray.get(i));
                i++;
            } else {
                list.set(k, rightArray.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            list.set(k, leftArray.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            list.set(k, rightArray.get(j));
            j++;
            k++;
        }
    }
    
    public void quickSort() {
        System.out.println("Quick Sort");
        quickSort(arrayList, 0, arrayList.size() - 1);
        System.out.println("Sorted ArrayList: " + arrayList);
    }

    private void quickSort(ArrayList<Integer> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);

            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }

    private int partition(ArrayList<Integer> list, int low, int high) {
        int pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j) <= pivot) {
                i++;
                Collections.swap(list, i, j);
            }
        }

        Collections.swap(list, i + 1, high);
        return i + 1;
    }
	public void bucketSort() {
        System.out.println("Bucket Sort");
        int max = Collections.max(arrayList);
        int min = Collections.min(arrayList);
        int range = max - min + 1;

        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(range);
        for (int i = 0; i < range; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int num : arrayList) {
            buckets.get(num - min).add(num);
        }

        arrayList.clear();
        for (ArrayList<Integer> bucket : buckets) {
            arrayList.addAll(bucket);
        }

        System.out.println("Sorted ArrayList: " + arrayList);
    }


    public void radixSort() {
        System.out.println("Radix Sort");
        int max = Collections.max(arrayList);
        int exp = 1;

        while (max / exp > 0) {
            countingSortByDigit(exp);
            exp *= 10;
        }

        System.out.println("Sorted ArrayList: " + arrayList);
    }

    private void countingSortByDigit(int exp) {
        int n = arrayList.size();
        int[] output = new int[n];
        int[] count = new int[10];

        Arrays.fill(count, 0);

        for (int num : arrayList) {
            count[(num / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arrayList.get(i) / exp) % 10] - 1] = arrayList.get(i);
            count[(arrayList.get(i) / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            arrayList.set(i, output[i]);
        }
    }
	
	public void bubbleSort() {
        System.out.println("Bubble Sort");
        int n = arrayList.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arrayList.get(j) > arrayList.get(j + 1)) {
                    Collections.swap(arrayList, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break; // If no swaps occurred in an iteration, the list is already sorted
            }
        }
        System.out.println("Sorted ArrayList: " + arrayList);
    }


    public void displayArrays() {
        System.out.println("Array: " + Arrays.toString(arrayList.toArray()));
        System.out.println("ArrayList: " + arrayList);
    }
}
