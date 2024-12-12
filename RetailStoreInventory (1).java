//Joshua Anthony Parrocha
//November 11,2024

public class RetailStoreInventory {
    public static void main(String[] args) {
        
        
        //Using arrays to store stock levels
        
	//int for arrays stock levels
	int[] stocklevels = {20,30,40,50,60,70,80,90,95};
        
	//double for arrays prices
	double[] prices ={110.00,120.00,130.00,140.00,150.00,160.00,170.35,90.55,900.60,99.99};
        
        //variable to store the total stock value
        double totalValue = 0;
        
        //calculation for total of stock value
        for(int i = 0; i < stocklevels.length; i++){
            totalValue  = stocklevels[i] * prices[i];
        }
        
        //display the total stock value
        System.out.println("The total value of all items in stock is : PHP " + totalValue );
    }
}

