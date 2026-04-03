package InterviewQuestions;

public class InterviewQ19_TrappingRainWater {
    public static void main(String[] args) {

        Integer height[] = {4, 2, 0, 3, 2, 5};

        System.out.println("Trapping Rain Water with Two Pointer approach: " + trapWithTwoPointer(height));

        System.out.println("Trapping Rain Water with Prefix Suffix approach: " + trapWithPrefixSuffix(height));
    }

    //1. Two Pointer Approach
    public static int trapWithTwoPointer(Integer[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int result = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    result += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    result += rightMax - height[right];
                }
                right--;
            }
        }
        return result;
    }

    //2. Prefix & Suffix Max Arrays Approach
    public static int trapWithPrefixSuffix(Integer[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int water = 0;

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Integer.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Integer.max(rightMax[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            water += Integer.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;
    }
}
