class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> l = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) {
            l.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            l.set(nums[i], 0);
        }
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) == 0) {
                l.remove(i);
                i--;
            }
        }
        return l;
    }
}
