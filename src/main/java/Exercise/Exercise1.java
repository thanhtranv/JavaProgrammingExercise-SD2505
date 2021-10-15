package Exercise;

public class Exercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,5,3,9,15,20,1,17};
		int max = 0;
		
		for (int i = 0; i < A.length; i++) { 
			for (int j = 1; j < A.length - 1; j++) {
				int result = A[j] - A[i];
				if (result > max && j > i) {
					max = result;
				}
			}
		}
		
		System.out.println("Max value : " + max);
	}

}
