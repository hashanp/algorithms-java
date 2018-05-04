public class CutRod {
	public static void main(String[] args) {
		int[] prices = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
		for(int i = 1; i <= 10; i++) {
			System.out.println(cutRod(prices, i));
		}
	}
	
	public static int cutRod(int[] prices, int n) {
		int[] cache = new int[n + 1];
		cache[0] = 0;
		for(int i = 1; i <= n; i++) {
			int maxPrice = 0;
			for(int j = 1; j <= i; j++) {
				int currentPrice = prices[j - 1] + cache[i - j];
				if(maxPrice < currentPrice) {
					maxPrice = currentPrice;
				}
			}
			cache[i] = maxPrice;
		}
		return cache[n];
	}
}
