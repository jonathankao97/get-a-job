public class SearchRange34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] { -1, -1 };
        }
        int left = binarySearch(nums, target, 0, nums.length - 1, -1);
        int right = binarySearch(nums, target, 0, nums.length - 1, 1);
        return new int[] { left, right };
    }

    public int binarySearch(int[] nums, int target, int left, int right, int direction) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            if (direction == -1) {
                int rec = binarySearch(nums, target, left, mid - 1, direction);
                return rec == -1 ? mid : rec;
            } else {
                int rec = binarySearch(nums, target, mid + 1, right, direction);
                return rec == -1 ? mid : rec;
            }
        } else if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, right, direction);
        } else {
            return binarySearch(nums, target, left, mid - 1, direction);
        }
    }
}