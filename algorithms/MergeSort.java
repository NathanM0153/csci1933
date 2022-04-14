public void merge(int[] array, int left, int mid, int right) {
	int leftLen = mid - left - 1;
	int rightLen = right - mid;
	int[] leftArr = new int[leftLen];
	int[] rightArr = new int[rightLen];
	int leftIndex = 0;
	int rightIndex = 0;
	for (int i = 0; i<leftLen; i++) {
		leftArr[i] = array[left+i];
	}
	for (int i = 0; i<rightLen; i++) {
		rightArr[i] = array[left+i];
	}
	for (int i = left; i<right+1; i++) {
		if (leftIndex < leftLen && rightIndex < rightLen) {
			if (leftArr[leftIndex] < rightArr[rightIndex]) {
				array[i] = leftArr[leftIndex];
				leftIndex++;
			} else {
				array[i] = rightArr[rightIndex];
				rightIndex++;
			}
		}
	}
}

public void mergeSort(int[] array, int left, int right) {
	if (right <= left) {
		return; //return type is void
	}
	int mid = (left+right)/2;
	mergeSort(array, left, mid);
	mergeSort(array, mid+1, right);
	merge(array, left, mid, right);
}

