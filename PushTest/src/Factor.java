package ex2;
import java.util.Scanner;
public class Factor {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Please enter Number!");
		int n = scn.nextInt();
		for(int i =1;i<=n;i++ ) {
			if(n%i == 0) {
				System.out.println(i);
				
			}
		}
		
	}
	
}
/*public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入數字：");
		int n = sc.nextInt();
		System.out.print(n+"="); // 進行前半部分的列印
		
		// 做出判斷迴圈
		for(int k=2;k<=n;k++) {
			while(n!=k) {
				if(n%k==0) {
					System.out.print(k+"*");
					n=n/k;
				}else{
					break;
				}
			}
		}
		
*/		
		/*System.out.println(n); // 表示打印出的是最後一個數}*/
/*public static void main(String args[]) {
int i, n = 60, sum = 0; //i=因數 n=使用者輸入值
Scanner scanner = new Scanner(System.in);
System.out.print("請輸入一個值 :");
n = scanner.nextInt();
int count = 0 ;
for (i = 1; i <= n; i++) {
if (n % i == 0) {
sum += i;
count += 1;
System.out.print(i + " ");
if (count % 4 == 0) {
System.out.println();
}
}
}
System.out.print("\n總合 = " + sum);
}*/

/*程式分析：對n進行分解質因數，應先找到一個最小的質數k，然後按下述步驟完成：
(1)如果這個質數恰等於n，則說明分解質因數的過程已經結束，打印出即可。
(2)如果n > k，但n能被k整除，則應打印出k的值，並用n除以k的商,作為新的正整數你n,重複執行第一步。
(3)如果n不能被k整除，則用k+1作為k的值,重複執行第一步。

在題意分析清楚之後，你要思考的就是這個題可以用什麼知識點完成，怎麼書寫，然後在去寫程式碼，如果這些
弄不清楚，邏輯判斷不準確，就無從下手，這是這幾天犯的最大的問題
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入數字：");
		int n = sc.nextInt();
		System.out.print(n+"="); // 進行前半部分的列印
		
		// 做出判斷迴圈
		for(int k=2;k<=n;k++) {
			while(n!=k) {
				if(n%k==0) {
					System.out.print(k+"*");
					n=n/k;
				}else{
					break;
				}
			}
		}
		
		
		System.out.println(n); // 表示打印出的是最後一個數
		
		*/


