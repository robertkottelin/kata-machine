// if xi <= xi+1 == true, the array is sorted 

fn bubble_sort(arr: &mut Vec<i32>) {
    // Loop through the entire array.
    for i in 0..arr.len() {
        // Loop through the entire array again, but stop one element short.
        for j in 0..arr.len() - 1 {
            // If the current element is greater than the next element, swap them.
            if arr[j] > arr[j + 1] {
                let temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}