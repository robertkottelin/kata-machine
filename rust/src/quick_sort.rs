fn qs(arr: &mut Vec<i32>, lo: usize, hi: usize) {
    if lo <= hi {
        let pivot_idx = partition(arr, lo, hi);
        qs(arr, lo, pivot_idx - 1);
        qs(arr, pivot_idx + 1, hi);
    }
}

fn partition(arr: &mut Vec<i32>, _lo: usize, hi: usize) -> usize {
    let pivot = arr[hi];
    let mut i = _lo;
    for j in _lo..hi {
        if arr[j] <= pivot {
            arr.swap(i, j);
            i += 1;
        }
    }

    arr.swap(hi, i);

    i
}

pub fn quick_sort(arr: &mut Vec<i32>) {
    qs(arr, 0, arr.len() - 1);
}