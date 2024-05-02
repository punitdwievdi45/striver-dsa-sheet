package dp.stocks;

// so here in this program we need to buy and sell stock with max profit.
//index represents the day here 0 is day 1 1 is day 2 and so on. So, if you see the array the max profit will be
//if the customer buy stock at day 2 and sell it on day 7 that will be 7-1
// So, below logic to implement above.

public class BuyAndSellStock {

    public static void main(String[] args) {
        // Create an array of stock prices for each day
        int[] arr = {8, 1, 5, 3, 6, 7};

        // Call the maxProfitOfStock function to find the maximum profit
        int maxProfit = maxProfitOfStock(arr);

        // Print the maximum profit that can be made
        System.out.println("Maximum profit that can be made: " + maxProfit);
    }

    private static int maxProfitOfStock(int[] arr) {
        // Initialize the minimum price of a stock as the first element in the array
        int minPrice = arr[0];

        // Initialize the maximum profit as 0
        int maxProfit = 0;

        // Loop through the stock prices starting from the second day
        for (int i = 1; i < arr.length; i++) {
            // Calculate the potential profit for buying on the first day (minPrice) and selling on the current day (arr[i])
            int currentProfit = arr[i] - minPrice;

            // Update the maximum profit if the current potential profit is higher than the previous maximum profit
            maxProfit = Math.max(currentProfit, maxProfit);

            // Update the minimum price if the current price is lower than the previously recorded minimum
            minPrice = Math.min(minPrice, arr[i]);
        }

        // Return the maximum profit that can be made by buying and selling a stock once in the given array
        return maxProfit;
    }
}

