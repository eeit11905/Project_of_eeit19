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
		System.out.println("�п�J�Ʀr�G");
		int n = sc.nextInt();
		System.out.print(n+"="); // �i��e�b�������C�L
		
		// ���X�P�_�j��
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
		/*System.out.println(n); // ��ܥ��L�X���O�̫�@�Ӽ�}*/
/*public static void main(String args[]) {
int i, n = 60, sum = 0; //i=�]�� n=�ϥΪ̿�J��
Scanner scanner = new Scanner(System.in);
System.out.print("�п�J�@�ӭ� :");
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
System.out.print("\n�`�X = " + sum);
}*/

/*�{�����R�G��n�i����ѽ�]�ơA�������@�ӳ̤p�����k�A�M����U�z�B�J�����G
(1)�p�G�o�ӽ�ƫ굥��n�A�h�������ѽ�]�ƪ��L�{�w�g�����A���L�X�Y�i�C
(2)�p�Gn > k�A��n��Qk�㰣�A�h�����L�Xk���ȡA�å�n���Hk����,�@���s������ƧAn,���ư���Ĥ@�B�C
(3)�p�Gn����Qk�㰣�A�h��k+1�@��k����,���ư���Ĥ@�B�C

�b�D�N���R�M������A�A�n��Ҫ��N�O�o���D�i�H�Τ������I�����A���Ѽg�A�M��b�h�g�{���X�A�p�G�o��
�ˤ��M���A�޿�P�_���ǽT�A�N�L�q�U��A�o�O�o�X�ѥǪ��̤j�����D
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�п�J�Ʀr�G");
		int n = sc.nextInt();
		System.out.print(n+"="); // �i��e�b�������C�L
		
		// ���X�P�_�j��
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
		
		
		System.out.println(n); // ��ܥ��L�X���O�̫�@�Ӽ�
		
		*/


