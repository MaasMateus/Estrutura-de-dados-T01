package Lista01;

public class MainListaEstatica {

	public static void main(String[] args) {


		int[] teste = new int[1];

		teste[0] = 12;

		System.out.println(teste);

		teste[0] = 1;

		System.out.println(teste);

		System.out.println(teste[0]);

		System.out.println(new int[]{1, 2, 4} == new int[]{1,2,4});
		
	}

}
